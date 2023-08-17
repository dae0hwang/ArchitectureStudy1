package programmers.lever2.day7.멀쩡한사각형;

public class Solution {
    public long solution(int w, int h) {
        //총 개수에서
        long sum = (long)w*h;
        //x1부터 시작하여 starty endy가 포함하는 모든 start y는 내림 차순 end y는 내림차순에 해당하는 count
        long count = 0;
        double startY = 0;
        for (int i = 1; i <= w; i++) {
            double endY = (double) h*i/w;
            //end는 올림차순 - start내림차순
            long num = (long) Math.ceil(endY) - (long) Math.floor(startY);
            count+=num;
            startY = endY;
        }
        return sum-count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(8,12);
    }
}
