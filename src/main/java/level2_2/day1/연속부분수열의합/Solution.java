package level2_2.day1.연속부분수열의합;

public class Solution {
    public int[] solution(int[] sequence, int k) {
        int lt = 0;
        int sum = 0;
        int preRt = Integer.MAX_VALUE;
        int preLt = 0;
        for (int rt = 0; rt < sequence.length; rt++) {
            sum += sequence[rt];
            if (sum == k) {
                if (preRt - preLt > rt - lt) {
                    preRt = rt;
                    preLt = lt;
                }
            }
            while (sum > k) {
                sum -= sequence[lt];
                lt++;
                if (sum == k) {
                    if (preRt - preLt > rt - lt) {
                        preRt = rt;
                        preLt = lt;
                    }
                }
            }
        }
        return new int[]{preLt, preRt};

    }


}
