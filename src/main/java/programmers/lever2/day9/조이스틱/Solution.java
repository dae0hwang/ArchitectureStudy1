package programmers.lever2.day9.조이스틱;

public class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] chars = name.toCharArray();
        int index;
        int length = name.length();
        int move = name.length() - 1;
        //마지막 n일 때도 생각을 해야지
        for (int i = 0; i < chars.length; i++) {
            //다음 넘어갈 값도 여기서 계산을 하는거야.
            //먼저 내 값을 구해
            answer += minimalUpDown(chars[i]);
            //
            index = i + 1;
            while (index < name.length() && name.charAt(index) == 'A') {
                index++;
            }
            //아항 아에 값을 구해버리는구나 아그치 둘중 하나방향으로 갈지만 정하는거지 막 변동하는것이아니다!!!
            //오른쪽으로 갈거명 오른쪽으로 가는거고 왼쪽으로 가면 왼쪽으로 차라리 가는 것이다.
            move = Math.min(move, i * 2 + length - index);
            // 2022년 이전 테스트 케이스만 확인하면 여기까지해도 정답처리가 되기 때문에, 이전 정답들에는 여기까지만 정리되어 있지만,
            // BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려하려면 아래의 코드가 필요합니다.
            move = Math.min(move, (length - index) * 2 + i);

        }

        return answer;
    }

    public int minimalUpDown(char c) {
        int straight = (int)c - 65;
        int reverse = 91 - (int)c;
        return Math.min(straight, reverse);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("BBBBAAAAAAAB");

    }


}
