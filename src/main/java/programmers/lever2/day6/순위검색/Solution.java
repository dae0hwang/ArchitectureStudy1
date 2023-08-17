package programmers.lever2.day6.순위검색;

public class Solution {

    static class Data {

        String language, type, career, food;
        int number;

        public Data(String language, String type, String career, String food, int number) {
            this.language = language;
            this.type = type;
            this.career = career;
            this.food = food;
            this.number = number;
        }
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Data[] dataInfo = new Data[info.length];
        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");
            dataInfo[i] = new Data(split[0], split[1], split[2], split[3],
                Integer.parseInt(split[4]));
        }


        for (int i = 0; i < query.length; i++) { //1000000개 info 50000개
            String nowQuery = query[i];
            String[] split = nowQuery.split(" ");
            int count = 0;
            Data queryData = new Data(split[0], split[2], split[4], split[6],
                Integer.parseInt(split[7]));
            for (Data data : dataInfo) {
                if ((queryData.language.equals("-") || queryData.language.equals(data.language)) &&
                    (queryData.type.equals("-") || queryData.type.equals(data.type)) &&
                    (queryData.career.equals("-") || queryData.career.equals(data.career)) &&
                    (queryData.food.equals("-") || queryData.food.equals(data.food)) &&
                    queryData.number <= data.number) {
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
    //cpp0 and1 -2 and3 senior4 and5 pizza6 2507
}
