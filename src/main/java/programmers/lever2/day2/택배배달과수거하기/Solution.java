package programmers.lever2.day2.택배배달과수거하기;

public class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliver = 0, pickup = 0;
        for (int i = n - 1; i >= 0; i++) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                int cnt = 0;
                while (deliver < deliveries[i] || pickup < pickups[i]) {
                    deliver += cap;
                    pickup += cap;
                    cnt++;
                }
                deliver -= deliveries[i];
                pickup -= pickups[i];
                answer += (long) cnt * (i + 1) * 2;
            }
        }
        return answer;
    }
}
