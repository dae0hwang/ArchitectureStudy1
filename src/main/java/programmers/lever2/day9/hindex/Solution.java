package programmers.lever2.day9.hindex;

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        //뒤에서 부터 찾기
        int[] reverse = new int[citations.length];
        for (int i = 0; i < citations.length; i++) {
            reverse[citations.length - i - 1] =citations[i];
        }
        for (int i = 0; i < reverse.length; i++) {
            int count = 0;
            int num = reverse[i];
            for (int j = 0; j < citations.length && num<=reverse[j]; j++) {
                count++;
            }
            if (count >= num) {
                return count;
            }
        }
        return answer;
    }

}
