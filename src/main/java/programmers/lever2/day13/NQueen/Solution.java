//package programmers.lever2.day13.NQueen;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Solution {
//    public int solution(int n) {
//        int answer = 0;
//        List<Integer[]> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                list.add(new Integer[]{i,j});
//            }
//        }
//        System.out.println("list = " + list);
//        for (Integer[] integers : list) {
//            System.out.println(Arrays.toString(integers));
//        }
//        //해당 리스트 중에서 n개를 뽑아서 -겹치지 않는 조합으로 가야겠네
//        comb(0, n, 0, list, new int[n]);
//        return answer;
//    }
//
//
//    public void comb(int depth, int v, int k, List<Integer[]> list, int[] comb) {
//        if (depth == v) {
//            System.out.println(Arrays.toString(comb));
//            return;
//        }
//        for (int i = k; i < list.size(); i++) {
//            comb[depth] = i;
//            comb(depth + 1, v, i + 1, list, comb);
//        }
//    }
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.solution(3);
//    }
//
//    public int[][] makeMap(int[] comb, List<Integer[]> list) {
//        for (int i : comb) {
//            Integer[] integers = list.get(i);
//
//        }
//    }
//}
