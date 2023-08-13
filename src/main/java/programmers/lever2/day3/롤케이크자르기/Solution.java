package programmers.lever2.day3.롤케이크자르기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
    }

    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int top : topping) {
            map.put(top, map.getOrDefault(top, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            //1번부터 쭈욱 나간다.
            int nowTopping = topping[i];
            set.add(nowTopping);
            if (map.get(nowTopping) == 1) {
                map.remove(nowTopping);
            } else {
                map.put(nowTopping, map.get(nowTopping)-1);
            }
            //이제 여기서 비교해버려
            if (set.size() == map.keySet().size()) {
                answer++;
            }
        }
        return answer;
    }
}
