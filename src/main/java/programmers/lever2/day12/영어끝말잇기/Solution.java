package programmers.lever2.day12.영어끝말잇기;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        String lastString = words[0];
        Set<String> set = new HashSet<>();
        set.add(lastString);
        int idx = -1;
        for (int i = 1; i < words.length; i++) {
            String str = words[i];
            if (set.contains(str)) {
                idx = i;
                break;
            }
            if (lastString.charAt(lastString.length()-1) != str.charAt(0)) {
                idx = i;
                break;
            }
            lastString = str;
            set.add(str);
        }
        if (idx == -1) {
            return new int[]{0, 0};
        }
        System.out.println("idx = " + idx);
        idx++;
        int temp = idx%n;
        int a = temp==0?n:temp;
        int b = (int)Math.ceil((double)idx/n);
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(3,
            new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot",
                "tank"});
    }
}
