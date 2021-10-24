package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_11651 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        final List<Position> pointsSort = new ArrayList<>();

        while (N-- > 0) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            pointsSort.add(new Position(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }

        pointsSort.sort((position1, position2) -> {
            if (position1.y > position2.y) {
                return 1;
            } else if (position1.y < position2.y) {
                return -1;
            } else {
                return Integer.compare(position1.x, position2.x);
            }
        });

        final StringBuilder stringBuilder = new StringBuilder();
        for (Position position : pointsSort) {
            stringBuilder.append(position.x).append(" ").append(position.y).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static class Position {
        int x;
        int y;

        public Position(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
