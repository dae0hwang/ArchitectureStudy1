package programmers.lever2.day14.피보나치수;

import java.util.Arrays;

public class Solution {

    static int[] arr = new int[100001];

    public int solution(int n) {
        int answer = 0;
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;
        return (int)(dfs(n) % 12345678);
    }

    public int dfs(int n) {
        if (arr[n] != -1) {
            return arr[n];
        }
        return arr[n] = (dfs(n - 1) + dfs(n - 2))%1234567;
    }

    public int solution2(int n) {
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }
        return arr[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution2(3);
    }
}
