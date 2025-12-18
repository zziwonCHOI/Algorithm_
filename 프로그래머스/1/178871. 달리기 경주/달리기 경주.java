import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String name : callings) {
            int idx = map.get(name);

            // 바로 앞 선수와 교환
            int prevIdx = idx - 1;
            String front = players[prevIdx];

            // players 배열 교환
            players[prevIdx] = name;
            players[idx] = front;

            // map 업데이트
            map.put(name, prevIdx);
            map.put(front, idx);
        }

        return players;
    }
}
