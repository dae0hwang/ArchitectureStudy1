package programmers.lever2.day1.연속된부분수열의합;

import java.util.Arrays;
/*
* 투 포인터 lt rt 로 해결을 했다.
* 연속된 부분 수열 투포인터로 하면 빠르게 풀 수 있구나 느꼈다.
* 양 쪽 끝점이 아닌 두 포인터가 왼쪽에서 오른쪽으로 함께 가는 구조는 for문 사용하는 것이 깔끔하다.
* */
public class Solution {

    public static void main(String[] args) {
        int[] sequence = {2, 2, 2, 2, 2};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(sequence, 6)));
    }

    public int[] solution(int[] sequence, int k) {
        int lt = 0;
        int sum = 0;
        int preRt = Integer.MAX_VALUE; //첫 조건에 만족하는 lt rt 사이의 거리보다 길어야 하기 때문에
        int preLt = 0;
        for (int rt = 0; rt < sequence.length; rt++) {
            sum += sequence[rt];
            if (sum == k) {
                //작은 경우에만 바꿔주면 된다.
                //같은 경우는 기존 preRt preLt를 사용한다.
                if (preRt - preLt > rt - lt) {
                    preRt = rt;
                    preLt = lt;
                }
            }
            while (sum > k) {
                //큰 경우에만 lt 전진
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
