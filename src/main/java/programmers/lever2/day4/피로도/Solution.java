package programmers.lever2.day4.피로도;

public class Solution {
    int length;
    boolean[] visited;
    int result = 0;

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
//    }
    public int solution(int k, int[][] dungeons) {
        length = dungeons.length;
        visited = new boolean[length];
        DFS(0, 0, k, dungeons);
        return result;
    }

    public void DFS(int n , int count, int k, int[][] dungeons) {
        if (n == length) {
            //끝까지 다돌면 끝이다.
            result = length;
        } else {
            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i]) {
                    if (k >= dungeons[i][0]) {
                        visited[i] = true;
                        DFS(n + 1, count + 1, k - dungeons[i][1], dungeons);
                        visited[i] = false;
                    } else {
                        result = Math.max(count, result);
                    }
                }
            }
        }
    }
}
