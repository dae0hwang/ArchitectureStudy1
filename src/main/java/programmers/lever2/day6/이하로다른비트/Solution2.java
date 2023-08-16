package programmers.lever2.day6.이하로다른비트;

public class Solution2 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            //가장 마지막에 있는 0을 찾는다.
            int zero = binary.lastIndexOf('0');
            if (zero != -1) {
                //제로가 있는데 완전 끝은 아니라면
                if (zero != binary.length() - 1) {
                    answer[i] = Long.parseLong(
                        binary.substring(0, zero) + "10" + binary.substring(zero + 2)
                        , 2);
                } else {
                    //끝쪽에 있는 0이 있는 수라면 마지막0을1로 바꾼다.
                    answer[i] = Long.parseLong(binary.substring(0, zero) + "1", 2);
                }

            } else {
                //안에 0이 없다면
                answer[i] = Long.parseLong("10"+binary.substring(1), 2);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String a = "1110110";
        System.out.println("a.lastIndexOf('0') = " + a.lastIndexOf('0'));
        int i = a.lastIndexOf('0');
        System.out.println(i == a.length() - 1);

        String cc = "abcd";
        System.out.println("cc.substring(0,2) = " + cc.substring(0, 2));



        System.out.println("a.substring(1,a.length()) = " + a.substring(1));
        String b = "110";
        System.out.println(Long.parseLong(b.substring(0,2)+"1", 2));
        System.out.println(b.substring(0,2)+"1");

    }
}
