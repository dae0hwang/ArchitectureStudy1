package programmers.lever2.day2.테이블해시함수;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col-1] - o2[col-1] == 0) {
                return o2[0] - o1[0];
            } else {
                return o1[col-1] - o2[col-1];
            }
        });
        System.out.println(Arrays.deepToString(data));
        //정렬은 오케이
        Queue<Integer> q = new LinkedList<>();
        for (int i = row_begin - 1; i < row_end; i++) {
            System.out.println(i);
            int[] datum = data[i];
            int sum = 0;
            for (int i1 : datum) {
                sum += i1 % (i + 1);
            }
            q.add(sum);
        }
        System.out.println(q);
        //해당 내용을 xor하면 된다.
        Integer result = q.poll();
        System.out.println("first = " + result);
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            System.out.println("poll = " + poll);
            result = result ^ poll;
            System.out.println("cal = " + result);
        }

        return result;
    }
}
