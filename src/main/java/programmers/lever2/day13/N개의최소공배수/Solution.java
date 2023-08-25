package programmers.lever2.day13.N개의최소공배수;

import java.util.Arrays;

public class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int min = arr[0];
        int x = 1;
        int result = 0;
        while (true) {
            int sumX = min * x;
            boolean check = true;
            for (int i : arr) {
                if (sumX % i != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                result = sumX;
                break;
            }
            x++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{2, 6, 8, 14});
    }
}
