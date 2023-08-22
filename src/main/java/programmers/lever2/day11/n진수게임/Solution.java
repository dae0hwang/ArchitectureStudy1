package programmers.lever2.day11.n진수게임;

public class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int num = 0;
        //m명이 t번 말하는 경우까지 구함
        //10을 ->1, 0 각 숫자를 2진수로 만드는 게 아니라, 10 자체를 각 진수별로 표현하는 거였다. 그러면 쉽지
        while (sb.length()< m*t) {
            System.out.println("num = " + num);
            String radixNum = Integer.toString(num++, n);
            System.out.println("radixNum = " + radixNum);
            sb.append(radixNum);
        }
        for (int i = p-1; i < m*t; i+=m) {
            answer.append(sb.charAt(i));
        }
        return answer.toString().toUpperCase();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(16,16,2,1);
    }
}
