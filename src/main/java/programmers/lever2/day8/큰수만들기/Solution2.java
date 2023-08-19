package programmers.lever2.day8.큰수만들기;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public String solution(String number, int k) {
        String answer = "";
        //comb 쓰면 안된다 이건!!!
        char[] chars = number.toCharArray();
        int[] intArr = new int[chars.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = chars[i] -'0';
        }
        Arrays.sort(intArr);
        int[] revers = new int[intArr.length];
        for (int i = revers.length-1; i >=0 ; i--) {
            revers[i] = intArr[revers.length-i-1];
        }
        //System.out.println(Arrays.toString(revers));
        int n = number.length()-k;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result *=10;
            result+=revers[i];
        }

        return String.valueOf(result);

        //순서는 다 지켜야하네!!!

    }

}
