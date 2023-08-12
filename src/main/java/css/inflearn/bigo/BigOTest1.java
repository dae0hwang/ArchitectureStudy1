package css.inflearn.bigo;

import java.util.Scanner;

public class BigOTest1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                cnt++;
                a += i + j;
            }
        }
        System.out.println("a = " + a);
        System.out.println("cnt = " + cnt);
    }
}
