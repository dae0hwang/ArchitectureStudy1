package programmers.lever2.day8.구명보트;

import java.util.Arrays;

public class Solution2 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int index = 0;
        for (int i = people.length - 1; i >= index; i--) {
            int right = people[i];
            int left = people[index];
            int sum = right+left;
            if (limit>= sum){
                index++;
            }
            answer++;
        }
        return answer;
    }
}
