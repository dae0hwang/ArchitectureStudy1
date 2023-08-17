package programmers.lever2.day6.쿼드압축후개수세기;

public class Solution2 {
    static int[] answer;

    public boolean zip(int[][] arr, int x, int y, int size, int val) {
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y + size; j++) {
                //val는 arr[x][y] 의 값이다.
                if (arr[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }

    public void quad(int[][] arr, int x, int y, int size) {
        if (zip(arr, x, y, size, arr[x][y])) {
            if (arr[x][y] == 1) {
                answer[1]++;
            } else {
                answer[0]++;
            }
            //아에 나가버리는 구나 ㅇㅇ
            return;
        }
        //각 네칸으로 돌릴 수 있도록한다. 사이즈는 절반으로 한다음
        quad(arr, x, y, size / 2);
        quad(arr, x, y + size / 2, size / 2);
        quad(arr,x+size/2,y, size/2);
        quad(arr,x+size/2,y + size/2, size/2);
    }

    //전체를 주어서 먼저 재귀함수 돌리는 구나 굳
    public int[] solution(int[][] arr) {
        answer = new int[2];
        quad(arr,0,0,arr.length);
        return answer;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}});

    }
}