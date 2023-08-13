package programmers.lever2.day2.마법의엘리베이터;

public class Solution2 {
    int count = 0;
    public int solution(int storey) {
        int answer = 0;
        func(storey);
        answer = count;
        return answer;
    }

    public void func(int storey) {
        if (storey == 0) {
            return;
        }
        int last = storey % 10;
        int rest = storey / 10;
        if (last > 5) {
            count += (10 - last);
            rest += 1;
        } else if (last == 5) {
            if (5 < (rest % 10) + 1) {
                count += (10 - last);
                rest += 1;
            } else {
                count += last;
            }
        } else {
            count += last;
        }
        func(rest);
    }
}
