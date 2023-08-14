package programmers.lever2.day4.주차요금계산;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static class Data {

        int carNum, time, price;

        public Data(int carNum, int time) {
            this.carNum = carNum;
            this.time = time;
            this.price = 0;
        }

        @Override
        public String toString() {
            return "Data{" +
                "carNum=" + carNum +
                ", time=" + time +
                ", price=" + price +
                '}';
        }
    }
    public int[] solution(int[] fees, String[] records) {
        //맵으로 담아두는 것도 나쁘지 않다. 그 정보를 //정렬도 쉽게할 수 있고 ㅇㅇ
        // 번호하고 시간을 구해야해 record 없는 애들은 23:59으로 설정하고
        //map -> 배열 -> map -> 정렬 -> 답
        Map<Integer, Integer> inCarMap = new HashMap<>();
        Map<Integer, Integer> timeCarMap = new HashMap<>();
//        List<Data> timeList = new ArrayList<>();
        for (String record : records) {
            String[] split = record.split(" ");
            int time = makeIntTime(split[0]);
            int carNum = Integer.parseInt(split[1]);
            String direction = split[2];
            if (direction.equals("IN")) {
                inCarMap.put(carNum, time);
            } else {
                //out이라면
                Integer startTime = inCarMap.get(carNum);
                inCarMap.remove(carNum);
                timeCarMap.put(carNum, timeCarMap.getOrDefault(carNum, 0) + time - startTime);
//                timeList.add(new Data(carNum, time - startTime));
            }
        }
        //마지막에 처리되지 못한 map에 남아있는 애들을
        int lastTime = 23 * 60 + 59;
        if (!inCarMap.isEmpty()) {
            for (Integer carNum : inCarMap.keySet()) {
                timeCarMap.put(carNum,
                    timeCarMap.getOrDefault(carNum, 0) + lastTime - inCarMap.get(carNum));
//                timeList.add(new Data(carNum, lastTime - inCarMap.get(carNum)));
            }
        }

        int defaultTime = fees[0];
        int defaultCost = fees[1];
        int countTime = fees[2];
        int countCost = fees[3];
        //정렬한번 해주고 출력한번 해보자
        List<Integer> keySet = new ArrayList<>(timeCarMap.keySet());
        Collections.sort(keySet);
        int[] result = new int[keySet.size()];
        for (int i = 0; i < keySet.size(); i++) {
            int savedTime = timeCarMap.get(keySet.get(i));
            if (savedTime <= defaultTime) {
                result[i] = defaultCost;
            } else {
                int plusTime = savedTime - defaultTime;
                int x = 0;
                if (plusTime % countTime == 0) {
                    x = plusTime / countTime;
                } else {
                    x = plusTime / countTime + 1;
                }
                result[i] = defaultCost + countCost * x;
            }
        }
        System.out.println(Arrays.toString(result));
//        //가격을 넣어주면 된다.
//        for (Data data : timeList) {
//            if (data.time <= defaultTime) {
//                data.price = defaultCost;
//            } else {
//                int plusTime = data.time - defaultTime;
//                int x = 0;
//                if (plusTime % countTime == 0) {
//                    x = plusTime / countTime;
//                } else {
//                    x = plusTime / countTime + 1;
//                }
//                data.price = defaultCost + countCost * x;
//            }
//        }
//        timeList.sort((o1, o2) -> o1.carNum-o2.carNum);
//        for (Data data : timeList) {
//            System.out.println(data);
//        }
//
//
//
//        int[] answer = {};
        return result;
    }

    public int makeIntTime(String strTime) {
        String[] split = strTime.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

}
