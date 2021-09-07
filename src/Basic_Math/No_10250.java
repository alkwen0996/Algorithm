package Basic_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10250 {
    public static final int START_ROOM_NO = 101;
    public static final int HUNDRED = 100;
    public static final int ONE = 1;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int inputTestCase = Integer.parseInt(bufferedReader.readLine());
        System.out.println(inputTestCase);
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inputTestCase; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            stringBuilder.append(solve(stringTokenizer)).append('\n');
        }
        System.out.println(stringBuilder);
    }

    private static int solve(final StringTokenizer stringTokenizer) {
        int H = Integer.parseInt(stringTokenizer.nextToken());
        int W = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        System.out.println("H: " + H + " W: " + W + " N: " + N);

        int roomNo = START_ROOM_NO; // 101
        int count = ONE; // 1
        int roomHeight = H * HUNDRED; // 6 * 100, 30 * 100
        System.out.println("roomHeight: " + roomHeight);

        while(count+1 < N){
            if (roomNo / roomHeight == ONE) {
                roomNo = roomNo - ((H - ONE) * HUNDRED) + ONE;
            }
            System.out.println("roomNo: " + roomNo + " count:" + count + " N: " + N);
            roomNo += HUNDRED;
            count++;
        }

        return roomNo;
    }
}
