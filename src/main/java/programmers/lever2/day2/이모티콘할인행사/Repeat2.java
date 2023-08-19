package programmers.lever2.day2.이모티콘할인행사;

public class Repeat2 {
    static int[] discount = {10,20,30,40};
    static int maxOfSubscribe;
    static int maxOfCost;

    public int[] solution(int[][] users, int[] emoticons) {
        findResult(0,emoticons.length, new int[emoticons.length],users,emoticons);
        return new int[]{maxOfSubscribe,maxOfCost};
    }

    public void findResult(int index, int emotionsLength, int[] discounts, int[][] users, int[] emoticons) {
        if (index==emotionsLength){
            //여기서 구해서 가장 큰 값인지 체크하면 된다.
            //해당 cost subscribe 해당 순열에서의 구독과 합이다.
            int cost = 0;
            int subscribe = 0;
            for (int[] user : users) {
                int sum = 0;
                int userDiscountRate = user[0];
                int userMaxCost = user[1];
                for (int i = 0; i < emoticons.length; i++) {
                    if (discounts[i]>=userDiscountRate){
                        sum += emoticons[i]/100*(100-discounts[i]);
                    }
                }
                if (sum>=userMaxCost) subscribe++;
                else cost+=sum;
            }
            //이것을 마지막에 max 것과 비교해서 처리한다 .
            if (subscribe>maxOfSubscribe){
                maxOfSubscribe = subscribe;
                maxOfCost = cost;
            }else if (subscribe == maxOfSubscribe){
                maxOfCost = Math.max(maxOfCost,cost);
            }
            return;
        }
        //여기도 은근 복잡하네 이 중복 순열 중에 가장 큰 값 고르면 된다는 거잖아
        for (int i = 0; i < 4; i++) {
            discounts[index] = discount[i];
            findResult(index+1, emotionsLength, discounts, users, emoticons);
        }
    }
}
