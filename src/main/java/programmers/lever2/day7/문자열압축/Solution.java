//package programmers.lever2.day7.문자열압축;
//
//public class Solution {
//    public int solution(String s) {
////        int max = Integer.MIN_VALUE;
////        int length = s.length();
////        for (int i = 1; i <= length / 2; i++) {
////            String checkStr = s.substring(0, i);
////            int end = i;
////            int checkLength = checkStr.length();
////            int num = length / checkLength;
////            int count = 0;
////            for (int j = 1; j <= num; j++) {
////                String next = s.substring(i * j, 2 * i * j);
////                if (checkStr.equals(next)) {
////                    count++;
////                }
////            }
////        }
////
////        int answer = 0;
//        int min = Integer.MAX_VALUE;
//        int length = s.length();
//        //1개로 압축하는경우 -> 최대 절반 개수로 압축하는 경우
//        // i는 압축하려는 글자 개수이다.
//        for (int i = 1; i <= length / 2; i++) {
//            String result = "";
//            //해당 영역에서 구한 압축 문자열 길이 구해서 min 찾기
//            String previous = s.substring(0, i); //a
//            int count = 0; //previous가 몇번 반복되었는지
//            // 몇번 비교해야 하는지 그리고 마지막 요소 처리하는 거랑 나머지들 추가하는 것까지
//            for (int j = 1; j < length / i; j++) {
//                String next = s.substring(i * j, 2 * i * j);
//                if (previous.equals(next)) {
//                    count++;
//                } else {
//                    result += (count + previous);
//                    previous = next;
//                }
//            }
//        }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        String a = "aaa";
//        System.out.println(a.substring(0, 1));
//    }
//}
