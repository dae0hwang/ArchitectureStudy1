package programmers.lever2.day12.뉴스클러스터링;

import java.util.*;

public class Solution2 {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        String[] first = str1.split("");
        String[] second = str2.split("");

        ArrayList<String> set1 = new ArrayList<>();
        ArrayList<String> set2 = new ArrayList<>();
        for(int i=0; i<first.length-1; i++) {
            String s = first[i] + first[i+1];
            if (!s.matches("[a-z]*")) {
                continue;
            }
            set1.add(s);
        }
        for(int i=0; i<second.length-1; i++) {
            String s = second[i] + second[i+1];
            if (!s.matches("[a-z]*")) {
                continue;
            }
            set2.add(s);
        }
        System.out.println("set1 = " + set1);
        System.out.println("set2 = " + set2);

        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();

        // 교집합
        for(String s : set2) {
            if(set1.contains(s)) {
                set1.remove(s);
                intersection.add(s);
            }
            union.add(s);
        }

        // 합집합
        for(String s : set1) {
            union.add(s);
        }
        System.out.println("union: " + union + " " + union.size());
        System.out.println("intersectoin: " + intersection + " " + intersection.size());
        double unionSize = union.size();
        double interSize = intersection.size();
        answer = union.isEmpty() ? 65536 : (int) (interSize / unionSize * 65536.0);

        return answer;
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int aaaa12 = s.solution("handshake", "shake hands");
    }
}