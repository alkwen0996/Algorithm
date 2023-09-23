
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static final String NEW_LINE = "\n";
	private static final String INF = "INF";

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		final int vertexCount = Integer.parseInt(stringTokenizer.nextToken());
		final int edgeCount = Integer.parseInt(stringTokenizer.nextToken());

		final int startVertex = Integer.parseInt(bufferedReader.readLine());

		final List<List<Vertex>> connections = new ArrayList<>();

		for (int i = 0; i <= vertexCount; i++) {
			connections.add(new ArrayList<>());
		}

		for (int i = 0; i < edgeCount; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			final int vertex1 = Integer.parseInt(stringTokenizer.nextToken());
			final int vertex2 = Integer.parseInt(stringTokenizer.nextToken());
			final int weight = Integer.parseInt(stringTokenizer.nextToken());

			connections.get(vertex1).add(new Vertex(vertex2, weight));
		}

		findShortestPath(vertexCount, startVertex, connections);
	}

	private static void findShortestPath(final int vertexCount, final int startVertex, final List<List<Vertex>> connections) {
		final Queue<Vertex> vertexes = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));
		final int[] minimumEdge = new int[vertexCount + 1];
		Arrays.fill(minimumEdge, Integer.MAX_VALUE);

		vertexes.add(new Vertex(startVertex, 0));
		minimumEdge[startVertex] = 0;

		while (!vertexes.isEmpty()) {
			final Vertex vertex = vertexes.poll();

			if (minimumEdge[Objects.requireNonNull(vertex).connectComputer] < vertex.weight) {
				continue;
			}

			for (int i = 0; i < connections.get(vertex.connectComputer).size(); i++) {
				final Vertex checkVertex = connections.get(vertex.connectComputer).get(i);

				if (minimumEdge[checkVertex.connectComputer] > vertex.weight + checkVertex.weight) {
					minimumEdge[checkVertex.connectComputer] = vertex.weight + checkVertex.weight;
					vertexes.add(new Vertex(checkVertex.connectComputer, minimumEdge[checkVertex.connectComputer]));
				}
			}
		}

		displayShortestPath(vertexCount, minimumEdge);
	}

	private static void displayShortestPath(final int vertexCount, final int[] minimumEdge) {
		final StringBuilder stringBuilder = new StringBuilder();

		for (int i = 1; i <= vertexCount; i++) {
			if (minimumEdge[i] == Integer.MAX_VALUE) {
				stringBuilder.append(INF).append(NEW_LINE);
				continue;
			}

			stringBuilder.append(minimumEdge[i]).append(NEW_LINE);
		}

		System.out.println(stringBuilder);
	}

	static class Vertex {
		private final int connectComputer;
		private final int weight;

		public Vertex(final int connectComputer, final int weight) {
			this.connectComputer = connectComputer;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Vertex{" + "connectComputer=" + connectComputer + ", weight=" + weight + '}';
		}
	}

}
