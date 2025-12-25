class Solution {
    public String solution(int[] food) {
        String left = "";

        // 왼쪽 선수 음식 배치
        for (int i = 1; i < food.length; i++) {
            int cnt = food[i] / 2;
            for (int j = 0; j < cnt; j++) {
                left += i;
            }
        }

        String answer = left + "0";

        // 오른쪽 선수 음식 배치
        for (int i = left.length() - 1; i >= 0; i--) {
            answer += left.charAt(i);
        }

        return answer;
    }
}
