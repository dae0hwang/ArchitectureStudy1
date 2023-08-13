package programmers.lever2.day1.과제진행하기;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution2 {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int idx = 0;
        PriorityQueue<Subject> q = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
        for(String[] p:plans){
            q.add(new Subject(p[0], convertTime(p[1]), Integer.parseInt(p[2])));
        }
        Stack<Subject> stack = new Stack<>();
        Subject s = q.poll();
        int now = s.start;
        while(true){
            if (!q.isEmpty() && now + s.playtime > q.peek().start) {
                //과제 중지
                stack.push(new Subject(s.name, s.start, s.playtime - (q.peek().start - now)));

                now = q.peek().start;

                s = q.poll(); //새로운 과제 시작
            } else {
                //과제 끝냄
                answer[idx++] = s.name;
                now += s.playtime;

                //새로 시작해야 하는 과제가 있다면 새로운 과제 시작
                if(!q.isEmpty() && now==q.peek().start){
                    s = q.poll();
                }
                else if(!stack.isEmpty()){
                    //멈춰둔 과제 다시 시작
                    s = stack.pop();
                }
                else if(!q.isEmpty()){
                    s = q.poll();
                    now = s.start;
                }
                else break;
            }
        }



        return null;
    }

    class Subject {
        String name;
        int start, playtime;

        @Override
        public String toString() {
            return "Subject{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", playtime=" + playtime +
                '}';
        }

        Subject(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
    public static int convertTime(String t){
        String[] str = t.split(":");
        int min = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
        return min;
    }
}
