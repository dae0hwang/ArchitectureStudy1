package programmers.lever2.day8.큰수만들기;

public class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int v = number.length()-k;//v개의 조합을 만들 수 있다. 0고려할 필요? 없다 그냥 숫자로 만들면 그만이다.
        char[] chars = number.toCharArray();
        char[] result = new char[v];
        return answer;
    }
    
    //public void comb(int depth, int v, int k, char[] chars, char[] result) {
      //  if (depth==v) {
        //
          //  return;
        //}
        //for (int i = k; i < chars.length; i++) {
         //   result[depth] =chars[i];
           // comb(d);
        //}
    //}

    public static void main(String[] args) {
        String a = "111";
        System.out.println(a.length());
    }
}
