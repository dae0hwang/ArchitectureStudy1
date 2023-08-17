package programmers.lever2.day6.쿼드압축후개수세기;

public class Solution {

    public int[] solution(int[][] arr) {
        int n = arr.length;//이게 2n승이다.
        boolean[][] check = new boolean[n][n];
        int divide = 2; //나눠지는 한행의 길이를 나타내기 위해
        for (int i = n; i > 0; i = i / 2) {
            int row = i / divide;
            for (int j = 0; j < divide * 2; j++) {
                //4개 -> 8개 이런식으로 늘어난다 식이 끝나고 divide로 *2해줘야 한다.

            }



        }

        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        int n = 1024;
        for (int i = n; i > 0; i /= 2) {
            System.out.println(i);
        }
    }
}
