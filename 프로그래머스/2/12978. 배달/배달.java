import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<Node>> graph = new ArrayList<>();
        int[] isVisited = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(isVisited, Integer.MAX_VALUE);

        for (int i = 0; i < road.length; i++) {
            int vertex1 = road[i][0];
            int vertex2 = road[i][1];
            int weight = road[i][2];

            graph.get(vertex1).add(new Node(vertex2, weight));
            graph.get(vertex2).add(new Node(vertex1, weight));
        }

        return dijkstra(N, K, graph, isVisited);
    }
    
    public int dijkstra(int n, int k, List<List<Node>> graph, int[] isVisited) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(1, 0));
        isVisited[1] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int to = node.to;

            for (int i = 0; i < graph.get(to).size(); i++) {
                Node nextNode = graph.get(to).get(i);

                if (isVisited[nextNode.to] > nextNode.weight + isVisited[to]) {
                    isVisited[nextNode.to] = nextNode.weight + isVisited[to];
                    queue.add(nextNode);
                }
            }
        }

        int count = 0;

        for (int i = 1; i < isVisited.length; i++) {
            if (isVisited[i] <= k) {
                count++;
            }
        }

        return count;
    }
    
    class Node {
        private int to;
        private int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}