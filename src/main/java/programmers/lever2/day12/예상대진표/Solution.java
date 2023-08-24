package programmers.lever2.day12.예상대진표;

public class Solution {

    public int solution(int n, int a, int b) {
        int answer = 0;
        int small = Math.min(a, b);
        int big = Math.max(a, b);
        System.out.println("small = " + small);
        System.out.println("big = " + big);
        int count =1;
        while (true) {
            //if 내가 써놓은 식.
            if (small % 2 == 1 && small + 1 == big) {
                break;
            }
            small = small == 1 ? 1 : (int) Math.ceil((double) small/2);
            big = big == 1 ? 1 : (int) Math.ceil((double) big/2);
            System.out.println("small = " + small);
            System.out.println("big = " + big);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(8, 4, 7);
        int a = 3;
        a= a == 1 ? 1 : 2;
        System.out.println("a = " + a);
        int small = 3;
        small = (int) Math.floor((double) small/2);
        System.out.println("small = " + small);
    }
}
