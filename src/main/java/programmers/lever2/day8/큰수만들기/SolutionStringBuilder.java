package programmers.lever2.day8.큰수만들기;

public class SolutionStringBuilder {
    public String solution(String number, int k) {
        StringBuilder builder = new StringBuilder(number);
        int length = builder.length()-k;
        //builder를 각 값을 비교해서 수정해서 builder를 만드는 것이기 때문에
        //원하는 것의 길이 length와 길이가 같아지는 즉시 for문을 탈출하도록한다.
        for (int i = 1; i < builder.length() && builder.length()>length; i++) {
            if (builder.charAt(i)>builder.charAt(i-1)) {
                //뒤에 있는 것이 더 크다면
                builder.deleteCharAt(i-1);
                i = Math.max(0, i-2);
            }
        }
        return builder.substring(0, length);
    }

    public static void main(String[] args) {
        SolutionStringBuilder s = new SolutionStringBuilder();
        s.solution("1231234", 3);
    }

}
