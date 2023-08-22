package programmers.lever2.day11.압축;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <=26 ; i++) {
            map.put(String.valueOf((char)(i+64)), i);
        }
        int valueNum = 27;
        char[] chars = msg.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<Integer> list =new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];

            String appendStr = sb.append(aChar).toString();
            //포함하고 있을 경우-> 넘어가
            //포함하지 않을 경우가 할일이 많지

            if (!map.containsKey(appendStr)) {
                map.put(appendStr, valueNum);
                list.add(valueNum++);
            }
        }
        System.out.println(map);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println((char)65);
        System.out.println((int)'A');
        Solution s = new Solution();
        s.solution("aa");
    }
}
