package programmers.lever2.day8.오픈채팅방;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import jdk.jshell.spi.ExecutionControl.StoppedException;

public class Solution {

    static class Data {
        String id, state;

        public Data(String id, String state) {
            this.id = id;
            this.state = state;
        }
    }

    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<Data> list = new ArrayList<>();
        for (String s : record) {
            String[] split = s.split(" ");
            String state = split[0];
            if (state.equals("Enter")) {
                //들어오면 두가지가 입력되지
                list.add(new Data(split[1], state));
                map.put(split[1], split[2]);
            } else if (state.equals("Leave")) {
                list.add(new Data(split[1], state));
            } else {
                map.put(split[1], split[2]);
            }
        }
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String state = list.get(i).state.equals("Enter")?"님이 들어왔습니다.":"님이 나갔습니다.";
            String str = map.get(list.get(i).id)+state;
            answer[i] =str;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }


}
