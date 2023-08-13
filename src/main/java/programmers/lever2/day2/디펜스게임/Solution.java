package programmers.lever2.day2.디펜스게임;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int n, int k, int[] enemy) {

        Integer[] newArr = Arrays.stream(enemy).boxed().toArray(Integer[]::new);
        Arrays.sort(newArr, Collections.reverseOrder());

        //q에 넣어서 최고의 맨 앞이면 k쓰도록하고 아니면 말고
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : enemy) {
            q.add(i);
        }
        //큰수부터 빠져나오도록
        int count = 0;
        for (int i = 0; i < enemy.length; i++) {
            //count 어디다 할지도 중요하다
            int enemyNum = enemy[i];
            Integer peek = q.peek();
            if (enemyNum == peek && k != 0) {
                k--;
                q.poll();
                count++;
                continue;
            }
            //경우의 수가 많다
            if (enemyNum < n && k != 0) {
                k--;
                count++;
                continue;
            }
            if (enemyNum > n && k == 0) {
                break;
            }
            if (enemyNum != peek && enemyNum <= n) {
                n -= enemyNum;
                count++;
                continue;
            }
        }
//        int answer = 0;
        return count;
    }
}
