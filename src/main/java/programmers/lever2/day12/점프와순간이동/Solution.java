package programmers.lever2.day12.점프와순간이동;

import java.util.Arrays;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int[] arr = new int[n+1];
        arr[1] =1;
        //arr[0] 은 그냥 0으로 남겨두고
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[i - 1] + 1;
            }
        }

        return arr[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(5000);
    }
}
