package programmers.lever2.day1.무인도여행;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
    }
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public int[] solution(String[] maps) {
        int r = maps.length;
        int c = maps[0].length();
        int[][] board = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                String str = maps[i];
                char charAt = str.charAt(j);
                if (charAt == 'X') {
                    board[i][j] = -1;
                } else {
                    board[i][j] = Character.getNumericValue(charAt);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == -1) {
                    continue;
                }
                int bfs = bfs(i, j, board, r, c);
                result.add(bfs);
            }
        }
        if (result.size() == 0) {
            return new int[]{-1};
        }
        Collections.sort(result);
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }

    //모두
    public int bfs(int x, int y, int[][] board,int r, int c) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));
        int sum = 0;
        sum += board[x][y];
        board[x][y] = -1;
        while (!q.isEmpty()) {
            Pos now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] != -1) {
                    q.add(new Pos(nx, ny));
                    sum += board[nx][ny];
                    board[nx][ny] = -1;
                }
            }
        }
        return sum;
    }
}
