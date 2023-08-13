package programmers.lever2.day3.점찍기;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(1, 5));
//        System.out.println(Math.sqrt(16));
    }

    public long solution(int k, int d) {

        long count = 0;
        for (int i = 0; i < 1000000; i++) {
            int num = i * k;
            if (num > d) {
                break;
            }
            //0부터 시작해서 y크기 구하면된다.
            //그런데 이 값중에서 k의 배수만 가능하다. 이 값 안에 포함된
            //k의 배수만 점에 추가된다.
            int maxY = findMaxY(num, d);
            for (int j = 0; j <= maxY; j++) {
                int findNum = j * k;
                if (findNum <= maxY) {
                    count++;
                } else {
                    break;
                }
            }
        }
        long answer = 0;
        return count;
    }

    private int findMaxY(int x, int r) {
        double y = Math.sqrt(r * r - x * x);
        int intY = (int) y;
        //0까지 포함해야해서 아니야 빼자 k의 배수인 값만 써야해서
        return intY ;
    }
}
