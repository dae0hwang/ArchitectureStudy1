package programmers.lever2.day2.뒤에있는큰수;

import java.util.Arrays;
import java.util.Stack;

public class Repeat2 {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1); // 초기값을 -1로 세팅
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.peek()] = numbers[stack.peek()];
                stack.pop();
            }
            stack.push(i);
        }
        return answer;
    }
}
