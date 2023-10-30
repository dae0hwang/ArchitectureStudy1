package programmers.lever2.day16.onetwothree;

public class Solution {
    public String solution(int n) {
        String answer = "";
        String[] rules = {"4", "1", "2"};
        while (n != 0) {
            answer = rules[n % 3] + answer;
            System.out.println("answer = " + answer);
            if (n % 3 == 0) {
                n--;
            }
            n /= 3;
        }

        return answer;
    }
}
