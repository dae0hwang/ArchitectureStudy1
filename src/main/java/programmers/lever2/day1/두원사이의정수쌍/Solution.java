package programmers.lever2.day1.두원사이의정수쌍;

public class Solution {
    /*
    * 먼저 피타고라스 정의로 각 원의 x측면 최대 y값을 구해야 한다.
    * y값을 구했다면 큰 원 y값에서 작은 y값을 빼서 사이의 점 개수를 구한다.
    * 다만 작은 원의 y값이 딱 정수일경우 그 점을 포함해야 하기 때문에 이 점을 고려해야 한다.
    * 마지막 (r2 - r1) * 4 이 식은 작은 원이 전혀 개입되지 않은 큰 값의 x=0일 때 점의 개수이다
    * 디버깅 후 f8로 넘겨가면서 어느정도 이해할 수 있는 수준으로 만들어 놓았다.
    * 다시 아웃풋을 통해 다시 한번 풀 수 있어야 할 것 같다. 특히 이 식은
    * */
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(3, 5);
    }

    public long solution(long r1, long r2) {
        long answer = 0;

        for (int i = 1; i < r2; i++) {
            if (i <= r1) {
                answer += getMaxY(i, r2, "r2") - getMaxY(i, r1, "r1");
            } else {
                answer += getMaxY(i, r2, "r2");
            }
            System.out.println(answer);
        }
        answer *= 4;
        answer += (r2 - r1) * 4; //왜냐하면 5 4 라고 했을 때 4에 점하나 5에 점 하나 찍히니깐 +1 해줘야 한다.
        return answer;
    }

    private int getMaxY(long x, long r, String rName) {
        double max = Math.sqrt(r * r - x * x);
        int maxToInt = (int) max;
        if (rName.equals("r1") && max - maxToInt == 0.0) {
            return maxToInt - 1;
        } else {
            return maxToInt;
        }
    }
}
