package programmers.lever2.day16.twoN;

public class Solution {

    static int[] arr = new int[100];
    public int solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < n; i++) {
            int num = arr[i - 1] + arr[i - 2];
            arr[i] = num % 1000000007;
        }

        return arr[n-1];
    }

    public static void main(String[] args) {
        arr[0] = 1;
        arr[1] = 2;
    }

}
