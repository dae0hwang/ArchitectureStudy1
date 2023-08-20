package programmers.lever2.day9.hindex;

import java.util.Arrays;

public class Solution2 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.solution(new int[]{3, 0, 6, 1, 5});
    }
}
