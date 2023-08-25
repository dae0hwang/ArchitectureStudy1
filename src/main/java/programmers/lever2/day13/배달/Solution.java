package programmers.lever2.day13.배달;

import java.util.Arrays;

public class Solution {
    static final int INF = 500001;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j) continue;
                map[i][j] = INF;
            }
        }
        //자신 빼도는 50001로 설정
        System.out.println(Arrays.deepToString(map));

        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];
            if (map[a][b] > w) {
                map[a][b] = w;
                map[b][a] = w;
            }
        }

        int[] dist = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            dist[i] = (dist[i]==0) ? INF : map[1][i];
        }

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;


        System.out.println(Arrays.deepToString(map));
        System.out.println(Arrays.toString(dist));
        System.out.println("Arrays.toString(visited) = " + Arrays.toString(visited));

        for (int i = 0; i < N - 1; i++) {
            int min_idx = 1;
            int min_value = INF;

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}},
            3);
    }
}
