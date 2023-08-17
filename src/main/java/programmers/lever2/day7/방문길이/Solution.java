package programmers.lever2.day7.방문길이;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static class Data {

        int x, y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class CheckData {
        int a,b,c, d;

        public CheckData(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CheckData checkData = (CheckData) o;
            return a == checkData.a && b == checkData.b && c == checkData.c && d == checkData.d;
        }
    }


    public int solution(String dirs) {
        char[] directions = dirs.toCharArray();
        //[0,0,0,1] [0,1,0,0] 한번에 이 두가지를 넣어버리는 것이지.
        List<CheckData> checkList = new ArrayList<>();


        Data now = new Data(0, 0);
        int answer = 0;
        for (char direction : directions) {
            if (direction == 'U') {
                Data to = new Data(now.x, now.y + 1);
                if (to.x <= 5 && to.x >= -5 && to.y <= 5 && to.y >= -5) {
                    if (checkList.contains(new CheckData(now.x, now.y, to.x, to.y))) {
                        now = new Data(to.x, to.y);
                    } else {
                        answer++;
                        checkList.add(new CheckData(now.x, now.y, to.x, to.y));
                        checkList.add(new CheckData(to.x, to.y, now.x, now.y));
                        now = new Data(to.x, to.y);
                    }
                }
            } else if (direction == 'D') {
                Data to = new Data(now.x, now.y - 1);
                if (to.x <= 5 && to.x >= -5 && to.y <= 5 && to.y >= -5) {
                    if (checkList.contains(new CheckData(now.x, now.y, to.x, to.y))) {
                        now = new Data(to.x, to.y);
                    } else {
                        answer++;
                        checkList.add(new CheckData(now.x, now.y, to.x, to.y));
                        checkList.add(new CheckData(to.x, to.y, now.x, now.y));
                        now = new Data(to.x, to.y);
                    }
                }
            } else if (direction == 'R') {
                Data to = new Data(now.x + 1, now.y);
                if (to.x <= 5 && to.x >= -5 && to.y <= 5 && to.y >= -5) {
                    if (checkList.contains(new CheckData(now.x, now.y, to.x, to.y))) {
                        now = new Data(to.x, to.y);
                    } else {
                        answer++;
                        checkList.add(new CheckData(now.x, now.y, to.x, to.y));
                        checkList.add(new CheckData(to.x, to.y, now.x, now.y));
                        now = new Data(to.x, to.y);
                    }
                }
            } else {
                Data to = new Data(now.x - 1, now.y);
                if (to.x <= 5 && to.x >= -5 && to.y <= 5 && to.y >= -5) {
                    if (checkList.contains(new CheckData(now.x, now.y, to.x, to.y))) {
                        now = new Data(to.x, to.y);
                    } else {
                        answer++;
                        checkList.add(new CheckData(now.x, now.y, to.x, to.y));
                        checkList.add(new CheckData(to.x, to.y, now.x, now.y));
                        now = new Data(to.x, to.y);
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.solution("ULURRDLLU");
//        List<Integer[]> list = new ArrayList<>();
//        list.add(new Integer[]{1, 1, 1, 1});
//        if (!list.contains(new Integer[]{1, 1, 1, 1})) {
//            System.out.println("false");
//        }
//        Set<Integer[]> set = new HashSet<>();
//        set.add(new Integer[]{1, 1, 1, 1});
//        System.out.println(set.contains(new Integer[]{1, 1, 1, 1}));
        List<CheckData> list = new ArrayList<>();
        Data data = new Data(2, 2);
        list.add(new CheckData(1, 1, 1, 1));
        System.out.println(list.contains(new CheckData(1, 1, 1, 1)));
    }
}
