import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int f = Integer.parseInt(stringTokenizer.nextToken()); // 총 F층
        int s = Integer.parseInt(stringTokenizer.nextToken()); // 강호 위치
        int g = Integer.parseInt(stringTokenizer.nextToken()); // 스타트링크 위치
        int u = Integer.parseInt(stringTokenizer.nextToken()); // 위로 u만큼 이동
        int d = Integer.parseInt(stringTokenizer.nextToken()); // 아래로 d 만큼 이동

        System.out.println(moveFloor(f, s, g, u, d));
    } // main

    private static String moveFloor(final int f, final int s, final int g, final int u, final int d) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[f + 1];
        queue.add(s);
        isVisited[s] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer current = queue.poll();

                if (current == g) {
                    return String.valueOf(count);
                }

                int nextUp = current + u;
                int nextDown = current - d;

                if (nextUp > f && nextDown < 1) {
                    continue;
                }

                if (nextUp >= 1 && nextUp <= f && !isVisited[nextUp]) {
                    queue.add(nextUp);
                    isVisited[nextUp] = true;
                }

                if (nextDown >= 1 && nextDown <= f && !isVisited[nextDown]) {
                    queue.add(nextDown);
                    isVisited[nextDown] = true;
                }
            }

            count++;
        }

        return "use the stairs";
    }
} // class
