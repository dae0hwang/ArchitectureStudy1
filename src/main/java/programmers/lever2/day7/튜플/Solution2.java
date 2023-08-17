package programmers.lever2.day7.튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2 {
    public int[] solution(String s) {
        String substring1 = s.substring(2);
        int length = substring1.length();
        String substring2 = substring1.substring(0, length - 2);
        //System.out.println(substring2);
        String replace = substring2.replace("},{", "-");
        String[] split = replace.split("-");
        Arrays.sort(split, (o1, o2) -> o1.length()-o2.length());
        List<Integer> list = new ArrayList<>();
        int[] answer=  new int[split.length];
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            String[] split1 = s1.split(",");
            for (String s2 : split1) {
                int i1 = Integer.parseInt(s2);
                if (!list.contains(i1)) {
                    list.add(i1);
                    answer[i] =i1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }

}
