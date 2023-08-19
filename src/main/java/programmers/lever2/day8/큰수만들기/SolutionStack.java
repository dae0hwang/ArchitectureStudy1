package programmers.lever2.day8.큰수만들기;

import java.util.Stack;

public class SolutionStack {
    public String solution(String number, int k) {
        char[] result = new char[number.length()-k];
        Stack<Character> stack = new Stack<>();
        //어차피 앞에 숫자가 가장 큰것이 중요하기 때문에,
        //먼저 k를 다 사용해서 맨 앞쪽에 가장 큰 수를 배치할 수 있도록 설정함
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() <c && k>0) {
                k--;
                stack.pop();

            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        SolutionStack s = new SolutionStack();
        s.solution("4177252841",4);
    }
}
