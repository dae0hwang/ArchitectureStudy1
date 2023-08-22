package programmers.lever2.day11.전화번호목록;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        System.out.println(Arrays.toString(phone_book));
        //작은 것부터 들어와 있음
        for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];
            for (int j = i+1; j < phone_book.length; j++) {
                if (phone_book[j].indexOf(s)==0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "12345";
        System.out.println(a.indexOf("23"));
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"119", "97674223", "1195524421"}));
    }
}
