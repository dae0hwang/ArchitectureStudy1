package programmers.lever2.day5.전력망을둘로나누기;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    static boolean[] visited;
    static List<ArrayList<Integer>> grab;
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int solution = s.solution(9,
            new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
        System.out.println(solution);
    }
    public int solution(int n, int[][] wires) {
        grab = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            grab.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            grab.get(a).add(b);
            grab.get(b).add(a);
        }
        int answer = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            visited = new boolean[n + 1];
            visited[1] = true;
            dfs(1, a, b);
            int count= 0;
            for (boolean b1 : visited) {
                if (b1) {
                    count++;
                }
            }
            int abs = Math.abs(n - (2 * count));
            answer = Math.min(abs, answer);
        }
        return answer;
    }

    public void dfs(int n, int a, int b) {
        for (Integer i : grab.get(n)) {
            if ((i == a && n == b) || (i == b && n == a)||visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(i, a, b);
        }
    }
}
