package programmers.lever2.day14.최댓값최솟값;

import java.util.Arrays;

public class Solution {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split(" ");
        long[] arr = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Long.parseLong(split[i]);
        }
        Arrays.sort(arr);
        String str = "";
        str += (arr[0] + " " + arr[arr.length-1]);
        return str;
    }
}
