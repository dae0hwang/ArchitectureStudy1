package programmers.lever2.day15.땅따먹기;

import java.util.Arrays;

public class Solution2 {
    int solution(int[][] land) {
        int answer = 0;
        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }
        System.out.println("Arrays.deepToString(land) = " + Arrays.deepToString(land));
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length-1][i]);
        }
        return answer;
    }
}
