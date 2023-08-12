package programmers.lever2.day1.요격시스템;

import java.util.Arrays;

public class 요격시스템 {

    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};

        /*
        * 먼저 배열 0번째 위치로 오름차순 배열을 한다면,
        * 앞 배열의 끝점과 뒤 배열의 앞점만 비교해서 하나의 라인에 포함되는 지만 보면 된다.
        * 다만 포함된다고 했을 때, 변경된 유지 거리로 바꿔줘야 한다.
        * 즉 preStart는 두 값중 큰 것을 preEnd는 두 값중 작은 값으로 유지거리를 조정해놔야 한다.
        * */
        Arrays.sort(targets, (o1, o2) -> o1[0] - o2[0]);
        int answer = 0;
        int preStart = targets[0][0];
        int preEnd = targets[0][1];
        for (int[] target : targets) {
            if (answer == 0) {
                answer++;
                continue;
            }
            int curStart = target[0];
            int curEnd = target[1];
            if (preEnd > curStart) {
                preStart = Math.max(preStart, curStart);
                preEnd = Math.min(preEnd, curEnd);
            } else {
                answer++;
                preStart = curStart;
                preEnd = curEnd;
            }
        }
        System.out.println(answer);
    }

    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[0] - o2[0]);
        int answer = 0;
        int preStart = targets[0][0];
        int preEnd = targets[0][1];
        for (int[] target : targets) {
            if (answer == 0) {
                answer++;
                continue;
            }
            int curStart = target[0];
            int curEnd = target[1];
            if (preEnd > curStart) {
                preStart = Math.max(preStart, curStart);
                preEnd = Math.min(preEnd, curEnd);
            } else {
                answer++;
                preStart = curStart;
                preEnd = curEnd;
            }
        }

        return answer;
    }
}
