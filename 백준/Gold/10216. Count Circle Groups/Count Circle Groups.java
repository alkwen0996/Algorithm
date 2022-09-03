import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final String NEW_LINE = "\n";
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOfTestCase = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numberOfTestCase; i++) {
            final int numberOfEnemy = Integer.parseInt(bufferedReader.readLine());

            final List<Enemy> enemies = new ArrayList<>();
            parents = new int[numberOfEnemy + 1];

            for (int j = 0; j < numberOfEnemy; j++) {
                final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                enemies.add(new Enemy(new Point(
                        Integer.parseInt(stringTokenizer.nextToken()),
                        Integer.parseInt(stringTokenizer.nextToken())),
                        Integer.parseInt(stringTokenizer.nextToken())
                ));

                parents[j] = j;
            }

            stringBuilder.append(countEnemyGroup(enemies)).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int countEnemyGroup(final List<Enemy> enemies) {
        int numberOfGroup = enemies.size();

        for (int i = 0; i < enemies.size(); i++) {
            for (int j = i + 1; j < enemies.size(); j++) {
                final Enemy enemy1 = enemies.get(i);
                final Enemy enemy2 = enemies.get(j);

                final int xDistance = enemy1.point.x - enemy2.point.x;
                final int yDistance = enemy1.point.y - enemy2.point.y;
                final int range = enemy1.range + enemy2.range;

                if (xDistance * xDistance + yDistance * yDistance <= range * range) {
                    if (unionSet(i, j)) {
                        numberOfGroup--;
                    }
                }
            }
        }

        return numberOfGroup;
    }

    private static boolean unionSet(final int i, final int j) {
        final int x = findSet(i);
        final int y = findSet(j);

        if (x == y) {
            return false;
        }

        if (x < y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }

        return true;
    }

    private static int findSet(final int i) {
        if (parents[i] == i) {
            return i;
        }

        return parents[i] = findSet(parents[i]);
    }

    static class Enemy {
        private final Point point;
        private final int range;

        public Enemy(final Point point, final int range) {
            this.point = point;
            this.range = range;
        }

        @Override
        public String toString() {
            return "Enemy{" +
                    "point=" + point +
                    ", range=" + range +
                    '}';
        }
    }

}
