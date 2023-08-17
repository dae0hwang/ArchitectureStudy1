package programmers.lever2.day6.괄호회전하기;

import java.util.Stack;

public class Solution {

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                char charAt = s.charAt(0);
                s = s.substring(1) + charAt;
            }
            System.out.println(s);
            if (isO(s)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isO(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == ']'&& stack.peek()=='[') {
                stack.pop();
            } else if (c=='}' && stack.peek()=='{') {
                stack.pop();
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
