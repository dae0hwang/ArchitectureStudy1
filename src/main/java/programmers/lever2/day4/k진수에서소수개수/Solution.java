package programmers.lever2.day4.k진수에서소수개수;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(110011, 10);
    }
    public int solution(int n, int k) {
        //k진법 변환





        int answer = -1;
        String s = Integer.toString(n, k);
//        char[] chars = s.toCharArray();
        String ss = "1111";
        String[] split = ss.split("0");
//        System.out.println(Arrays.toString(split));
        String[] split1 = s.split("0");
        System.out.println(Arrays.toString(split1));
        int result = 0;
        for (String s1 : split1) {
            //s1이 소수이냐 이것만 판별하면 된다.
            System.out.println(s1);
            int i = Integer.parseInt(s1);
            if (isPrime(i)) {
                result++;
            }
        }
        System.out.println(result);
        return result;
    }

    public boolean isPrime(int a) {
        if (a == 1) {
            return false;
        }
        if (a == 2) {
            return true;
        }
        for (int i = 2; i <= (int)Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
