import java.util.*;

class Solution {
    static Map<String, String> inInfo;
    static Map<String, Integer> totalTime;
    static int defaultMin, defaultFee, addMin, addFee;

    public int[] solution(int[] fees, String[] records) {
        defaultMin = fees[0];
        defaultFee = fees[1];
        addMin = fees[2];
        addFee = fees[3];

        inInfo = new HashMap<>();
        totalTime = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] s = records[i].split(" ");

            String time = s[0];
            String car = s[1];
            String type = s[2];

            if (type.equals("IN")) {
                inInfo.put(car, time);
            } else {
                int t = calTime(time) - calTime(inInfo.get(car));
                totalTime.put(car, totalTime.getOrDefault(car, 0) + t);
                inInfo.remove(car);
            }
        }

        // 출차 안된 차량
        for (String car : inInfo.keySet()) {
            int t = calTime("23:59") - calTime(inInfo.get(car));
            totalTime.put(car, totalTime.getOrDefault(car, 0) + t);
        }

        // 요금 계산
        int[] answer = new int[totalTime.size()];
        int i = 0;

        for (int time : totalTime.values()) {
            if (time <= defaultMin) {
                answer[i++] = defaultFee;
            } else {
                int extra = time - defaultMin;
                int add = (int) Math.ceil((double) extra / addMin);
                answer[i++] = defaultFee + add * addFee;
            }
        }

        return answer;
    }

    public static int calTime(String s) {
        String[] t = s.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        return h * 60 + m;
    }
}