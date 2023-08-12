package programmers.lever2.day2.숫자변환하기2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(10, 40, 5);
    }
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        set.add(x);
        q.add(x);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer nowNum = q.poll();
                if (nowNum == y) {
                    return count;
                }
                if (y >= nowNum + n && !set.contains(nowNum + n)) {
                    q.add(nowNum + n);
                    set.add(nowNum + n);
                }
                if (y >= nowNum * 2 && !set.contains(nowNum * 2)) {
                    q.add(nowNum * 2);
                    set.add(nowNum * 2);
                }
                if (y >= nowNum * 3 && !set.contains(nowNum * 3)) {
                    q.add(nowNum * 3);
                    set.add(nowNum * 3);
                }
            }
            count++;
        }
        return -1;
    }
}
