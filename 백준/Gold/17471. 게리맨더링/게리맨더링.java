import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<List<Integer>> graph;
    private static boolean[] subset, visited;
    private static Population[] population;

    private static int minimumGap;

    public static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int areaCount = Integer.parseInt(bufferedReader.readLine());

        population = new Population[areaCount + 1]; // 각 정점별 인구
        subset = new boolean[areaCount + 1]; // 부분집합
        graph = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), DELIMITER);

        for (int i = 1; i <= areaCount; i++) {
            population[i] = new Population(i, Integer.parseInt(stringTokenizer.nextToken()));
        }

        for (int i = 0; i <= areaCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= areaCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            final int connectionVertexCount = Integer.parseInt(stringTokenizer.nextToken());

            for (int j = 0; j < connectionVertexCount; j++) {
                graph.get(i).add(Integer.parseInt(stringTokenizer.nextToken()));
            }
        }

        minimumGap = Integer.MAX_VALUE;
        createSubset(0);

        if(minimumGap == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(minimumGap);
        }

    }

    private static void createSubset(final int index) {
        if (index == population.length) {
//            System.out.println(Arrays.toString(subset));
            calculateGap();

            return;
        }

        subset[index] = true;
        createSubset(index + 1);

        subset[index] = false;
        createSubset(index + 1);
    }

    private static void calculateGap() {
        final List<Integer> firstArea = new ArrayList<>();
        final List<Integer> secondArea = new ArrayList<>();

        if (checkConnectAll(firstArea, secondArea)) {
            int firstAreaSum = 0;
            int secondAreaSum = 0;

            for (Integer index : firstArea) {
                firstAreaSum += population[index].population;
            }

            for (Integer index : secondArea) {
                secondAreaSum += population[index].population;
            }

//            System.out.println("두 값의 차: " + Math.abs(firstAreaSum - secondAreaSum));
            minimumGap = Math.min(Math.abs(firstAreaSum - secondAreaSum), minimumGap);
        }

    }

    private static boolean checkConnectAll(final List<Integer> firstArea, final List<Integer> secondArea) {
        for (int i = 1; i < subset.length; i++) {
            if (subset[i]) {
                firstArea.add(i);
                continue;
            }

            secondArea.add(i);
        }

        /*System.out.println("===================");
        System.out.println(firstArea);
        System.out.println(secondArea);*/

        if (firstArea.size() == 0 || secondArea.size() == 0) {
//            System.out.println("end");
            return false;
        }

        return bfs(firstArea) && bfs(secondArea);
    }

    private static boolean bfs(final List<Integer> area) {
        final Deque<Integer> queue = new ArrayDeque<>();
        visited = new boolean[population.length];
        queue.add(area.get(0));
        visited[area.get(0)] = true;

        while (!queue.isEmpty()) {
            final Integer vertex = queue.poll();

            for (int i = 0; i < graph.get(vertex).size(); i++) {
                final Integer connectVertex = graph.get(vertex).get(i);

                if (visited[connectVertex]) {
                    continue;
                }

                if (area.contains(connectVertex)) {
                    queue.add(connectVertex);
                    visited[connectVertex] = true;
                }
            }
        }

        for (int i = 0; i < area.size(); i++) {
            if (visited[area.get(i)]) {
                continue;
            }

            return false;
        }

        return true;
    }

    static class Population {
        private int index;
        private int population;

        public Population(final int index, final int population) {
            this.index = index;
            this.population = population;
        }

        @Override
        public String toString() {
            return "Population{" +
                    "index=" + index +
                    ", population=" + population +
                    '}';
        }

    }

}
