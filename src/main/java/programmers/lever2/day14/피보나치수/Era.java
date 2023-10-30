package programmers.lever2.day14.피보나치수;

import java.util.Arrays;

public class Era {

    public static void main(String[] args) {
        boolean prime[] = new boolean[121];
        int N = 120;
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) {
                for (int j = i + i; j <= N; j += i) {
                    prime[j] = true;
                }
            }
        }
        System.out.println("Arrays.toString(prime) = " + Arrays.toString(prime));
        // 소수 출력
        for(int i=1; i<=N;i++){
            if(!prime[i]) System.out.print(i+" ");
        }
    }

}
