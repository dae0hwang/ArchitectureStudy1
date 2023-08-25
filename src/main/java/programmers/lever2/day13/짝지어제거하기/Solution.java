package programmers.lever2.day13.짝지어제거하기;

import java.util.Stack;

public class Solution {
    public int solution(String s) {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.isEmpty()) {
                stack.push(aChar);
                continue;
            }
            Character peek = stack.peek();
            if (peek == aChar) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("cbaabcaa");
    }
}
