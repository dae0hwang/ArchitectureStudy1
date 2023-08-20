package programmers.lever2.day9.가장큰수;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    static class Data {
        int num;
        int firstNum;

        public Data(int num, int firstNum) {
            this.num = num;
            this.firstNum = firstNum;
        }

        @Override
        public String toString() {
            return "Data{" +
                "num=" + num +
                ", firstNum=" + firstNum +
                '}';
        }
    }
    public String solution(int[] numbers) {
        String answer = "";
        Data[] dataArr = new Data[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            dataArr[i] = new Data(numbers[i], findFirstNum(numbers[i]));
         }
        Arrays.sort(dataArr, (o1, o2) -> {
            if (o2.firstNum==o1.firstNum) {
                return o2.num -o1.num;
            }
            return o2.firstNum-o1.firstNum;
        });
        System.out.println(Arrays.toString(dataArr));

        return answer;
    }

    public int findFirstNum(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findFirstNum(10));
        System.out.println(s.findFirstNum(1));
        System.out.println(s.findFirstNum(324));
        s.solution(new int[]{6, 10, 2, 66});
    }
}
