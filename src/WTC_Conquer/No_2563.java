package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_2563 {
    public static final int TOTAL_SQUARE_SIDE_LENGTH = 100;
    public static final int BLACK_SQUARE_SIDE_LENGTH = 10;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int confettiCount = Integer.parseInt(bufferedReader.readLine());

        final List<Integer> positionX = new ArrayList<>();
        final List<Integer> positionY = new ArrayList<>();

        for (int i = 0; i < confettiCount; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            positionX.add(Integer.parseInt(stringTokenizer.nextToken()));
            positionY.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int result = solve(positionX, positionY);
        System.out.println(result);
    }

    private static int solve(final List<Integer> positionX, final List<Integer> positionY) {
        boolean[][] paper = new boolean[TOTAL_SQUARE_SIDE_LENGTH][TOTAL_SQUARE_SIDE_LENGTH];
        int area = 0;
        for (int i = 0; i < positionX.size(); i++) {
            final Position position = new Position(positionX.get(i), positionY.get(i));
            final int endPointX = position.startPointX + BLACK_SQUARE_SIDE_LENGTH;
            final int endPointY = position.startPointY + BLACK_SQUARE_SIDE_LENGTH;
            for (int j = position.startPointX; j < endPointX; j++) {
                for (int k = position.startPointY; k < endPointY; k++) {
                    if (paper[j][k]) {
                        continue;
                    }
                    paper[j][k] = true;
                    area++;
                }
            }
        }
        return area;
    }

    private static class Position {
        private final int startPointX;
        private final int startPointY;

        private Position(final int startPointX, final int startPointY) {
            this.startPointX = startPointX;
            this.startPointY = startPointY;
        }
    }
}
