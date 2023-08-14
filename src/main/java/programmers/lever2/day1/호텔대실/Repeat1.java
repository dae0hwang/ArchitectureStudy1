//package programmers.lever2.day1.호텔대실;
//
//import java.util.Arrays;
//import java.util.PriorityQueue;
//
//public class Repeat1 {
//
//    public static void main(String[] args) {
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        q.add(4);
//        q.add(5);
//        System.out.println(q.poll());
//    }
//    public int solution(String[][] book_time) {
//        int answer = 0;
//        int count = 1; //첫 번째 방은 빼자 그리고 모든 방 +10분하자 크지만 않으면 된다 뒤에 시간이
//        int[][] arr = new int[book_time.length][2];
//        for (int i = 0; i < book_time.length; i++) {
//            String[] strings = book_time[i];
//            arr[i][0] = strToIntTime(strings[0]);
//            arr[i][1] = strToIntTime(strings[1])+10;
//        }
//        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int i = 0; i < arr.length; i++) {
//            if (pq.isEmpty()) {
//                pq.add(arr[i][1]);
//                continue;
//            }
//            if (pq.peek())
//        }
//
//        return count;
//    }
//
//    public int strToIntTime(String str) {
//        String[] split = str.split(":");
//        return 60 * Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
//    }
//
//}
