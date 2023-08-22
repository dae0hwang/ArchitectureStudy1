package programmers.lever2.day11.캐시;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        int answer = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            String str = cities[i].toUpperCase();
            if (list.contains(str)) {
                list.remove(str);
                answer += 1;
                list.add(str);
            } else {
                if (list.size() < cacheSize) {
                    list.add(str);
                    answer += 5;
                } else {
                    list.remove(0);
                    answer += 5;
                    list.add(str);
                }
            }
        }
        return answer;
    }
}
