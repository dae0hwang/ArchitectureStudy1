package programmers.lever2.day1.미로탈출2;

import java.util.LinkedList;
import java.util.Queue;

public class Repeat {

    class Data {
        int x, y,dis;

        public Data(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int row, col;
    char[][] board;

    public int solution(String[] maps) {
        Data start = null;
        Data lever = null;
        Data end = null;
        row = maps.length;
        col = maps[0].length();
        board = new char[row][col];
        boolean[][] visited1 = new boolean[row][col];
        boolean[][] visited2 = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    start = new Data(i, j, 0);
                } else if (c == 'L') {
                    lever = new Data(i, j, 0);
                } else if (c == 'E') {
                    end = new Data(i, j, 0);
                }
                board[i][j] = c;
            }
        }
        int l = bfsLever(start, lever, visited1);
        if (l == -1) {
            return -1;
        }
        int e = bfsLever(lever, end, visited2);
        if (e == -1) {
            return -1;
        }
        return l + e;
    }

    public int bfsLever(Data start, Data end, boolean[][] visited1) {
        Queue<Data> q = new LinkedList<>();
        q.offer(start);
        visited1[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Data now = q.poll();
            if (now.x == end.x && now.y == end.y) {
                return now.dis;
            }
            //아마 여기다가 retrun ㅇㅇ
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited1[nx][ny] && board[nx][ny]!='X') {
                    q.offer(new Data(nx, ny, now.dis + 1));
                    visited1[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}
