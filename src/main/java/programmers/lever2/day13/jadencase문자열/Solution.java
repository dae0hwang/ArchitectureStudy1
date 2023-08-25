package programmers.lever2.day13.jadencase문자열;

public class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' ') {
                first = true;
                sb.append(aChar);
                continue;
            }

            if (first) {
                sb.append(Character.toUpperCase(aChar));
                first = false;
            }else {
                sb.append(Character.toLowerCase(aChar));
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("3Peo  aa  VV");
    }
}
