package programmers.lever2.day7.삼각달팽이;

public class Solution {
    public int[] solution(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        int[] answer = new int[sum];
        int[][] matrix = new int[n][n];
        int x = -1;
        int y = 0;
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                matrix[x][y] = num++;
            }
        }
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    break;
                }
                answer[index++] = matrix[i][j];
            }
        }


        return answer;
    }
}
