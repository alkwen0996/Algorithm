import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCase = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        int[][] chessBoard;
        int chessBoardLine;

        for (int i = 0; i < testCase; i++) {
            chessBoardLine = Integer.parseInt(bufferedReader.readLine());
            chessBoard = new int[chessBoardLine][chessBoardLine];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            Point startPoint = new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            Point destination = new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));

            if (startPoint.x == destination.x && startPoint.y == destination.y) {
                stringBuilder.append(0).append(NEW_LINE);
                continue;
            }

            stringBuilder.append(searchRoute(startPoint, destination, chessBoard)).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int searchRoute(final Point startPoint, final Point destination, final int[][] chessBoard) {
        final int[][] moveDirections = {{2, 1}, {1, 2}, {2, -1}, {1, -2}, {-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}};
        final boolean[][] isVisited = new boolean[chessBoard.length][chessBoard.length];
        final Deque<Point> queue = new ArrayDeque<>();
        queue.add(startPoint);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Point point;

            for (int i = 0; i < size; i++) {
                point = queue.poll();

                for (final int[] moveDirection : moveDirections) {
                    int nextX = point.x + moveDirection[0];
                    int nextY = point.y + moveDirection[1];

                    if (nextX < 0 || nextY >= chessBoard.length || nextX >= chessBoard.length || nextY < 0) {
                        continue;
                    }

                    if (isVisited[nextX][nextY]) {
                        continue;
                    }

                    if (chessBoard[nextX][nextY] > chessBoard[point.x][point.y]) {
                        continue;
                    }

                    queue.add(new Point(nextX, nextY));
                    isVisited[nextX][nextY] = true;
                    chessBoard[nextX][nextY] = chessBoard[point.x][point.y] + 1;
                }
            }
        }

        return chessBoard[destination.x][destination.y];
    }
}
