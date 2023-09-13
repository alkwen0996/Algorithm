import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static final String NO_SAFETY = "KAKTUS";
	private static final char BLANK = '.';
	private static final char WATER = '*';
	private static final char STONE = 'X';
	private static final char BEAVER_HOUSE_SYMBOL = 'D';
	private static final char HEDGEHOG_SYMBOL = 'S';

	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static char[][] map;
	private static boolean[][] visited;
	private static Queue<Point> waterPoints;

	public static void main(String[] args) throws IOException {
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		final int row = Integer.parseInt(stringTokenizer.nextToken());
		final int column = Integer.parseInt(stringTokenizer.nextToken());

		map = new char[row][column];
		waterPoints = new LinkedList<>();

		Point hedgehog = null;
		Point beaverHouse = null;

		for (int i = 0; i < row; i++) {
			final String line = bufferedReader.readLine();

			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j);

				if (map[i][j] == HEDGEHOG_SYMBOL) {
					hedgehog = new Point(i, j);
					continue;
				}

				if (map[i][j] == BEAVER_HOUSE_SYMBOL) {
					beaverHouse = new Point(i, j);
					continue;
				}

				if (map[i][j] == WATER) {
					waterPoints.offer(new Point(i, j));
					continue;
				}
			}
		}
//		printMap();

		visited = new boolean[row][column];
		search(hedgehog, beaverHouse);
	}

	private static void search(Point hedgehogStart, Point beaverHouse) {
		final Queue<Point> hedgehogQueue = new LinkedList<>();
		hedgehogQueue.add(hedgehogStart);
		visited[hedgehogStart.x][hedgehogStart.y] = true;
		
		int count = 0;

		while (!hedgehogQueue.isEmpty()) {
//			System.out.println("---------------------------");
//			System.out.println("큐: " + queue.toString());
			if(beaverHouse.x == hedgehogStart.x && beaverHouse.y==hedgehogStart.y) {
				break;
			}
			
			final int queueSize = hedgehogQueue.size();
			sparedWater();
//			printMap();
			count++;

			for (int i = 0; i < queueSize; i++) {
				final Point currentHedgehog = hedgehogQueue.poll();

				final int currentX = currentHedgehog.x;
				final int currentY = currentHedgehog.y;
				map[currentX][currentY] = BLANK;

				for (int j = 0; j < dx.length; j++) {
					final int nextX = currentX + dx[j];
					final int nextY = currentY + dy[j];

					if (nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map[0].length) {
						if (visited[nextX][nextY] || map[nextX][nextY] == STONE || map[nextX][nextY] == WATER) {
							continue;
						}

						visited[nextX][nextY] = true;
						hedgehogQueue.add(new Point(nextX, nextY));
						
						if(map[nextX][nextY] == BEAVER_HOUSE_SYMBOL) {
							hedgehogStart.x = nextX;
							hedgehogStart.y = nextY;
						}
					
						map[nextX][nextY] = HEDGEHOG_SYMBOL;
					}
				}
			}
		}

//		System.out.println("마지막 고슴도치 위치: " + hedgehogStart.x + " / " + hedgehogStart.y);
//		printMap();

		if (beaverHouse.x == hedgehogStart.x && beaverHouse.y == hedgehogStart.y) {
			System.out.println(count);
		} else {
			System.out.println(NO_SAFETY);
		}
	}

	private static void sparedWater() {
		final int size = waterPoints.size();
//		System.out.println("물큐: " + waterPoints.toString());

		for (int i = 0; i < size; i++) {
			final Point waterPoint = waterPoints.poll();

			final int currentPointX = waterPoint.x;
			final int currentPointY = waterPoint.y;

			for (int k = 0; k < dx.length; k++) {
				final int nextX = currentPointX + dx[k];
				final int nextY = currentPointY + dy[k];

				if (nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map[0].length) {
					if (map[nextX][nextY] == STONE || map[nextX][nextY] == WATER || map[nextX][nextY] == BEAVER_HOUSE_SYMBOL) {
						continue;
					}

					map[nextX][nextY] = WATER;
					waterPoints.offer(new Point(nextX, nextY));
				}
			}
		}
	}

	private static void printMap() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

}
