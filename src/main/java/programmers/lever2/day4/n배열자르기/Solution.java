package programmers.lever2.day4.n배열자르기;

public class Solution {

    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int) (right - left) + 1];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            result[idx++] = Math.max((int)row, (int)col) + 1;
        }
        return result;
    }
}
