package programmers.lever2.day15.숫자블록;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] solution(long begin, long end) {
        int beginInt = (int) begin;
        int endInt = (int) end;
        int[] answer = new int[(endInt - beginInt + 1)];
        int idx = 0;

        for (int i = beginInt; i <= endInt; i++) {
            //소수 판별
            boolean flag = false;
            if (i == 1) {
                answer[idx++] = 0;
                continue;
            }

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0 && i / j <= 10000000) {
                    answer[idx++] = i / j;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                answer[idx++] = 1;
            }
        }
        return answer;

    }

}
