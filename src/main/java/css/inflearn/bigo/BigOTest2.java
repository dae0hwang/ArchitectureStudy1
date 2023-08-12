package css.inflearn.bigo;

public class BigOTest2 {

    static int cnt = 0;
    public static void main(String[] args) {
        BigOTest2.solve(10, 20);
        System.out.println("cnt = " + cnt);
    }

    public static void solve(int n, int m) {
        cnt++;
        int a = 1;
        for (int i = 0; i < n; i++) {
            a *= i;
        }
        for (int j = 0; j < m; j++) {
            a *= j;
        }
        System.out.println("a = " + a);
    }
}
