package programmers.lever2.day15.다음큰숫자;

public class Solution {
    public int solution(int n) {
        String s = Integer.toBinaryString(n);
        int i = count1(s);
        int num = n + 1;
        while (true) {
            int count = count1(Integer.toBinaryString(num));
            if (i == count) {
                break;
            }
            num++;
        }

        return num;
    }

    public static int count1(String number) {
        int count = 0;
        char[] chars = number.toCharArray();
        for (char aChar : chars) {
            if (aChar == '1') {
                count++;
            }
        }
        return count;
    }
}
