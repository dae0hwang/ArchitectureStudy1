package programmers.lever2.day9.소수찾기;

import java.util.ArrayList;

public class Solution2 {
    static ArrayList<Integer> list= new ArrayList<>();
    static boolean[] check = new boolean[7];

    public int solution(String numbers) {
        int answer = 0;
        for(int i=0; i<numbers.length(); i++){
            dfs(numbers,"",i+1);
        }

        for(int i=0; i<list.size(); i++){
            if((prime(list.get(i)))) answer++;
        }

        return answer;
    }

    static void dfs(String str, String temp, int m) {
        if (temp.length() == m) {
            int num = Integer.parseInt(temp);
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                temp += str.charAt(i);
                dfs(str, temp, m);
                check[i] = false;
                temp = temp.substring(0, temp.length() - 1);
            }
        }
    }
    public boolean isPrime(int num) {
        if (num==1) {
            return false;
        }
        if (num==2) {
            return true;
        }
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num%i==0) {
                return false;
            }
        }
        return true;
    }

    //소수 판단
    static boolean prime(int n) {
        if(n<2) return false;

        for(int i=2; i*i<=n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(prime(2));
        System.out.println(2%2);
        System.out.println(new Solution2().isPrime(10));
    }
}
