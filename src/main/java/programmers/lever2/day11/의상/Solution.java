package programmers.lever2.day11.의상;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    static int answer= 0;

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        Collection<Integer> values = map.values();
        int[] mapInts = values.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(mapInts));
        //1개부터 length까지 1개 경우 ,2개 경우, [1, 2, 3] 배열 만들어서 조합만들기
        for (int i = 1; i <= mapInts.length; i++) {
            //1  2  3   [0,1,,2]위치지
            int[] arr = new int[i];
            dfs(0, i, 0, arr, mapInts);
        }
        return answer;
    }

    public void dfs(int depth, int v, int k, int[] arr, int[] mapInts) {
        if (depth == v) {
            int x =1;
            System.out.println(Arrays.toString(arr));
            for (int i : arr) {
                x *=i;
            }
            answer+=x;
            return;
        }
        for (int i = k; i < mapInts.length; i++) {
            arr[depth] = mapInts[i];
            dfs(depth + 1, v, i + 1, arr, mapInts);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"}});

    }
}
