package programmers.lever2.day2.시소짝궁;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    static int length = 0;
    static int[] arr = new int[2];
    static int count = 0;

    public long solution(int[] weights) {
        length = weights.length;
        DFS(0, 0, weights);
        return count;
    }

    private void DFS(int n, int k, int[] weight) {
        if (n == 2) {
            //조합을 구했다
            Set<Integer> set = new HashSet<>();
            set.add(arr[0] * 2);
            set.add(arr[0] * 3);
            set.add(arr[0] * 4);
            set.add(arr[1] * 2);
            set.add(arr[1] * 3);
            set.add(arr[1] * 4);
            if (set.size() < 6) {
                count++;
            }
        } else {
            for (int i = k; i < length; i++) {
                arr[n] = weight[i];
                DFS(n+1, i+1, weight);
            }
        }
    }
}
