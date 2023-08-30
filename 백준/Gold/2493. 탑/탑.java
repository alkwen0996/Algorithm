
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int towerCount = Integer.parseInt(bufferedReader.readLine());

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final Deque<Tower> towersHeight = new ArrayDeque<>();

        for (int i = 0; i < towerCount; i++) {
            towersHeight.push(new Tower(Integer.parseInt(stringTokenizer.nextToken()), i + 1));
        }

        System.out.println(confirmLaserReceiveTower(towersHeight));
    }

    private static StringBuilder confirmLaserReceiveTower(Deque<Tower> towersHeight) {
        final StringBuilder stringBuilder = new StringBuilder();
        final Deque<Tower> noFindReceiveTower = new ArrayDeque<>();

        final int[] result = new int[towersHeight.size() + 1];

        while (towersHeight.size() > 1) {
            noFindReceiveTower.push(towersHeight.pop());

            if (towersHeight.peek().height > noFindReceiveTower.peek().height) {
                Tower tower = noFindReceiveTower.pop();
                result[tower.order] = towersHeight.peek().order;

                while (!noFindReceiveTower.isEmpty()) {
                    if (towersHeight.peek().height < noFindReceiveTower.peek().height) {
                        break;
                    }

                    result[noFindReceiveTower.peek().order] = towersHeight.peek().order;
                    noFindReceiveTower.pop();
                }
            }
        }

        for (int i = 1; i < result.length; i++) {
            stringBuilder.append(result[i]).append(SPACE);
        }

        return stringBuilder;
    }

    static class Tower {
        private int height;
        private int order;

        public Tower(int height, int order) {
            super();
            this.height = height;
            this.order = order;
        }
    }

}