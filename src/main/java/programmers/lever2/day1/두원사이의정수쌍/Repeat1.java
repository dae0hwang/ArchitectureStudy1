package programmers.lever2.day1.두원사이의정수쌍;

public class Repeat1 {
    public static void main(String[] args) {
        Repeat1 solution = new Repeat1();
        solution.solution(3, 5);
    }
    public long solution(int r1, int r2) {
        long answer = 0;
        for (int i = 1; i < r2; i++) {
            answer += getMaxY(i, r2, "r2") - getMaxY(i, r1, "r1");
            System.out.println(answer);
        }
        answer *= 4;
        answer += (r2 - r1) * 4; //왜냐하면 5 4 라고 했을 때 4에 점하나 5에 점 하나 찍히니깐 +1 해줘야 한다.
        return answer;
    }
    private int getMaxY(long x, long r, String rName) {
        if (x > r) {
            return 0;
        }
        double max = Math.sqrt(r * r - x * x);
        int maxToInt = (int) max;
        if (rName.equals("r1") && max - maxToInt == 0.0) {
            return maxToInt - 1;
        } else {
            return maxToInt;
        }
    }
}
