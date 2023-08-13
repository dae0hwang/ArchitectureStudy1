package programmers.lever2.day3.귤고르기;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int k, int[] tangerine) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Collection<Integer> values = map.values();
        System.out.println(values);
        List<Integer> collect1 = values.stream().sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        System.out.println(collect1);

        int i = 0;
        while (true) {
            k -= collect1.get(i);
            i++;
            if (k < 0) {
                break;
            }
        }
        return i + 1;
    }
}
