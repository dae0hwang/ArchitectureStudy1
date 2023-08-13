package programmers.lever2.day2.디펜스게임;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int count = 0;
        for (int i : enemy) {
            q.add(i);
            count++;
            n -= i;
            if (n < 0) {
                if (k == 0) {
                    return count - 1;
                }
                k--;
                n += q.poll();

            }
        }
        return count;
    }
}
