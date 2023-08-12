package programmers.lever2.day1.호텔대실;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
    }
    public int solution(String[][] book_time) {
        int r = book_time.length;
        int c = book_time[0].length;
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                String s = book_time[i][j];
                String[] split = s.split(":");
                if (j == 1) {
                    map[i][j] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]) + 10;
                } else {
                    map[i][j] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(map));
        Arrays.sort(map, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(map));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] timeTemp  : map) {
            if(queue.size() == 0){
                queue.add(timeTemp [1]);
                continue;
            }
            if((queue.peek()) <= timeTemp[0]){
                queue.poll();
                queue.add(timeTemp[1]);
            }else{
                queue.add(timeTemp[1]);
            }
        }

        return queue.size();
    }
}
