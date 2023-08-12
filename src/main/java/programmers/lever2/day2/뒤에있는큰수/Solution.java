package programmers.lever2.day2.뒤에있는큰수;

import java.util.Stack;

public class Solution {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            //일단 넣어주고?
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.peek()] = numbers[i];
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}
