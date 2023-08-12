package programmers.lever2.day1.광물캐기;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{1, 3, 2},
            new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron",
                "stone"});

    }

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int num = picks[0] + picks[1] + picks[2];
        int[][] section = new int[minerals.length / 5 + 1][3];
        int i, pick;
        for(i = 0; i < minerals.length && num > 0; i++) {
            switch(minerals[i].charAt(0))
            {
                case 'd':
                    section[i / 5][0] += 1;
                    section[i / 5][1] += 5;
                    section[i / 5][2] += 25;
                    break;
                case 'i':
                    section[i / 5][0] += 1;
                    section[i / 5][1] += 1;
                    section[i / 5][2] += 5;
                    break;
                case 's':
                    section[i / 5][0] += 1;
                    section[i / 5][1] += 1;
                    section[i / 5][2] += 1;
            }
            if(i % 5 == 4) num--;
        }
        System.out.println(Arrays.deepToString(section));

        Arrays.sort(section, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        System.out.println(Arrays.deepToString(section));

        pick = 0;
        for (int j = 0; j < section.length; j++) {
            while (pick < 3 && picks[pick] == 0) {
                pick++;
            }
            if (pick == 3) {
                break;
            }
            picks[pick]--;
            answer += section[j][pick];
        }
        return answer;
    }
}
