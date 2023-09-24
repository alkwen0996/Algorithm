import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int v = Integer.parseInt(stringTokenizer.nextToken());
        int e = Integer.parseInt(stringTokenizer.nextToken());

        List<List<Relation>> relations = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            relations.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            relations.get(from).add(new Relation(to, cost));
            relations.get(to).add(new Relation(from, cost));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int requiredVertex1 = Integer.parseInt(stringTokenizer.nextToken());
        int requiredVertex2 = Integer.parseInt(stringTokenizer.nextToken());

        int toRequiredVertex1 = findShortestPath(relations, 1, requiredVertex1); // 1 -> requiredVertex1까지
        int toRequiredVertex2 = findShortestPath(relations, 1, requiredVertex2); // 1 -> requiredVertex2까지

        int requiredVertex1ToVertex2 = findShortestPath(relations, requiredVertex1, requiredVertex2); // vertex1 -> requiredVertex2까지
        int requiredVertex2ToVertex1 = findShortestPath(relations, requiredVertex2, requiredVertex1); // vertex2 -> requiredVertex1까지
        int requiredVertex1ToN = findShortestPath(relations, requiredVertex1, v);
        int requiredVertex2ToN = findShortestPath(relations, requiredVertex2, v);

        boolean checkRoute = requiredVertex1ToVertex2 != Integer.MAX_VALUE; // true 면 경로 존재

        if (toRequiredVertex2 == Integer.MAX_VALUE || requiredVertex2ToN == Integer.MAX_VALUE) {
            checkRoute = false;
        }

        if (toRequiredVertex1 == Integer.MAX_VALUE || requiredVertex1ToN == Integer.MAX_VALUE) {
            checkRoute = false;
        }

        int minimumDistance = -1;

        if (checkRoute) {
            int routeA = toRequiredVertex1 + requiredVertex1ToVertex2 + requiredVertex2ToN;
            int routeB = toRequiredVertex2 + requiredVertex2ToVertex1 + requiredVertex1ToN;

            minimumDistance = Math.min(routeA, routeB);
        }

        System.out.println(minimumDistance);
    }

    private static int findShortestPath(final List<List<Relation>> relations, final int start, final int destination) {
        Queue<Relation> queue = new PriorityQueue<>();
        queue.add(new Relation(start, 0));

        int[] minimumPathLength = new int[relations.size()];
        Arrays.fill(minimumPathLength, Integer.MAX_VALUE);
        minimumPathLength[start] = 0;

        while (!queue.isEmpty()) {
            Relation vertex = queue.poll();

            if (minimumPathLength[vertex.to] < vertex.cost) {
                continue;
            }

            for (int i = 0; i < relations.get(vertex.to).size(); i++) {
                Relation relation = relations.get(vertex.to).get(i);

                if (minimumPathLength[relation.to] > vertex.cost + relation.cost) {
                    minimumPathLength[relation.to] = vertex.cost + relation.cost;
                    queue.add(new Relation(relation.to, minimumPathLength[relation.to]));
                }
            }
        }

        if (minimumPathLength[destination] == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return minimumPathLength[destination];
    }

    static class Relation implements Comparable<Relation> {
        private int to;
        private int cost;

        public Relation(final int to, final int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Relation{" +
                    "to=" + to +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public int compareTo(final Relation relation) {
            return this.cost - relation.cost;
        }

    }

}