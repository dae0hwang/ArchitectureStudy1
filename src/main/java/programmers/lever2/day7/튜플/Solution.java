package programmers.lever2.day7.튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(String s) {
        int length = s.length();
        String substring = s.substring(1, length - 1);
        System.out.println(substring);

        //걍 일자로 쭉도는게 나을거 같다.
        List<Integer[]> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int lastInteger = 0;
        String tempIntegerString = "";
        int count = 0;
        for (int i = 0; i < substring.length(); i++) {
            char charAt = substring.charAt(i);
            if (Character.isDigit(charAt)) {
                //, 뒤에것도 숫자면은 보류 한번더 해야지
                if (Character.isDigit(substring.charAt(i + 1))) {
                    tempIntegerString += charAt;
                } else {
                    if (tempIntegerString.equals("")) {
                        lastInteger = charAt - '0';
                    }else {
                        tempIntegerString += charAt;
                        lastInteger = Integer.parseInt(tempIntegerString);
                        tempIntegerString = "";
                    }
                    count++;

                }
            } else if (charAt == '}') {
                result.add(new Integer[]{count, lastInteger});
                count = 0;
            }
        }
        for (Integer[] integers : result) {
            System.out.println(Arrays.toString(integers));
        }
        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("{{20,111},{111}}");
    }
}
