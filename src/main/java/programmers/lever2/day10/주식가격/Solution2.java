package programmers.lever2.day10.주식가격;

public class Solution2 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            answer[i] = prices.length-i-1;
            int nowPrice = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (nowPrice>prices[j]){
                    answer[i] = j-i;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.solution(new int[]{1, 2, 3, 2, 3});
    }
}
