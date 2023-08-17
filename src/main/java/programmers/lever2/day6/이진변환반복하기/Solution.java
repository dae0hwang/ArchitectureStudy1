package programmers.lever2.day6.이진변환반복하기;

public class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int sum = 0;
        int resultCount = 0;
        while (s.length() != 1) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (aChar == '0') {
                    count++;
                } else {
                    sb.append(aChar);
                }
            }
            resultCount++;
            sum += count;
            s = Integer.toBinaryString(sb.toString().length());
        }
        return new int[]{resultCount, sum};
    }
}
