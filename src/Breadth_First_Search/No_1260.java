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
    private static int[][] peeksDFS;
    private static int[][] peeksBFS;
    private static boolean[] checkVisitedDFS;
    private static boolean[] checkVisitedBFS;
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());

        final int peeksCount = Integer.parseInt(stringTokenizer1.nextToken());
        final int linkCount = Integer.parseInt(stringTokenizer1.nextToken());
        final int startPeek = Integer.parseInt(stringTokenizer1.nextToken());

        peeksDFS = new int[peeksCount + 1][peeksCount + 1];
        checkVisitedDFS = new boolean[peeksCount + 1];
        checkVisitedDFS[startPeek] = true;

        peeksBFS = new int[peeksCount + 1][peeksCount + 1];
        checkVisitedBFS = new boolean[peeksCount + 1];
        checkVisitedBFS[startPeek] = true;

        for (int i = 0; i < linkCount; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int peek1 = Integer.parseInt(stringTokenizer.nextToken());
            int peek2 = Integer.parseInt(stringTokenizer.nextToken());

            peeksDFS[peek1][peek2] = peeksDFS[peek2][peek1] = 1;
            peeksBFS[peek1][peek2] = peeksBFS[peek2][peek1] = 1;
        }

        String result = solution(startPeek);
        System.out.println(result);
    }

    private static String solution(final int startPeek) {
        dfs(startPeek, stringBuilder);
        stringBuilder.append(NEW_LINE).append(bfs(startPeek));

        return stringBuilder.toString();
    }

    private static void dfs(final int startPeek, StringBuilder stringBuilder) {
        final Stack<Integer> visitPeeks = new Stack<>();

        visitPeeks.push(startPeek);
        checkVisitedDFS[startPeek] = true;

        stringBuilder.append(startPeek).append(SPACE);

        while (!visitPeeks.isEmpty()) {
            for (int i = 1; i < peeksDFS.length; i++) {
                if (peeksDFS[startPeek][i] == 1 && !checkVisitedDFS[i]) {
                    visitPeeks.push(i);
                    checkVisitedDFS[i] = true;
                    dfs(i, stringBuilder);
                }
            }
            visitPeeks.pop();
        }
    }

    private static String bfs(final int startPeek) {
        final StringBuilder bfsStringBuilder = new StringBuilder();
        final Queue<Integer> visitPeeks = new LinkedList<>();

        visitPeeks.add(startPeek);
        bfsStringBuilder.append(startPeek).append(SPACE);
        checkVisitedBFS[startPeek] = true;

        while (!visitPeeks.isEmpty()) {

            int visitedPeek = visitPeeks.poll();
            for (int i = 1; i < peeksBFS.length; i++) {

                if (peeksBFS[visitedPeek][i] == 1 && !checkVisitedBFS[i]) {
                    checkVisitedBFS[i] = true;
                    visitPeeks.add(i);
                    bfsStringBuilder.append(i).append(SPACE);
                }

            }
        }

        return bfsStringBuilder.append(NEW_LINE).toString();
    }
}
