import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        final Queue<Document> printOrder = new LinkedList<>();
        int answer = 1;
        int printIndex = 0;

        for (int i = 0; i < priorities.length; i++) {
            printOrder.offer(new Document(priorities[i], i));
            if (i == location) {
                printIndex = i;
            }
        }

        while (printOrder.size() > 1) {
            Document printDocument = printOrder.poll();

            int maxOrder = printOrder.stream()
                    .mapToInt(x -> x.order)
                    .max()
                    .getAsInt();

            if (printDocument.order < maxOrder) {
                printOrder.offer(printDocument);
            } else {
                if (printDocument.index == printIndex && printDocument.order == priorities[location]) {
                    return answer;
                }
                answer++;
            }
        }

        return answer;
    }
    
static class Document {
        private int order;
        private int index;

        public Document(final int order, final int index) {
            this.order = order;
            this.index = index;
        }
    }
}