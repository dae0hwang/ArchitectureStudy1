package programmers.lever2.day8.스킬트리;

import java.util.Stack;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
//        Stack<Character> stack = new Stack<>();

        char[] chars = skill.toCharArray();
//        for (int i = chars.length-1; i >=0 ; i--) {
//            stack.add(chars[i]);
//        }

        for (String skillTree : skill_trees) {
            Stack<Character> stack = new Stack<>();
            for (int i = chars.length-1; i >=0 ; i--) {
                stack.add(chars[i]);
            }
            char[] treeChars = skillTree.toCharArray();
            if (isOk(treeChars, stack)) answer++;
        }
        System.out.println(answer);
        return answer;
    }

    public boolean isOk(char[] treeChars, Stack<Character> stack) {
        for (char treeChar : treeChars) {
            if (stack.contains(treeChar)) {
                if (stack.peek()!=treeChar) {
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
    }
}
