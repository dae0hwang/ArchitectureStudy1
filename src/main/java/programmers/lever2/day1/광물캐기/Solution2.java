package programmers.lever2.day1.광물캐기;

import java.util.Arrays;
import java.util.Comparator;

/*
* 다른 사람 풀이 - 다시 한번 내가 풀어보기*/
public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.solution(new int[]{1, 0, 0},
            new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron",
                "stone", "diamond","diamond"});
    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        //minerals 길이가 5의 배수의 경우 실제 필요한 길이보다 +1 배열이 추가된다.
        //피로도를 구하는 거라 크게 상관이 없다.
        int[][] section = new int[minerals.length / 5 + 1][3];
        int num = picks[0] + picks[1] + picks[2];
        for (int i = 0; i < minerals.length && num > 0; i++) {
            switch (minerals[i].charAt(0)) {
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
                    break;
            }
            //여기가 중요하다 곡객이 총 개수
            if (i % 5 == 4) {
                num--;
            }
        }
        //돌로 캘 경우 가장 피로도가 많이 쌓이는 것이 우선적으로 올 수 있도록 정렬하기
        Arrays.sort(section, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        //이제 다이아몬드 곡괭이로 순서대로 캐기
        int pick = 0;
        for (int i = 0; i < section.length; i++) {
            while (pick < 3 && picks[pick] == 0) {
                pick++;
            }
            if (pick == 3) {
                break;
            }
            picks[pick]--;
            answer += section[i][pick];
        }
        return answer;
    }
}
