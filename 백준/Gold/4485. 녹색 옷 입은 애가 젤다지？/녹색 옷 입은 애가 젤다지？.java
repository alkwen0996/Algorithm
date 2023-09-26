import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final String NEW_LINE = "\n";
	private static final String COLON = ":";
	private static final String SPACE = " ";
	private static final String PROBLEM = "Problem";
	private static final String EOF = "0";

	private static final int[] dx = { 1, 0, -1, 0 };
	private static final int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		final StringBuilder stringBuilder = new StringBuilder();
		String input;
		int index = 1;

		while ((input = bufferedReader.readLine()) != EOF) {
			if (input.equals(EOF)) {
				break;
			}

			final int caveLength = Integer.parseInt(input);
			final int[][] cave = new int[caveLength][caveLength];

			for (int i = 0; i < caveLength; i++) {
				final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

				for (int j = 0; j < caveLength; j++) {
					cave[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}

			stringBuilder.append(PROBLEM).append(SPACE).append(index).append(COLON).append(SPACE)
					.append(findMinimumPath(cave)).append(NEW_LINE);
			index++;
		}

		System.out.println(stringBuilder);
	}

	private static int findMinimumPath(final int[][] cave) {
		final int[][] minimumCosts = new int[cave.length][cave.length];
		final boolean[][] visited = new boolean[cave.length][cave.length];
		
		for (int i = 0; i < minimumCosts.length; i++) {
			Arrays.fill(minimumCosts[i], Integer.MAX_VALUE);
		}

		final Queue<Vertex> priorityQueue = new PriorityQueue<>((Vertex vertex1, Vertex vertex2) -> vertex1.weight - vertex2.weight);
		priorityQueue.offer(new Vertex(new Point(0, 0), cave[0][0]));
		minimumCosts[0][0] = cave[0][0];

		while (!priorityQueue.isEmpty()) {
//			System.out.println("-------------------");
//			for (int i = 0; i < minimumCosts.length; i++) {
//				System.out.println(Arrays.toString(minimumCosts[i]));
//			}
//			System.out.println();
//			for (int i = 0; i < visited.length; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}

			final Vertex vertex = priorityQueue.poll();

			final int currentX = vertex.point.x;
			final int currentY = vertex.point.y;
			visited[currentX][currentY] = true;

			for (int i = 0; i < dx.length; i++) {
				final int nextX = currentX + dx[i];
				final int nextY = currentY + dy[i];

				if (nextX >= 0 && nextY >= 0 && nextX < cave.length && nextY < cave.length) {
//					System.out.println(minimumCosts[nextX][nextY] + " / " + (vertex.weight + cave[nextX][nextY]));
					if (minimumCosts[nextX][nextY] < vertex.weight + cave[nextX][nextY] || visited[nextX][nextY]) {
						continue;
					}

					minimumCosts[nextX][nextY] = vertex.weight + cave[nextX][nextY];
					priorityQueue.add(new Vertex(new Point(nextX, nextY), minimumCosts[nextX][nextY]));
				}
			}
		}

		return minimumCosts[cave.length - 1][cave.length - 1];
	}

	static class Vertex {
		private Point point;
		private int weight;

		public Vertex(Point point, int weight) {
			super();
			this.point = point;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Vertex [point=" + point + ", weight=" + weight + "]";
		}

	}

}
