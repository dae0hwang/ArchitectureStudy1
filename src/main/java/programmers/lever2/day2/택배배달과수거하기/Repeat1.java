package programmers.lever2.day2.택배배달과수거하기;

public class Repeat1 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliver = 0;
        int pickup = 0;

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            while (deliver < deliveries[i] || pickup < pickups[i]) {
                count++;
                deliver += cap;
                pickup += cap;
            }
            deliver -= deliveries[i];//남은 것 키핑
            pickup -= pickups[i];
            answer += (long) (i + 1) * count*2;
        }
        return answer;
    }

    public static void main(String[] args) {
        Repeat1 r = new Repeat1();
        long solution = r.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        System.out.println(solution);

    }
}
