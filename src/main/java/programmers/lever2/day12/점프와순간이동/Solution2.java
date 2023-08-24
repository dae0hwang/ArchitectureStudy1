package programmers.lever2.day12.점프와순간이동;

import programmers.lever2.day11.프렌즈4블록.Solution;

public class Solution2 {
    public int solution(int n) {
        int ans = 0;
        while (true) {
            if (n == 1) {
                ans++;
                break;
            }
            if (n % 2 == 0) {
                n /= 2;
            }else {
                n -=1;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.solution(6);
    }
}
