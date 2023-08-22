package programmers.lever2.day11.프렌즈4블록;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    static class Data {
        int x, y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Data data = (Data) o;
            return x == data.x && y == data.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        while (true) {
            Set<Data> set = new HashSet<>();
            for (int i = 0; i < map.length - 1; i++) {
                for (int j = 0; j < map[0].length - 1; j++) {
                    char a = map[i][j];
                    char b = map[i][j + 1];
                    char c = map[i+1][j + 1];
                    char d = map[i + 1][j];
                    if (a == b && a == c && a == d && a!='a') {
                        set.add(new Data(i,j));
                        set.add(new Data(i, j+1));
                        set.add(new Data(i+1, j+1));
                        set.add(new Data(i+1, j));
                    }
                }
            }
            //비어 있으면 더이상 할게 없는 것이다.
            if (set.isEmpty()) {
                break;
            }

            //비어있지 않으면 1. 찾은 것들 'a' 로 만들어 빈공간 처리하기
            answer += set.size();
            for (Data data : set) {
                map[data.x][data.y]='a';
            }
            //2. map 빈공간 없도록 쭈욱 내리기
            sol(map);
        }

        return answer;
    }

    //아래쪽부터 쭈욱 내려주기
    public void sol(char[][] map) {
        for (int i = map.length - 1; i >= 0; i--) {
            for (int j = 0; j < map[0].length; j++) {
                //자신보다 밑에 a찾기
                int findRow = -1;
                for (int k = i+1; k < map.length; k++) {
                    if (map[k][j]=='a') {
                        findRow = k;
                    }
                }
                if (findRow>0) {
                    map[findRow][j] = map[i][j];
                    map[i][j] = 'a';
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(4,5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"} );
    }
}
