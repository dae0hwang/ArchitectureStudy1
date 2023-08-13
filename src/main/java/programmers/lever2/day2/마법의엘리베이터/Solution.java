package programmers.lever2.day2.마법의엘리베이터;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(2554);
    }
    public int solution(int storey) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            if (storey == 0) {
                break;
            }
            int least = storey % 10;
            list.add(least);
            storey = storey / 10;
        }
        int sum = 0;
        int next = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            if (next == 1) {
                integer++;
            }
            if (integer == 5) {
                if (i != list.size() - 1 && list.get(i + 1) >= 5) {
                    //더해주는 쪽으로 하기 //앞의 숫자가 5여도 올리는 게 좋다.
                    next = 1;
                    sum += 5;
                } else {
                    //나머지 경우는 빼는 쪽으로하기
                    sum += 5;
                    next = 0;
                }
            } else if (integer < 5) {
                sum += integer;
                next = 0;
            } else {
                sum += (10 - integer);
                next = 1;
            }
        }
        return sum;
    }
}
