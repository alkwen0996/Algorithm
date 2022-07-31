package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1652 {
    private static final String SPACE = " ";
    private static final char EMPTY_SPACE_SYMBOL = '.';
    private static final char NO_EMPTY_SPACE_SYMBOL = 'X';

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int sizeOfRoom = Integer.parseInt(bufferedReader.readLine());

        char[][] room = new char[sizeOfRoom][sizeOfRoom];

        for (int i = 0; i < sizeOfRoom; i++) {
            String input = bufferedReader.readLine();

            for (int j = 0; j < sizeOfRoom; j++) {
                room[i][j] = input.charAt(j);
            }
        }

        System.out.println(countEmptyPlace(room));
    }

    private static String countEmptyPlace(char[][] room) {
        int totalHorizontalCount = 0;
        int totalVerticalCount = 0;

        for (int i = 0; i < room.length; i++) {
            int count = 0;

            for (int j = 0; j < room.length; j++) {
                if (room[i][j] == EMPTY_SPACE_SYMBOL) {
                    count++;
                }

                if (room[i][j] == NO_EMPTY_SPACE_SYMBOL) {
                    if (count >= 2) {
                        totalVerticalCount++;
                    }

                    count = 0;
                }

                if (j == room.length - 1 && count >= 2) {
                    totalVerticalCount++;
                }
            }
        }

        for (int i = 0; i < room.length; i++) {
            int count = 0;

            for (int j = 0; j < room.length; j++) {
                if (room[j][i] == EMPTY_SPACE_SYMBOL) {
                    count++;
                }

                if (room[j][i] == NO_EMPTY_SPACE_SYMBOL) {
                    if (count >= 2) {
                        totalHorizontalCount++;
                    }

                    count = 0;
                }

                if (j == room.length - 1 && count >= 2) {
                    totalHorizontalCount++;
                }
            }
        }


        return totalVerticalCount + SPACE + totalHorizontalCount;
    }
}
