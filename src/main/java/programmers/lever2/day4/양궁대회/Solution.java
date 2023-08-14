package programmers.lever2.day4.양궁대회;

import java.util.Arrays;

public class Solution {
    int v;
    int[] result = new int[11];

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(5, null);
    }
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        v = n;
        DFS(0, new int[10]);
        return answer;
    }

    public void DFS(int n, int[] result) {
        if (n == v) {
            //이제 여기서 점수를 구해
            System.out.println(Arrays.toString(result));
        } else {
            for (int i = 0; i <= 10; i++) {
                result[i]++;
                DFS(n + 1, result);
                result[i]--;
            }
        }
    }

}
