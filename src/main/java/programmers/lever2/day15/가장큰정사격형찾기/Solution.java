package programmers.lever2.day15.가장큰정사격형찾기;

public class Solution {
    public int solution(int [][]board) {
        int answer = 0;
        //for문으로 탐색하는 것 오케이
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    //여기서 탐색을 진행한다.
                    int findNum = find(board, i, j);
                    answer = Math.max(answer, findNum);
                }
            }
        }
        return answer*answer;
    }

    public int find(int[][] board, int x, int y) {
        int count = 1;
        while (true) {
            int tempX = x + count - 1;
            int tempY = y + count - 1;
            if (tempX < 0 || tempX >= board.length || tempY < 0 || tempY >= board[0].length) {
                break;
            }
            if (board[tempX][tempY] != 1) {
                break;
            }
            for (int i = 1; i < count; i++) {
                if (tempX - i < 0 || tempX - i >= board.length || tempY - i < 0 || tempY - i >= board[0].length) {
                    break;
                }
                if (board[tempX - i][tempY] != 1 || board[tempX][tempY - i] != 1) {
                    break;
                }
            }
            count++;
        }
        return count - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}});
    }

}
