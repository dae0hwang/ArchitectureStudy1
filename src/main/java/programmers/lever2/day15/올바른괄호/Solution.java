package programmers.lever2.day15.올바른괄호;

import java.util.Stack;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.push(aChar);
            }else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }else {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(aChar);
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}
