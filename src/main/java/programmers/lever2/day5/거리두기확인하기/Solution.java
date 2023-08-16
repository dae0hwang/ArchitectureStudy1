package programmers.lever2.day5.거리두기확인하기;

import java.util.Arrays;

public class Solution {

    static int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};
    public static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        for (int i = 0; i < 5; i++) {
            String[] place = places[i];
            char[][] map = makeMap(place);
            //발견되는 즉시 0 삽입과 함께 break
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (map[j][k] != 'P') {
                        continue;
                    }
                    Pos start = new Pos(j, k);
                    for (int l = 0; l < 8; l++) {
                        int nx = start.x + dx[l];
                        int ny = start.y + dy[l];
                        if (nx > 0 && nx < 5 && ny > 0 && ny < 5 && map[nx][ny] != 'X'
                            && map[nx][ny] != 'O') {
                            //P를 발견한 것이다.
                            //1번 양 옆인 경우 바로 끝
                            int abs = Math.abs(start.x - nx) + Math.abs(start.y - ny);
                            if (abs == 1) {
                                answer[i] = 0;
                                break;
                            }else {
                                //대각선에서 발견한 경우
                                if (map[start.x + dx[l]][start.y] == 'O'
                                    || map[start.x][start.y + dy[l]] == 'O') {
                                    answer[i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                    int[] mi2 = {0, 0, 2, -2};
                    int[] mj2 = {2, -2, 0, 0};
                    for (int d = 0; d < 4; d++) {
                        int ni = start.x + mi2[d];
                        int nj = start.y + mj2[d];
                        if(ni<0 || ni>=5 || nj<0 || nj>=5) continue;
                        if(map[ni][nj]=='P') {
                            if(map[(i+ni)/2][((j+nj)/2)]!='X'){
                                answer[i] = 0;
                                break;
                            }
                        }
                    }
                }
            }

        }
        return answer;
    }

    public char[][] makeMap(String[] strArr) {
        char[][] map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = strArr[i].charAt(j);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        System.out.println("solution = " + Arrays.toString(solution));

    }
}
