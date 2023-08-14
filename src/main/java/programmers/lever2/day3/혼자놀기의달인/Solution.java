package programmers.lever2.day3.혼자놀기의달인;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4});

    }
    class Data {
        int idx, num;
        boolean opened;

        public Data(int idx, int num) {
            this.idx = idx;
            this.num = num;
            this.opened = false;
        }
    }
    public int solution(int[] cards) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        Data[] arr = new Data[cards.length];
        for (int i = 0; i < cards.length; i++) {
            arr[i] = new Data(i, cards[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            int idx = i;
            int sum = 0;
            while (true) {
                if (arr[idx].opened) {
                    break;
                }
                sum++;
                //통과
                arr[idx].opened = true;
                int num = arr[idx].num;
                idx = num-1;
            }
            list.add(sum);
        }

        if (list.size() < 2) {
            return 0;
        }
        Collections.sort(list, Comparator.reverseOrder());
        return list.get(0) * list.get(1);
    }
}
