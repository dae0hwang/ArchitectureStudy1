package programmers.lever2.day2.시소짝궁2;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{-7, -4, -2, 0, 3, 7, 11, 15};
        int left = 0;
        int right = arr.length - 1;
        int mid = -1;
        int find = -4;
        while (left <= right) {
            mid = (right + left) / 2;
            if (arr[mid] == find) {
                System.out.println(mid);
                break;
            }
            if (find < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

}
