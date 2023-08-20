package programmers.lever2.day9.가장큰수;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2);
            }
        });
        if (strArr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strArr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.solution(new int[]{3, 30, 34, 5, 9});
    }
}
