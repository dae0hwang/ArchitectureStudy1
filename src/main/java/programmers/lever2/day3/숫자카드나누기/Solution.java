package programmers.lever2.day3.숫자카드나누기;

import java.util.*;
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{10, 17}, new int[]{5, 20});
    }
    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> aDivisors = findDivisors(arrayA);
        aDivisors.sort(Comparator.reverseOrder());
        List<Integer> bDivisors = findDivisors(arrayB);
        bDivisors.sort(Comparator.reverseOrder());
        //가장 큰게 먼저 출력되기 때문에 나오는 즉시 retrun하자
        int a = 0;
        int b = 0;
        //이제 약수 리스트로 상대방 배열 나눠지는 것 없다면 return
        for (Integer aDivisor : aDivisors) {
            boolean check = true;
            for (Integer bInt : arrayB) {
                if (bInt % aDivisor == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                a = aDivisor;
                break;
            }
        }

        for (Integer bDivisor : bDivisors) {
            boolean check = true;
            for (Integer aInt : arrayB) {
                if (aInt % bDivisor == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                b = bDivisor;
                break;
            }
        }
        return Math.max(a, b);
    }

    //각 배열 중 가장 작은 값 나눌 수 있는 값 구하기
    public List<Integer> findDivisors(int[] arr) {
        List<Integer> divisors = new ArrayList<>();
        Arrays.sort(arr);
        int num = arr[0];
        for (int i = 2; i <= num; i++) {
            boolean check = true;
            for (int i1 : arr) {
                if (i1 % i != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                divisors.add(i);
            }
        }
        return divisors;
    }
}
