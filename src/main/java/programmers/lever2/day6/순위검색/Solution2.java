package programmers.lever2.day6.순위검색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution2 {

    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        for (int i = 0; i < info.length; i++) {
            DFS(info[i].split(" "), "", 0);
        }
        // 코딩 테스트 점수를 기준으로 오름차순 정렬
        for (ArrayList<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int n = query.length;
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = binarySearch(query[i]);
        }
        return result;
    }

    public int binarySearch(String query) {
        String[] arr = query.split(" and ");
        int score = Integer.parseInt(arr[3].split(" ")[1]);
        query = arr[0] + arr[1] + arr[2] + arr[3].split(" ")[0];
        if(!map.containsKey(query))
            return 0;
        //리스트는 미리 정렬되어 있었다.
        ArrayList<Integer> list = map.get(query);
        int start = 0;
        int end = list.size();
        while (start < end) {
            int mid = (start + end) / 2;
            //처음으로 이상인 값 찾기
            if (list.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return list.size() - start;
    }

    public void DFS(String[] info, String str, int depth) {
        if (depth == 4) {
            int score = Integer.parseInt(info[depth]);
            if (map.containsKey(str)) {
                map.get(str).add(score);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(score);
                map.put(str, list);
            }
            return;
        }
        DFS(info, str + "-", depth + 1);
        DFS(info, str + info[depth], depth + 1);

    }


}
