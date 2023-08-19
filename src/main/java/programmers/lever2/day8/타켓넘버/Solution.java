package programmers.lever2.day8.타켓넘버;

import java.util.Arrays;

public class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        int n = numbers.length;
        boolean[] check = new boolean[n];
        dfs(0,n,check,target,numbers);
        return answer;
    }

    public void dfs(int depth, int n, boolean[] check, int target, int[] numbers) {
        if (depth == n) {
            //이안에서 조합이나오기 때문에
            int sum = 0;
            for (int i = 0; i < check.length; i++) {
                if (check[i]) {
                    sum += numbers[i];
                } else {
                    sum -= numbers[i];
                }
            }
            if (sum==target) {
                answer++;
            }
            return;
        }
        check[depth] =true;
        dfs(depth + 1, n, check, target, numbers);
        check[depth] = false;
        dfs(depth + 1, n, check, target, numbers);
    }

    public static void main(String[] args) {
        dfs(0,5,new boolean[5]);
    }
    public static void dfs(int depth, int n, boolean[] check) {
        if (depth==n) {
            System.out.println(Arrays.toString(check));
            return;
        }
        check[depth] =true;
        dfs(depth+1, n, check);
        check[depth] =false;
        dfs(depth+1, n, check);
    }
}
