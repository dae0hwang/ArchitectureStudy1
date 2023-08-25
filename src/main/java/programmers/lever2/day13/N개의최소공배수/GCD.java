package programmers.lever2.day13.N개의최소공배수;

public class GCD {

    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.gcd(4, 10));
    }

    public int gcd(int a, int b) {
        if (a > b) {
            return (a % b == 0) ? b : gcd(b, a % b);
        } else {
            return (b % a == 0) ? a : gcd(a, b % a);
        }
    }
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i : arr) {
            int gcd = gcd(i, answer);
            answer= i*answer/gcd;
        }
        return answer;
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
