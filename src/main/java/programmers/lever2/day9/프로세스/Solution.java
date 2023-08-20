package programmers.lever2.day9.프로세스;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    static class Data {
        int location, priority;

        public Data(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int count = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer integer : priorities) {
            pq.add(integer);
        }
        Queue<Data> q= new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Data(i, priorities[i]));
        }

        while (!q.isEmpty()) {
            Integer peek = pq.peek();
            Data nowData = q.poll();
            if (nowData.priority==peek) {
                if (nowData.location==location) {
                    return count;
                }
                pq.poll();
                count++;
            }else {
                q.add(nowData);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        s.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }
}
