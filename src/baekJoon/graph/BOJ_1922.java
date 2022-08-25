package baekJoon.graph;

import java.io.BufferedReader;
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

public class BOJ_1922 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOfComputer = Integer.parseInt(bufferedReader.readLine());
        final int numberOfLine = Integer.parseInt(bufferedReader.readLine());

        final List<List<Computer>> connections = new ArrayList<>();

        for (int i = 0; i <= numberOfComputer; i++) {
            connections.add(new ArrayList<>());
        }

        for (int i = 1; i <= numberOfLine; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int computer1 = Integer.parseInt(stringTokenizer.nextToken());
            final int computer2 = Integer.parseInt(stringTokenizer.nextToken());
            final int cost = Integer.parseInt(stringTokenizer.nextToken());

            connections.get(computer1).add(new Computer(computer2, cost));
            connections.get(computer2).add(new Computer(computer1, cost));
        }

        System.out.println(calculateMinimumCost(numberOfComputer, connections));
    }

    private static int calculateMinimumCost(final int numberOfComputer, final List<List<Computer>> connections) {
        final Queue<Computer> computers = new PriorityQueue<>(Comparator.comparingInt(computer -> computer.connectCost));

        final int[] minimumEdge = new int[numberOfComputer + 1];
        final boolean[] visited = new boolean[numberOfComputer + 1];

        Arrays.fill(minimumEdge, Integer.MAX_VALUE);
        minimumEdge[1] = 0;
        computers.offer(new Computer(1, minimumEdge[1]));

        int totalCost = 0;
        int count = 0;

        while (!computers.isEmpty()) {
            final Computer connection = computers.poll();

            if (visited[Objects.requireNonNull(connection).computer]) {
                continue;
            }

            visited[connection.computer] = true;
            totalCost += connection.connectCost;
            count++;

            if (count == numberOfComputer) {
                break;
            }

            for (int i = 0; i < connections.get(connection.computer).size(); i++) {
                final Computer checkConnection = connections.get(connection.computer).get(i);

                if (visited[checkConnection.computer] || minimumEdge[checkConnection.computer] <= checkConnection.connectCost) {
                    continue;
                }

                minimumEdge[checkConnection.computer] = checkConnection.connectCost;
                computers.offer(new Computer(checkConnection.computer, minimumEdge[checkConnection.computer]));
            }
        }

        return totalCost;
    }

    static class Computer {
        private final int computer;
        private final int connectCost;

        public Computer(final int computer, final int connectCost) {
            this.computer = computer;
            this.connectCost = connectCost;
        }

        @Override
        public String toString() {
            return "Connection{" +
                    "computer=" + computer +
                    ", connectCost=" + connectCost +
                    '}';
        }

    }

}
