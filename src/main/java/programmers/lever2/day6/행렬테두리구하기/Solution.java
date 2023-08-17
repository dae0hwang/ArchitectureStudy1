package programmers.lever2.day6.행렬테두리구하기;

public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows + 1][columns + 1];
        for (int i = 1; i < rows+1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                map[i][j] = columns*(i - 1) + j;
            }
        }
//        System.out.println(Arrays.deepToString(map));
//        for (int[] ints : map) {
//            System.out.println(Arrays.toString(ints));
//        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            rotate(map, query, i, answer);
        }
        return answer;
    }


    public int[][] rotate(int[][] map, int[] queries, int index, int[] answer) {
        int x1 = queries[0];
        int y1 = queries[1];
        int x2 = queries[2];
        int y2 = queries[3];
        int[][] newMap = deepCopy(map);
        //위에 가로
        int min = Integer.MAX_VALUE;
        //위에 가로
        for (int i = y1; i <= y2; i++) {
            min = Math.min(min, newMap[x1][i]);
            if (i != y2) {
                map[x1][i + 1] = newMap[x1][i];
            } else {
                map[x1 + 1][i] = newMap[x1][i];
            }
        }

        //오른쪽 세로
        for (int i = x1; i <= x2; i++) {
            min = Math.min(min, newMap[i][y2]);
            if (i != x2) {
                map[i + 1][y2] = newMap[i][y2];
            } else {
                map[i][y2 - 1] = newMap[i][y2];
            }
        }

        //아래 가로
        for (int i = y2; i >= y1; i--) {
            min = Math.min(min, newMap[x2][i]);
            if (i != y1) {
                map[x2][i - 1] = newMap[x2][i];
            } else {
                map[x2-1][i] = newMap[x2][i];
            }
        }

        //왼쪽 세로
        for (int i = x2; i >= x1; i--) {
            min = Math.min(min, newMap[i][y1]);
            if (i != x1) {
                map[i - 1][y1] = newMap[i][y1];
            } else {
                map[i][y1 + 1] = newMap[i][y1];
            }
        }
        answer[index] = min;
        return map;
    }

    private static int[][] deepCopy(int[][] original2) {
        if(original2 == null) return null;
        int[][] result = new int[original2.length][original2[0].length];

        for(int i=0; i<original2.length; i++){
            System.arraycopy(original2[i], 0, result[i], 0, original2[0].length);
        }

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(3, 3, new int[][]{{1, 1, 2, 2}});
    }

}
