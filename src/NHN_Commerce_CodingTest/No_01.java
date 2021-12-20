package NHN_Commerce_CodingTest;

import java.util.*;

public class No_01 {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String NEW_LINE = "\n";
    public static final String BLANK = " ";

    public static void main(String[] args) {
        int n = scanner.nextInt(); // 송수신 기록의 수
        String[] logs = new String[n + 1]; // 송수신 기록
        for (int i = 0; i <= n; i++) {
            logs[i] = scanner.nextLine().trim();
        }

        String result = solve(logs);
        System.out.println(result);
    }

    private static String solve(final String[] logs) {
        final StringBuilder stringBuilder = new StringBuilder();
        final List<Record> records = new ArrayList<>();

        int count = 0;
        for (int i = 1; i < logs.length; i++) {
            if (logs[i].equals(logs[i - 1])) {
                count++;
            } else {
                records.add(new Record(logs[i - 1], count));
                if (logs.length - 1 == i) {
                    records.add(new Record(logs[i], count));
                }
                count = 0;
            }
        }


        stringBuilder.append(records.size()-1);
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).count > 0) {
                if (i == records.size() - 1) {
                    stringBuilder.append(records.get(i).recordData).append(BLANK).append("(").append(records.get(i).count + 1).append(")");
                } else {
                    stringBuilder.append(records.get(i).recordData).append(BLANK).append("(").append(records.get(i).count + 1).append(")").append(NEW_LINE);
                }
            } else {
                if (i == records.size() - 1) {
                    stringBuilder.append(records.get(i).recordData);
                } else {
                    stringBuilder.append(records.get(i).recordData).append(NEW_LINE);
                }
            }
        }

        return stringBuilder.toString();
    }

    private static class Record {
        private String recordData;
        private int count;

        public Record(final String recordData, final int count) {
            this.recordData = recordData;
            this.count = count;
        }
    }
}

/*
10
SMS 010-1234-5678
CALL 010-1234-5678
CALL 010-1234-5678
SMS 010-1111-1111
SMS 010-5555-5555
CALL 010-5555-5555
CALL 010-5555-5555
CALL 010-4444-4444
SMS 010-5555-5555
CALL 010-5555-5555

8
SMS 010-1234-5678
CALL 010-1234-5678 (2)
SMS 010-1111-1111
SMS 010-5555-5555
CALL 010-5555-5555 (2)
CALL 010-4444-4444
SMS 010-5555-5555
CALL 010-5555-5555
 */