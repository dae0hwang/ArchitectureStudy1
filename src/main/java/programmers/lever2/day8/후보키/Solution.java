package programmers.lever2.day8.후보키;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    static int answer = 0;
    static ArrayList<String> list = new ArrayList<>();

    public int solution(String[][] relation) {
        int columnNum = relation[0].length;
        // 1개짜리 부터 최대 num개까지 종류를 구한다.
        int[] column = new int[columnNum];
        for (int i = 0; i < columnNum; i++) {
            column[i] = i;
        }
        //depth가 1개일 때부터 num개까지 depth가 0부터 시작해서
        // 1개일 때 조합 이런식으로
        //작은 숫자부터 하는게 이득인 점이 있다.
        for (int i = 1; i <= columnNum; i++) {
            System.out.println(" ");
            int[] combArr = new int[i];
            dfs(0, i, column, combArr, 0,relation);
            //일단 여기까지 원하는 대로 나옴

        }
        return answer;
    }

    public void dfs(int depth, int v, int[] column, int[] combArr, int k, String[][]relation) {
        if (depth == v) {
            System.out.println(Arrays.toString(combArr));
            //이제 해당 comb가 최소성인지 -> 유일성을 만족하는지 맞다면 answer++
            StringBuilder sb = new StringBuilder();
            for (int i : combArr) {
                sb.append(i);
            }
            String combStr = sb.toString();
            //최소성인지
            if (!isMinimal(combStr)) {
                return;
            }
            //최소성 통과
            if (!isUnique(relation, combArr)) {
                return;
            }
            answer++;
            list.add(combStr);
            return;
        }
        for (int i = k; i < column.length; i++) {
            combArr[depth] = column[i];
            dfs(depth + 1, v, column, combArr, i + 1, relation);
        }
    }

    //이제 해당 comb가 최소성인지 -> 유일성을 만족하는지 맞다면 answer++ 그리고 리스트에 넣어서 최소성 확인
    public boolean isMinimal(String combStr) {
        for (String s : list) {
            if (combStr.contains(s)) {
                return false;
            }
        }
        return true;
    }

    //이제 유일성을 만족하지는
    public boolean isUnique(String[][] relation, int[] combArr) {
        Set<String> set = new HashSet<>();
        for (String[] strings : relation) {
            StringBuilder sb = new StringBuilder();
            for (int i : combArr) {
                sb.append(strings[i]);
            }
            String rowStr = sb.toString();
            if (!set.add(rowStr)) {
                //set에 넣기 실패한 것이라면
                return false;
            }
        }
        //모든행이 해당 combArr해당하는 값이 중복없이 들어갔다면 true
        return true;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"},
            {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"},
            {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});




//        String a = "0123";
//        System.out.println(a.contains(new String("12")));
//        int[] b = new int[]{1, 2, 3, 4};
//        StringBuilder sb = new StringBuilder();
//        for (int i : b) {
//            sb.append(i);
//        }
//        System.out.println(sb);
    }
}
