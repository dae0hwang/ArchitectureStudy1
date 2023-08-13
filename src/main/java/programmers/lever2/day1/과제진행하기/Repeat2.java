package programmers.lever2.day1.과제진행하기;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Repeat2 {
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

    public String[] solution(String[][] plans) {
        List<String> result = new ArrayList<>();
        Stack<Assignment> stack = new Stack<>();




        String[] answer = {};
        return answer;
    }
}
