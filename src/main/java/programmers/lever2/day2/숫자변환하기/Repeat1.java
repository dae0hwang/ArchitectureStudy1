package programmers.lever2.day2.숫자변환하기;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Repeat1 {
    public int solution(int x, int y, int n) {
        int answer = 0;

        //반복을 줄이기 위한
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        set.add(x);
        while (!q.isEmpty()) {
            int size = q.size();
            answer++;
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                if (now == y) {
                    return answer-1;
                }
                int a = now * 2;
                int b = now * 3;
                int c = now + n;
                if (!set.contains(a) && a <= y) {
                    set.add(a);
                    q.add(a);
                }
                if (!set.contains(b) && b<= y) {
                    set.add(b);
                    q.add(b);
                }
                if (!set.contains(c) && c <= y) {
                    set.add(c);
                    q.add(c);
                }
            }
        }
        return -1;
    }

    public void bfs() {
        Queue<Integer> q = new LinkedList<>();

    }
}
