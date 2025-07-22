import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Line implements Comparable<Line> {
        int start, end;
        Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(this.start, o.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines.add(new Line(a, b));
        }

        Collections.sort(lines); // 시작점 기준 정렬

        int total = 0;
        int currentStart = lines.get(0).start;
        int currentEnd = lines.get(0).end;

        for (int i = 1; i < n; i++) {
            Line line = lines.get(i);
            if (line.start <= currentEnd) {
                // 겹침 → 병합
                currentEnd = Math.max(currentEnd, line.end);
            } else {
                // 겹치지 않음 → 이전 선분 더함
                total += currentEnd - currentStart;
                currentStart = line.start;
                currentEnd = line.end;
            }
        }

        // 마지막 구간 더하기
        total += currentEnd - currentStart;

        System.out.println(total);
    }
}
