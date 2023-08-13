package programmers.lever2.day1.과제진행하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Repeat1 {
    static class Data {
        String type;
        int start;
        int time;

        public Data(String type, int start, int time) {
            this.type = type;
            this.start = start;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Data{" +
                "type='" + type + '\'' +
                ", start=" + start +
                ", time=" + time +
                '}';
        }
    }
    public String[] solution(String[][] plans) {
        int length = plans.length;
        Data[] dataArr = new Data[length];
        for (int i = 0; i < length; i++) {
            String[] plan = plans[i];
            String type = plan[0];
            String start = plan[1];
            String time = plan[2];
            String[] split = start.split(":");
            dataArr[i] = new Data(type,
                Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]),
                Integer.parseInt(time));
        }
        //빠른 순으로 정렬하기
        Arrays.sort(dataArr, ((o1, o2) -> o1.start-o2.start));
        System.out.println(Arrays.toString(dataArr));
        Stack<Data> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            //마지막 것은 그냥 넣어주기
            if (i == length - 1) {
                list.add(dataArr[i].type);
                continue;
            }
            Data now = dataArr[i];
            Data next = dataArr[i+1];
            int nowLastTime = now.start + now.time;
            if (now.start + now.time <= next.start) {
                list.add(dataArr[i].type);
                //시간 여유 있다면 스택 비어있지 않다면
                while (!stack.isEmpty()) {
                    Data stackData = stack.peek();
                    if (nowLastTime + stackData.time <= next.start) {
                        list.add(stack.pop().type);
                    } else {
                        Data pop = stack.pop();
                        pop.time = nowLastTime + pop.time - next.start;
                        stack.push(pop);
                    }
                }
            } else {
                now.time = now.start + now.time - next.start;
                stack.push(now);
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop().type);
        }
        System.out.println(list);
        String[] answer = {};
        return answer;
    }
}
