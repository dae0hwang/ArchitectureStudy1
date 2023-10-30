package programmers.lever2.day16.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visit = new boolean[5][5];

    static class Data {
        int x, y;

        public  Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] maps) {
        return bfs(maps);

    }

    public static int bfs(int[][] maps) {
        Queue<Data> q = new LinkedList<>();
        q.add(new Data(0, 0));
        visit[0][0] = true;
        int answer = -1;
        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Data now = q.poll();
                for (int j = 0; j < 4; j++) {
                    int tempX = now.x + dx[j];
                    int tempY = now.y + dy[j];
                    if (tempX == 4 && tempY == 4) {
                        return count + 1;
                    }
                    if (tempX >= 0 && tempX < 5 && tempY >= 0 && tempY < 5 && maps[tempX][tempY] == 1 && !visit[tempX][tempY]) {
                        q.add(new Data(tempX, tempY));
                        visit[tempX][tempY] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(bfs(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}}));

    }


}
