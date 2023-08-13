package programmers.lever2.day3.우박수열정적분;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(5, new int[][]{{0,0},{0,-1},{2,-3},{3,-3}});
    }
    public double[] solution(int k, int[][] ranges) {
        int num = findK(k);
//        System.out.println(num);
        int[] yArr = makeYArr(num, k);
//        System.out.println(Arrays.toString(yArr));
//        int[] y = new int[num];

        double[] wide = new double[num];
        wide[0] = 0;
        for (int i = 1; i < wide.length; i++) {
            //사다리꼴 넓이까지 오케이
            wide[i] = (double) (yArr[i-1]+yArr[i])/2;
        }
//        System.out.println(Arrays.toString(wide));
        //0항은 0이다.
        double[] sumWide = new double[num];
        for (int i = 1; i < sumWide.length; i++) {
            sumWide[i] = wide[i] + wide[i - 1];
            wide[i] = sumWide[i];
        }
//        System.out.println(Arrays.toString(sumWide));


        double[] answer = new double[ranges.length];
        for(int i=0; i< ranges.length; i++){
            int s = ranges[i][0];
            int e = num + ranges[i][1]-1;

            // s부터 e까지 정적분(넓이)
            if(e > s){
                double val = sumWide[e] - sumWide[s];
                String str = String.format("%.1f", val);
                answer[i] = (Double.parseDouble(str));
            }else if(s > e){
                answer[i] = -1.0;
            }else{
                answer[i] = 0.0;
            }
        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private int findK(int k) {
        int count = 1;
        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
                count++;
            } else {
                k = 3 * k + 1;
                count++;
            }
        }
        return count;
    }

    private int[] makeYArr(int num, int k) {
        int[] yArr = new int[num];
        yArr[0] = k;
        yArr[num-1] = 1;
        for (int i = 1; i < yArr.length-1; i++) {
            if (k % 2 == 0) {
                k /= 2;
                yArr[i] = k;
            } else {
                k = 3 * k + 1;
                yArr[i] = k;
            }
        }
        return yArr;

    }
}
