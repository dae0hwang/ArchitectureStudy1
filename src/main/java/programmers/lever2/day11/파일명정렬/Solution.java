package programmers.lever2.day11.파일명정렬;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    static class Data {

        String upperString;
        Integer num;

        public Data(String upperString, Integer num, String original) {
            this.upperString = upperString;
            this.num = num;
            this.original = original;
        }

        String original;

        @Override
        public String toString() {
            return "Data{" +
                "upperString='" + upperString + '\'' +
                ", num=" + num +
                ", original='" + original + '\'' +
                '}';
        }
    }

    public String[] solution(String[] files) {
        Data[] dataArr = new Data[files.length];
        for (int i = 0; i < files.length; i++) {
            String original = files[i];
            dataArr[i] = findHeadString(original);

        }
        System.out.println(Arrays.toString(dataArr));
        Arrays.sort(dataArr, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.upperString.compareTo(o2.upperString)==0) {
                    return o1.num-o2.num;
                }
                return o1.upperString.compareTo(o2.upperString);
            }
        });
        System.out.println(Arrays.toString(dataArr));
        String[] answer = new String[dataArr.length];
        for (int i = 0; i < dataArr.length; i++) {
            answer[i] = dataArr[i].original;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new String[]{"f-05aa", "F-5 Freedom Fighter", "f-05bb", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
    }

    public Data findHeadString(String original) {
        char[] chars = original.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int digitIdx = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (Character.isDigit(aChar)) {
                digitIdx = i;
                break;
            }
            sb1.append(aChar);
        }
        for (int i = digitIdx; i < chars.length; i++) {
            char aChar = chars[i];
            if (!Character.isDigit(aChar)) {
                break;
            }
            sb2.append(aChar);
        }

        return new Data(sb1.toString().toUpperCase(), Integer.parseInt(sb2.toString()), original);
    }
}
