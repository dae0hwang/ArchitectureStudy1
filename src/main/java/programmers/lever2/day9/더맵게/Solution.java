package programmers.lever2.day9.더맵게;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i : scoville) {
            pQ.add(i);
        }
        while (true) {
            if (pQ.peek()>=K) {
                break;
            }
            if (pQ.size()<2) {
                return -1;
            }
            int a = pQ.poll();
            int b = pQ.poll();
            pQ.add(a+b*2);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
    }
}
