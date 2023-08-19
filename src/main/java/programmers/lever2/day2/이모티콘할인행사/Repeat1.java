package programmers.lever2.day2.이모티콘할인행사;

public class Repeat1 {

    static int[] discountArr = new int[]{10, 20, 30, 40};
    static int manCount;
    static int priceSum;
    public int[] solution(int[][] users, int[] emoticons) {

        for (int i = 0; i < emoticons.length; i++) {
            //각각 이모틴콘을 사용하여 계산하기
            int nowEmoticonPrice= emoticons[i];
            find(users, nowEmoticonPrice);
        }
        int[] answer =  new int[]{manCount, priceSum};
        return answer;
    }


    public void find(int[][] users, int emoticonPrice) {
        int count =0;
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int tempCount = 0;
            int tempSum = 0;
            int discount =discountArr[i]; //현재 할인 비율이다.
            int discountPrice = emoticonPrice*(100-discount)/100;//할인가격이다.
            for (int[] user : users) {
                if (user[0]<=discount) {
                    //할인율 이상일 때,
                    if (user[1]<=discountPrice) {
                        tempCount++;
                    }else {
                        tempSum += discountPrice;
                    }
                }
            }
            if (count<tempCount) {
                count= tempCount;
                sum = tempSum;
            } else if (count ==tempCount && sum <tempSum) {
                count= tempCount;
                sum = tempSum;
            }
        }
        manCount+=count;
        priceSum+= sum;
    }
}
