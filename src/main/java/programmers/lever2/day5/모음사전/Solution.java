package programmers.lever2.day5.모음사전;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static String[] arr = new String[]{"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();

    public int solution(String word) {
        DFS("", 0);
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
            }
        }
        return answer;

    }

    public void DFS(String str, int depth) {
        list.add(str);
        if (depth == 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            DFS(str + arr[i], depth + 1);
        }
    }
}
