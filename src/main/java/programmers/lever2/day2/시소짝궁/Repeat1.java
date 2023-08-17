package programmers.lever2.day2.시소짝궁;

public class Repeat1 {
    static int[] arr= new int[2];
    static int answer = 0;
    public long solution(int[] weights) {
        return answer;
    }

    public static void main(String[] args) {
        Repeat1 r = new Repeat1();
        r.solution(new int[]{100, 180, 360, 100, 270});
    }

    public void dfs(int depth, int k, int[] weight){
        if (depth==2){
            if ( check(arr[0], arr[1])) {
                answer++;
            }
            return;
        }
        for (int i = k; i < weight.length; i++) {
            arr[depth] = weight[i];
            dfs(depth+1, i+1, weight);
        }
    }

    //해당 조합이 균현을 이루는 점이 있는 지 체크
    public boolean check(int a, int b){
        if (a == b || 2 * a == 3 * b || 2 * a == 4 * b || 3 * a == 2 * b || 3 * a == 4 * b
            || 4 * a == 2 * b || 4 * a == 3 * b) {
            return true;
        } else {
            return false;
        }
    }
}
