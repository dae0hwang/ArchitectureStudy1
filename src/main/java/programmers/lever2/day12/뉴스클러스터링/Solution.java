package programmers.lever2.day12.뉴스클러스터링;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> list1= new ArrayList<>();
        char[] chars1 = str1.toCharArray();
        List<String> list2= new ArrayList<>();
        char[] chars2 = str2.toCharArray();

        for (int i = 0; i < chars1.length - 1; i++) {
            char c1 = Character.toLowerCase(chars1[i]);
            char c2 = Character.toLowerCase(chars1[i+1]);
            if (c1 < 97 || c1 > 122 || c2 < 97 || c2 > 122) {
                continue;
            }
            String plus = String.valueOf(c1).toUpperCase()+ String.valueOf(c2).toUpperCase();
            list1.add(plus);
        }

        for (int i = 0; i < chars2.length - 1; i++) {
            char c1 = Character.toLowerCase(chars2[i]);
            char c2 = Character.toLowerCase(chars2[i+1]);
            if (c1 < 97 || c1 > 122 || c2 < 97 || c2 > 122) {
                continue;
            }
            String plus = String.valueOf(c1).toUpperCase()+ String.valueOf(c2).toUpperCase();
            list2.add(plus);
        }
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        //이중 for문 돌아서 교집합 구하기
        int sum = list1.size() + list2.size();
        int gyo = 0;
        for (String s : list1) {
            if (list2.contains(s)) {
                gyo++;
                list2.remove(s);
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    gyo++;
                    list1.remove(i);
                    list2.remove(j);
                }
            }
        }
        if (sum == 0) {
            return 65536;
        }
        double newSum = (double)(sum-gyo);
        double newGyo = (double) gyo;
        System.out.println("newSum = " + newSum);
        System.out.println("newGyo = " + newGyo);
        return (int)((newGyo/newSum)*65536);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int aaaa12 = s.solution("handshake", "shake hands");
        System.out.println(aaaa12);
//        System.out.println(0/2); 이건 0 값이 나온다.
//        System.out.println(1/0); 이건 에러
//        System.out.println((int)(((double)2/(double)3)*65536));
    }
}
