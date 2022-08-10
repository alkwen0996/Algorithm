package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static int height;
    private static int width;
    private static int rotateCount;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        height = Integer.parseInt(stringTokenizer.nextToken());
        width = Integer.parseInt(stringTokenizer.nextToken());
        rotateCount = Integer.parseInt(stringTokenizer.nextToken());

        final int[][] array = new int[height][width];
        final int[][] rotateArray = new int[height][width];
        final int boxCount = Math.min(height, width) / 2;

        for (int i = 0; i < height; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < width; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                rotateArray[i][j] = array[i][j];
            }
        }

        System.out.println(rotateArrayAsCount(array, rotateArray, boxCount));
    }

    private static StringBuilder rotateArrayAsCount(int[][] array, final int[][] rotateArray, final int boxCount) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= rotateCount; i++) {
            rotateArrayOnce(array, rotateArray, boxCount);

            for (int j = 0; j < rotateArray.length; j++) {
                System.arraycopy(rotateArray[j], 0, array[j], 0, array[j].length);
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                stringBuilder.append(rotateArray[i][j]).append(SPACE);
            }
            stringBuilder.append(NEW_LINE);
        }

        return stringBuilder;
    }

    private static void rotateArrayOnce(final int[][] array, final int[][] rotateArray, final int boxCount) {
        for (int i = 0; i < boxCount; i++) {
            for (int j = i; j < height - i; j++) {
                if (j + 1 < height - i) {
                    rotateArray[j + 1][i] = array[j][i];
                }
            }

            for (int j = i; j < width - i; j++) {
                if (j + 1 < width - i) {
                    rotateArray[height - i - 1][j + 1] = array[height - i - 1][j];
                }
            }

            for (int j = height - 1 - i; j >= i; j--) {
                if (j - 1 >= i) {
                    rotateArray[j - 1][width - i - 1] = array[j][width - i - 1];
                }
            }

            for (int j = width - 1 - i; j >= i; j--) {
                if (j - 1 >= i) {
                    rotateArray[i][j - 1] = array[i][j];
                }
            }

        }

    }
}
