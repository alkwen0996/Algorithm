package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1966 {
    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCase = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int documentCount = Integer.parseInt(stringTokenizer.nextToken());
            int printDocumentPosition = Integer.parseInt(stringTokenizer.nextToken());

            final Deque<Document> documentImportanceAndOrder = new ArrayDeque<>();
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int order = 0;
            int documentImportance = 0;

            while (stringTokenizer.hasMoreTokens()) {
                int importance = Integer.parseInt(stringTokenizer.nextToken());

                if (order == printDocumentPosition) {
                    documentImportance = importance;
                }
                documentImportanceAndOrder.add(new Document(importance, order++));
            }

            stringBuilder.append(solution(documentImportance, printDocumentPosition, documentImportanceAndOrder)).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int solution(final int documentImportance, final int printDocumentPosition, final Deque<Document> documentImportanceAndOrder) {
        int printDocumentOrder = 1;

        if (documentImportanceAndOrder.size() > 1) {
            while (documentImportanceAndOrder.size() > 1) {
                Document document = documentImportanceAndOrder.pollFirst();

                int max = documentImportanceAndOrder.stream()
                        .mapToInt(a -> a.importance)
                        .max()
                        .getAsInt();

                if (document.importance < max) {
                    documentImportanceAndOrder.addLast(document);
                } else {
                    if (document.importance == documentImportance && document.order == printDocumentPosition) {
                        break;
                    }
                    printDocumentOrder++;
                }
            }
        } else {
            return 1;
        }

        return printDocumentOrder;
    }

    private static class Document {
        private int importance;
        private int order;

        public Document(final int importance, final int order) {
            this.importance = importance;
            this.order = order;
        }
    }
}
