package programmers.lever2.day1.요격시스템;

import java.util.Arrays;

public class Repeat1 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, ((o1, o2) -> o1[0] - o2[0]));
        int preStart = 0;
        int preEnd = 0;
        int cnt = 0;
        for (int[] target : targets) {
            //포함된다면
            if (preEnd > target[0]) {
                preStart = target[0];
                preEnd = Math.min(preEnd, target[1]);
            } else {
                cnt++;
                preStart = target[0];
                preEnd = target[1];
            }
        }
        return cnt;
    }
}
