import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    // 일직선상 일차원 배열
    // N개의 샘터가 있다. K채의 집을 지을거다.
    // 오아시스 기준으로 집을 지어야한다... -> 오아시스를 중심으로.. 집을 지을 수 있는 방법이...?
    // 오아시스 좌표를 큐에 넣어서 그 주변으로 하나씩 지어 나가는거임!!!

    private static int N, K;
    private static int[] oasisLocations;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        oasisLocations = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            oasisLocations[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        findMinimumCase();
    }

    private static void findMinimumCase() {
        final Deque<Home> queue = new ArrayDeque<>();
        final boolean[] isVisited = new boolean[200_200_001];
        final int[] dx = {-1, 1};

        for (final int oasis : oasisLocations) {
            queue.add(new Home(0, oasis));

            if (oasis >= 0) {
                isVisited[oasis] = true;
            } else {
                isVisited[(isVisited.length / 2) + Math.abs(oasis)] = true;
            }
        }

        int houseCount = 0;
        long result = 0;

        while (!queue.isEmpty()) {
            final Home now = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nextLocation = now.location + dx[i];
                int nextDistance = now.distance + 1;

                if (nextLocation >= 0 && isVisited[nextLocation]) {
                    continue;
                }

                if (nextLocation < 0 && isVisited[(isVisited.length / 2) + Math.abs(nextLocation)]) {
                    continue;
                }

                if (houseCount == K) {
                    break;
                }

                houseCount++;
                result += nextDistance;

                if (nextLocation >= 0) {
                    isVisited[nextLocation] = true;
                } else {
                    isVisited[(isVisited.length / 2) + Math.abs(nextLocation)] = true;
                }

                queue.offer(new Home(nextDistance, nextLocation));
            }
        }


        System.out.println(result);
    }

    static class Home {
        private int distance;
        private int location;

        public Home(final int distance, final int location) {
            this.distance = distance;
            this.location = location;
        }
    }
}
