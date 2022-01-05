package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_2606 {
    private static int computerCount; // 정점의 수
    private static int connectPairCount; // 간선의 수
    private static int[][] connectComputerRelation; // 정점간 연결관계 저장
    private static boolean[] checkVisitedComputer; // 정점 방문확인

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        computerCount = Integer.parseInt(bufferedReader.readLine());
        connectPairCount = Integer.parseInt(bufferedReader.readLine());

        connectComputerRelation = new int[computerCount + 1][computerCount + 1];
        checkVisitedComputer = new boolean[computerCount + 1];

        for (int i = 0; i < connectPairCount; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int peek1 = Integer.parseInt(stringTokenizer.nextToken());
            int peek2 = Integer.parseInt(stringTokenizer.nextToken());
            connectComputerRelation[peek1][peek2] = connectComputerRelation[peek2][peek1] = 1;
        }

        int result = solution();
        System.out.println(result);
    }

    private static int solution() {
        int start = 1;

        return bfs(start);
    }

    private static int bfs(final int start) {
        int count = 0;
        final Queue<Integer> peeks = new LinkedList<>();

        peeks.add(start);
        checkVisitedComputer[1] = true;

        while (!peeks.isEmpty()) {
            int visited = peeks.poll();
            for (int i = 1; i < connectComputerRelation.length; i++) {
                if (connectComputerRelation[visited][i] == 1 && !checkVisitedComputer[i]) {
                    peeks.add(i);
                    checkVisitedComputer[i] = true;
                    count++;
                }
            }
        }


        return count;
    }
}
