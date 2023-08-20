//package programmers.lever2.day9.소수찾기;
//
//import java.util.Arrays;
//
//public class Solution {
//    public int solution(String numbers) {
//        int answer = 0;
//
//        return answer;
//    }
//
//
//    public void dfs(int depth, int v, char[] result, char[] chars, boolean[] visited) {
//        if (depth ==v) {
//            System.out.println(Arrays.toString(result));
//            return;
//        }
//        for (int i = 0; i < chars.length; i++) {
//            if (!visited[i]) {
//                //방문하지 않았을 경우
//                visited[i] =true;
//                result[depth] = chars[i];
//                dfs(depth+1, v, result, chars, visited);
//
//                visited[i] =false;
//
//            }
//        }
//    }
//
//
//
//
//
//
//    public boolean inPrime(int num) {
//        if (num==1) {
//            return false;
//        }
//        if (num==2) {
//            return true;
//        }
//        for (int i = 2; i < Math.sqrt(num); i++) {
//            if ((num&i)==0) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
