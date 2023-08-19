package programmers.lever2.day8.구명보트;

import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        //작은 것부터 싹 더하는 식으로 하는게 오히려 빠르겠구나
        //최대 두명이구나!!!
        int count = 0;
        int rt = 1;
        boolean[] check = new boolean[people.length];
        for (int lt = 0; lt < people.length; lt++) {
            int sum = 0;
            if (check[lt]) {
                continue;
            }
            sum += people[lt];
            check[lt] = true;
            rt = lt + 1;
            while (sum < limit && rt< people.length) {
                sum += people[rt];
                if (sum > limit) {
                    break;
                }
                check[rt] = true;
                rt++;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{70, 50, 80, 50}, 100);
    }
}
