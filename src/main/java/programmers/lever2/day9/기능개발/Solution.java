package programmers.lever2.day9.기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        //List<Integer> list = new ArrayList<>();
        int[] arr = new int[progresses.length];
//        for (int i = progresses.length-1; i >=0 ; i--) {
//            int num = progresses[i];
//            int speed = speeds[i];
//            int day = (int) Math.ceil((double)(100-num)/speed);
////            stack.add(day);
////            queue.add(day);
//            arr[progresses.length - 1 - i] = day;
//        }

        for (int i = 0; i < progresses.length; i++) {
            int num = progresses[i];
            int speed = speeds[i];
            int day = (int) Math.ceil((double)(100-num)/speed);
            arr[i] = day;
        }
        System.out.println(Arrays.toString(arr));
        boolean[] visited = new boolean[arr.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            int count = 1;
            visited[i] = true;
            for (int j = i+1; j < arr.length && arr[j]<=arr[i]; j++) {
                count++;
                visited[j] =true;
            }
            result.add(count);
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
//        System.out.println(Math.ceil((double) 70/30));
//        System.out.println(Math.ceil((double) 60/30));
        Solution s = new Solution();
        s.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }
}
