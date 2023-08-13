package programmers.lever2.day3.택배상자;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{4, 3, 1, 2, 5});
    }
    public int solution(int[] order) {
        int answer = 0;
        int num = order.length;
        Queue<Integer> orderQue = new LinkedList<>();
        for (int i = 0; i < order.length; i++) {
            orderQue.add(order[i]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= num; i++) {
            q.add(i);
        }
        Stack<Integer> s = new Stack<>();
        //1, 2, 3, 4, 5 이런식으로 실리게 된다.
        int count = 0;
        while (true) {
            Integer sPeek = -1;
            if (!s.isEmpty()) {
                sPeek = s.peek();
            }
            if (orderQue.isEmpty()) {
                break;
            }
            Integer nowHaveTo = orderQue.peek();
            if (q.isEmpty() && !nowHaveTo.equals(sPeek)) {
                break;
            }
            Integer qPeek = -1;
            if (!q.isEmpty()) {
                qPeek = q.peek();
            }
            if (qPeek.equals(nowHaveTo)) {
                orderQue.poll();
                q.poll();
                count++;
            } else {
                //여기서 두 가지로 나뉜다.
                if (sPeek.equals(nowHaveTo)) {
                    s.pop();
                    orderQue.poll();
                    count++;
                } else {
                    s.push(q.poll());
                }
            }

        }



//        for (int i = 0; i < num; i++) {
//            Integer nowHaveTo = orderQue.peek();
//            Integer qPeek = q.peek();
//            Integer sPeek = -1;
//            if (!s.isEmpty()) {
//                sPeek = s.peek();
//            }
//
//            if (qPeek.equals(nowHaveTo)) {
//                orderQue.poll();
//                q.poll();
//                count++;
//            } else {
//                //여기서 두 가지로 나뉜다.
//                if (sPeek.equals(nowHaveTo)) {
//                    s.pop();
//                    orderQue.poll();
//                    count++;
//                } else {
//                    s.push(q.poll());
//                }
//            }
//        }

//        System.out.println(count);



        return count;
    }
}
