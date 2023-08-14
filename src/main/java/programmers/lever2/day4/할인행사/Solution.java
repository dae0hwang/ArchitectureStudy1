package programmers.lever2.day4.할인행사;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1},
            new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana",
                "pork", "rice", "pot", "banana", "apple", "banana"});
    }
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < number.length; i++) {
            map.put(want[i], number[i]);
        }

        int count = 0;
        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> resetMap = new HashMap<>(map);
            for (int j = 0; j < 10; j++) {
                //0부터 9까지 더해줘
                String nowFood = discount[i + j];
                if (resetMap.containsKey(nowFood)) {
                    if (resetMap.get(nowFood) == 1) {
                        resetMap.remove(nowFood);
                    } else {
                        resetMap.put(nowFood, resetMap.get(nowFood) - 1);
                    }
                }
            }
            if (resetMap.isEmpty()) {
                count++;
            }
            //여기서 체크해 map이 비워져 있다면 sum += i+1
        }
        return count;
    }
}
