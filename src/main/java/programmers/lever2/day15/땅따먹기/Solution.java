package programmers.lever2.day15.땅따먹기;

public class Solution {
    static boolean visit[][];
    static int N, ans = 0;
    int solution(int[][] land) {
        visit = new boolean[land.length][4];
        N = land.length;
        dfs(0, 0, land);
        int answer = ans;
        return answer;
    }

    public static void dfs(int r, int sum, int[][] land) {
        if (r == N) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (!visit[r][i]) {
                sum += land[r][i];
                if (r < N - 1) {
                    visit[r + 1][i] = true;
                }
                dfs(r + 1, sum, land);
                if (r < N - 1) {
                    visit[r + 1][i] = false;
                }
                sum -= land[r][i];
            }
        }
    }
}
