package programmers.lever2.day10.주식가격;

import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer[]> stack = new Stack<>();

        for(int i = 0; i < prices.length; i++){
            answer[i] = answer.length - 1 - i; // 최대기간으로 세팅
            Integer[] arr = {i, prices[i]}; // 인덱스, 가격

            while(!stack.empty() && stack.peek()[1] > prices[i]){ // 가격이 떨어진 경우
                Integer[] price = stack.pop();
                answer[price[0]] = i - price[0];
            }

            stack.push(arr);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{1, 2, 3, 2, 3});
    }
}
