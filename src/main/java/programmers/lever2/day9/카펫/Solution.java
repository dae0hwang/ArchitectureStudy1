package programmers.lever2.day9.카펫;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        //-2 -2 해서 yellow 값이 나와야 해
        //먼저 sum이 될 수 있는 공약수를 구해야해
        List<Integer[]> list = find(sum);
        for (Integer[] integers : list) {
            //여기서 -2 곱한 값이 yellow나오면 된다.
            int a = integers[0] - 2;
            int b = integers[1] - 2;
            if (a * b == yellow) {
                Arrays.sort(integers, Comparator.reverseOrder());
                return new int[]{integers[0],integers[1]};
            }
        }
        return answer;
    }

    public List<Integer[]> find(int sum) {
        List<Integer[]> list = new ArrayList<>();
        for (int i = 3; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                //큰수는 나오지않는다 해봐야 같은 수 정도
                list.add(new Integer[]{i, sum / i});
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(12));
        System.out.println(Math.sqrt(37));
        Solution s = new Solution();
        List<Integer[]> list = s.find(100);
        for (Integer[] integers : list) {
            System.out.println(Arrays.toString(integers));
        }

    }

}
