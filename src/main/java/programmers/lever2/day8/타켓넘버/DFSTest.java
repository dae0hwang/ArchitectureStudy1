package programmers.lever2.day8.타켓넘버;

import java.util.Arrays;

public class DFSTest {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        boolean[] check = new boolean[arr.length];
        int[] result = new int[3];
//        DFS(0, arr, result);
//        DFS2(0, arr, result, check);
        comb(0, arr, result, 0);
    }

    public static void DFS(int depth, int[] arr , int[] result) {
        if (depth == 3) {
            System.out.println(Arrays.toString(result));

            return;
        }
        for (int i = 0; i < arr.length; i++) {
            result[depth] = arr[i];
            DFS(depth + 1, arr, result);
        }
    }

    public static void DFS2(int depth, int[] arr , int[] result, boolean[] check) {
        if (depth == 3) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!check[i]) {
                check[i] = true;
                result[depth] = arr[i];
                DFS2(depth + 1, arr, result, check);
                check[i] = false;
            }
        }

//        for (int i = 0; i < arr.length && !check[i]; i++) {
//            check[i] = true;
//            result[depth] = arr[i];
//            DFS2(depth + 1, arr, result, check);
//            check[i] = false;
//        }
    }

    public static void comb(int depth, int[] arr, int[] result, int k) {
        if (depth == 3) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = k; i < arr.length; i++) {
            result[depth] = arr[i];
            comb(depth + 1, arr, result, i + 1);
        }
    }

}
