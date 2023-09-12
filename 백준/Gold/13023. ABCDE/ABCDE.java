import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static final String NEW_LINE = "\n";
    public static final String SPACE = " ";
    public static int isAllFriend, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int person1 = Integer.parseInt(stringTokenizer.nextToken());
            int person2 = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(person1).add(person2);
            graph.get(person2).add(person1);
        }

        isAllFriend = 0;
        boolean[] isVisited;

        for (int i = 0; i < N; i++) {
            isVisited = new boolean[N];
            isVisited[i] = true;
            checkFriend(0, i, isVisited, graph);

            if (isAllFriend == 1) {
                break;
            }
        }

        System.out.println(isAllFriend);
    }

    private static void checkFriend(final int depth, final int personNumber, final boolean[] isVisited, final List<List<Integer>> graph) {
        if (depth == 4) {
            isAllFriend = 1;

            return;
        }

        for (int i = 0; i < graph.get(personNumber).size(); i++) {
            Integer person = graph.get(personNumber).get(i);

            if (isVisited[person]) {
                continue;
            }

            isVisited[person] = true;
            checkFriend(depth + 1, person, isVisited, graph);
            isVisited[person] = false;
        }
    }

}