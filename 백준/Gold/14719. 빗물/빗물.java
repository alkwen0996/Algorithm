
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int height = Integer.parseInt(stringTokenizer.nextToken());
        final int width = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int[] buildings = new int[width];

        for (int i = 0; i < width; i++) {
            buildings[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(solution(buildings));
    }

    private static int solution(final int[] buildings) {
        int rainHeight = 0;

        for (int i = 1; i < buildings.length - 1; i++) {
            int rightHighest = -1;
            int leftHighest = -1;

            for (int j = 0; j < i; j++) {
                leftHighest = Math.max(leftHighest, buildings[j]);
            }

            for (int j = i + 1; j < buildings.length; j++) {
                rightHighest = Math.max(rightHighest, buildings[j]);
            }

            if (buildings[i] < leftHighest && buildings[i] < rightHighest) {
                rainHeight += Math.min(leftHighest, rightHighest) - buildings[i];
            }

        }

        return rainHeight;
    }

}

