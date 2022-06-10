package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int sizeOfQueue = Integer.parseInt(stringTokenizer.nextToken());
        final int numberOfExtractions = Integer.parseInt(stringTokenizer.nextToken());
        final int[] indexOfExtractions = new int[numberOfExtractions + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= numberOfExtractions; i++) {
            indexOfExtractions[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        final LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= sizeOfQueue; i++) {
            queue.add(i);
        }

        System.out.println(solution(indexOfExtractions, queue));
    }

    private static int solution(final int[] indexOfExtractions, final LinkedList<Integer> queue) {
        int count = 0;

        for (int i = 1; i < indexOfExtractions.length; i++) {
            final int targetIndex = queue.indexOf(indexOfExtractions[i]);
            int halfIndex;

            if (queue.size() % 2 == 0) {
                halfIndex = (queue.size() / 2) - 1;
            } else {
                halfIndex = queue.size() / 2;
            }

            if (targetIndex <= halfIndex) {
                for (int j = 0; j < targetIndex; j++) {
                    if (!queue.isEmpty()) {
                        final int first = queue.pollFirst();
                        queue.addLast(first);
                        count++;
                    }
                }
            } else {
                for (int j = 0; j < queue.size() - targetIndex; j++) {
                    final int last = queue.pollLast();
                    queue.addFirst(last);
                    count++;
                }
            }

            queue.pollFirst();
        }


        return count;
    }
}
