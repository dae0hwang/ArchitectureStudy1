package programmers.lever2.day5.전력망을둘로나누기;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});

    }
    public int solution(int n, int[][] wires) {
        int answer = -1;
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < wires.length; i++) {
            for (int j = 0; j < wires.length; j++) {
                if (j == i) {
                    continue;
                }
                int first = wires[j][0];
                int second = wires[j][1];
                //비어 있다면
                if (list.isEmpty()) {
                    HashSet<Integer> integers = new HashSet<>();
                    integers.add(first);
                    integers.add(second);
                    list.add(integers);
                } else {
                    for (Set<Integer> set : list) {
                        if (set.contains(first) || set.contains(second)) {
                            set.add(first);
                            set.add(second);
                        }
                    }
                }
            }
            //이제 라스트로
            int LastFirst = wires[i][0];
            int LastSecond = wires[i][1];
            boolean firstCheck = false;
            boolean secondtCheck = false;
            for (Set<Integer> set : list) {
                if (set.contains(LastFirst)) {
                    firstCheck = true;
                    set.add(LastFirst);
                }
                if (set.contains(LastSecond)) {
                    secondtCheck = true;
                    set.add(LastSecond);
                }
            }
            if (!firstCheck) {
                Set set1 = new HashSet<Integer>();
                set1.add(LastFirst);
                list.add(set1);
            }
            if (!secondtCheck) {
                Set set2 = new HashSet<Integer>();
                set2.add(LastSecond);
                list.add(set2);
            }
            System.out.println(i);
            for (Set<Integer> set : list) {
                System.out.println(set);
            }
            list.clear();

        }
        return answer;
        //인접 행렬과 BFS로 찾아보자 끊어진 쪽만 찾으면되니깐 ㅇㅇ
    }
}
