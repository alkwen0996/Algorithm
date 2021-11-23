package Breadth_First_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class No_1260 {
    public static final String NEW_LINE = "\n";
    public static final String SPACE = " ";
    private static int[][] peeks;
    private static boolean[] checkVisited;
    private static final StringBuilder stringBuilderDFS = new StringBuilder();
    private static final StringBuilder stringBuilderBFS = new StringBuilder();

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int peeksCount = Integer.parseInt(stringTokenizer.nextToken());
        final int linkCount = Integer.parseInt(stringTokenizer.nextToken());
        final int startPeek = Integer.parseInt(stringTokenizer.nextToken());

        peeks = new int[peeksCount + 1][peeksCount + 1];

        for (int i = 0; i < linkCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int peek1 = Integer.parseInt(stringTokenizer.nextToken());
            int peek2 = Integer.parseInt(stringTokenizer.nextToken());

            peeks[peek1][peek2] = peeks[peek2][peek1] = 1;
        }

        checkVisited = new boolean[peeksCount + 1];
        dfs(startPeek);

        checkVisited = new boolean[peeksCount + 1];
        bfs(startPeek);

        System.out.println(stringBuilderDFS);
        System.out.println(stringBuilderBFS);
    }

    private static void dfs(final int startPeek) {
        final Stack<Integer> visitPeeks = new Stack<>();

        visitPeeks.push(startPeek);
        checkVisited[startPeek] = true;

        stringBuilderDFS.append(startPeek).append(SPACE);

        while (!visitPeeks.isEmpty()) {
            for (int i = 1; i < peeks.length; i++) {
                if (peeks[startPeek][i] == 1 && !checkVisited[i]) {
                    visitPeeks.push(i);
                    checkVisited[i] = true;
                    dfs(i);
                }
            }
            visitPeeks.pop();
        }
    }

    private static void bfs(final int startPeek) {
        final Queue<Integer> visitPeeks = new LinkedList<>();

        visitPeeks.add(startPeek);
        checkVisited[startPeek] = true;
        stringBuilderBFS.append(startPeek).append(SPACE);

        while (!visitPeeks.isEmpty()) {
            int visitedPeek = visitPeeks.poll();

            for (int i = 1; i < peeks.length; i++) {
                if (peeks[visitedPeek][i] == 1 && !checkVisited[i]) {
                    checkVisited[i] = true;
                    visitPeeks.add(i);

                    stringBuilderBFS.append(i).append(SPACE);
                }
            }
        }

    }
}
