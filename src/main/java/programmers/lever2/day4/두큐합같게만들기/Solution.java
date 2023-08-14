package programmers.lever2.day4.두큐합같게만들기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});

    }
    public int solution(int[] queue1, int[] queue2) {
        long q1Sum = Arrays.stream(queue1).sum();
        long q2Sum = Arrays.stream(queue2).sum();

        long sum = q1Sum + q2Sum;
        if (sum % 2 == 1) {
            return -1;
        }
        long half = sum / 2;
        for (int i : queue1) {
            if (i > half) {
                return -1;
            }
        }
        for (int i : queue2) {
            if (i > half) {
                return -1;
            }
        }

        //매사에 최선을 다하는 방법
        Queue<Long> q1 = new LinkedList<>();
        for (int i : queue1) {
            q1.add((long)i);
        }
        Queue<Long> q2 = new LinkedList<>();
        for (int i : queue2) {
            q2.add((long)i);
        }
        //이 정도 세팅해두면 빠꾸날일은 없을 거 같다.
        int count = 0;
        while (true) {
            count++;
            if (count > (q1.size() + q2.size()) * 2) {
                return -1;
            }
            long copyQ1Sum = q1Sum;
            long copyQ2Sum = q2Sum;
            long copyQ1Sum2 = q1Sum;
            long copyQ2Sum2 = q2Sum;
            Long q1Peek = q1.peek();
            Long q2Peek = q2.peek();
            //먼저 q1peek을 넘기기
            copyQ1Sum -= q1Peek;
            copyQ2Sum += q1Peek;
            if (copyQ1Sum == copyQ2Sum) {
                break;
            }
            // q2peek을 넘기기
            copyQ1Sum2 += q2Peek;
            copyQ2Sum2 -= q2Peek;
            if (copyQ1Sum2 == copyQ2Sum2) {
                break;
            }
            //이중에서 정답에 가까워지는 것을 선택
            long first = Math.abs(half - copyQ1Sum) + Math.abs(half - copyQ2Sum);
            long second = Math.abs(half - copyQ1Sum2) + Math.abs(half - copyQ2Sum2);
            if (first > second) {
                //second의 승리이니깐
                q1.add(q2.poll());
                q1Sum = copyQ1Sum2;
                q2Sum = copyQ2Sum2;
            } else {
                q2.add(q1.poll());
                q1Sum = copyQ1Sum;
                q2Sum = copyQ2Sum;
            }
        }
        return count;
    }
}
