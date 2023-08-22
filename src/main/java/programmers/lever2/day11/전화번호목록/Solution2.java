package programmers.lever2.day11.전화번호목록;

import java.util.HashSet;

public class Solution2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        for (String s : phone_book) {
            set.add(s);
        }
        for (int i = 0; i < phone_book.length; i++) {
            String phone = phone_book[i];
            for (int j = 0; j < phone.length(); j++) {
                //같은 것은 없다고 했으니 j가 포함되지 않을 경우까지 하는게 맞구나!!
                if (set.contains(phone.substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
