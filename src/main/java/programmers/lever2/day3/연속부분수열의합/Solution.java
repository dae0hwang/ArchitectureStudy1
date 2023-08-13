package programmers.lever2.day3.연속부분수열의합;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{7, 9, 1, 1, 4});

    }

    public int solution(int[] elements) {
        int answer = 0;
        int len = elements.length;
        int[] plusArr = new int[elements.length * 2];
        for (int i = 0; i < plusArr.length; i++) {
            plusArr[i] = elements[i % elements.length];
        }
        Set<Integer> result = new HashSet<>();
        System.out.println(Arrays.toString(plusArr));
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                int checkI = i;
                int sum = 0;
                int idx = j;
                while (checkI > 0) {
                    sum += plusArr[idx];
                    idx++;
                    checkI--;
                }
                result.add(sum);
            }
        }

        System.out.println(result.size());

        return answer;
    }
}
