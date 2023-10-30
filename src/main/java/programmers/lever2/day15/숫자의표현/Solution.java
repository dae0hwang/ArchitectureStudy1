package programmers.lever2.day15.숫자의표현;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        int lt = 1;
        int sum = 0;
        int k = 0;
        for (int rt = 1; rt <= n; rt++) {
            sum += arr[rt];
            if (sum == n) {
                k++;
            }
            while (sum > n) {
                sum -= arr[lt++];
                if (sum == n) {
                    k++;
                }
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(15);
    }
}
