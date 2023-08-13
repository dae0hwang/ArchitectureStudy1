package programmers.lever2.day1.광물캐기;

import java.util.Arrays;
import java.util.Comparator;

public class Repeat1 {

    public static void main(String[] args) {
        Repeat1 s = new Repeat1();
        int solution = s.solution(new int[]{1, 3, 2},
            new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron",
                "stone"});
        System.out.println(solution);
    }

    public int solution(int[] picks, String[] minerals) {
        //미네랄들을 5개씩 쪼갠 값을 저장한다.
        int len = minerals.length / 5 + 1;
        int[][] arr = new int[len][3];
        for (int i = 0; i < minerals.length; i++) {
            int idx = i / 5;
            String mineral = minerals[i];
            if (mineral.equals("diamond")) {
                arr[idx][0] += 1;
                arr[idx][1] += 5;
                arr[idx][2] += 25;
            } else if (mineral.equals("iron")) {
                arr[idx][0] += 1;
                arr[idx][1] += 1;
                arr[idx][2] += 5;
            } else {
                arr[idx][0] += 1;
                arr[idx][1] += 1;
                arr[idx][2] += 1;
            }
        }
//        System.out.println(Arrays.deepToString(arr));
        Arrays.sort(arr, (o1, o2) -> o2[2] - o1[2]);
        //정렬가지오케이
//        System.out.println(Arrays.deepToString(arr));
        //여기까지 완성
        //광물이 다 없어지거나, 곡괭이 다 없어질 때까지
        int sum = 0;
        int count = 0; //이게 다 떨어져도 멈추는 거다.
        //
        int pick = 0;
        for (int i = 0; i < arr.length; i++) {
            while (pick < 3 && picks[pick] == 0) {
                pick++;
            }
            if (pick == 3) {
                break;
            }
            picks[pick]--;
            sum += arr[i][pick];
        }


        //
        return sum;
    }
}
