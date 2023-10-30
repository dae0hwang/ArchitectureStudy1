package programmers.lever2.day15.줄서는방법;

import java.util.Arrays;

public class Solution {

    static int[] arr;
    static int count = 1;
    public int[] solution(int n, long k) {
        int[] answer = {};
        //k는 1부터 넣기
        arr = new int[n];
        int[] result = dfs(0, n, 1, n, k);
        return answer;
    }

    public int[] dfs(int depth, int v, int k, int n, long number) {
        if (depth == v) {
            if (count == number) {
                return arr;
            }
        } else {
            for (int i = k; i <= n; i++) {
                arr[depth] = i;
                dfs(depth + 1, v, i + 1, n, number);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[3];
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        Solution s = new Solution();
        s.solution(3, 5);
    }
}
