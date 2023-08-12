package programmers.lever2.day1.과제진행하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/*
* 하나씩 차근히 풀어가는 문제이다.
* 다시 한번 풀어보자.
* */
public class Solution {

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.solution(new String[][]
//            {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
//    }

    public String[] solution(String[][] plans) {
        Assignment[] assignments = new Assignment[plans.length];
        for (int i = 0; i < assignments.length; i++) {
            assignments[i] = new Assignment(plans[i][0], plans[i][1], plans[i][2]);
        }
        List<String> result = new ArrayList<>();
        Arrays.sort(assignments, (o1, o2) -> o1.start - o2.start);
//        System.out.println(Arrays.deepToString(assignments));
        Stack<Assignment> stack = new Stack<>();

        for (int i = 0; i < assignments.length; i++) {
            Assignment current = assignments[i];
            if (i == assignments.length - 1) {
                //마지막 과목은 무조건 끝남
                result.add(current.name);
            } else {
                //마지막 과목이 아닐 때 다음 start 시간과 비교해서 처리를 해줘야해
                int currentStart = current.start;
                int currentTime = current.time;
                int nextStart = assignments[i + 1].start;
                //먼저 충분한 시간이 있을 때
                if (currentStart + currentTime <= nextStart) {
                    result.add(current.name);
                    //스택 안에 값이 있으면 남은 시간동안 빼주면 된다.
                    int nowTime = currentTime + currentStart;
                    if (!stack.isEmpty()) {
                        while (nowTime < nextStart) {
                            Assignment pop = stack.pop();
                            nowTime += pop.time;
                            if (nowTime <= nextStart) {
                                result.add(pop.name);
                            } else {
                                stack.add(new Assignment(pop.name, pop.start, nowTime - nextStart));
                            }
                        }
                    }
                } else {
                    //충분한 시간이 없을 땐 한만큼만 빼고 스택에 넣어주기
                    stack.add(new Assignment(current.name, currentStart,
                        currentTime + currentStart - nextStart));
                }
            }
        }
        //이제 차례대로 나머지 스택들 넣어주기
        while (!stack.isEmpty()) {
            result.add(stack.pop().name);
        }
        return result.toArray(new String[]{});
    }
    static class Assignment {
        String name;
        int start;
        int time;
        @Override
        public String toString() {
            return "Assignment{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", time=" + time +
                '}';
        }
        public Assignment(String name, String start, String time) {
            this.name = name;
            this.start = stringToInt(start);
            this.time = Integer.parseInt(time);
        }

        private int stringToInt(String start) {
            String[] split = start.split(":");
            return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }

        public Assignment(String name, int start, int time) {
            this.name = name;
            this.start = start;
            this.time = time;
        }
    }
}
