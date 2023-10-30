package level2_2.day1.요격시스템;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int solution(int[][] targets) {
        Arrays.sort(targets);
        int answer = 0;
        int preStart = targets[0][0];
        int preEnd = targets[0][1];
        for (int[] target : targets) {
            if (answer == 0) {
                answer++;
                continue;
            }
            int curStart = target[0];
            int cuEnd = target[1];
            if (preEnd > curStart) {
                preStart = Math.max(preStart, curStart);
                preEnd = Math.min(preEnd, cuEnd);
            } else {
                answer++;
                preStart = curStart;
                preEnd = cuEnd;
            }
        }
        return answer;
    }
}
