import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Solution {

    private static int minimumHeight;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int clerkCount = Integer.parseInt(stringTokenizer.nextToken());
            final int shelfHeight = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            final int[] clerksHeight = new int[clerkCount];
            final boolean[] isSelected = new boolean[clerkCount];

            for (int j = 0; j < clerkCount; j++) {
                clerksHeight[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            minimumHeight = Integer.MAX_VALUE;
            selectClerk(clerksHeight, isSelected, shelfHeight, 0);
            stringBuilder.append("#").append(i).append(" ").append((minimumHeight - shelfHeight)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static void selectClerk(final int[] clerksHeight, final boolean[] isSelected, final int shelfHeight, final int count) {
        if (count == clerksHeight.length) {
            int sum = 0;

            for (int i = 0; i < isSelected.length; i++) {
                if (isSelected[i]) {
                    sum += clerksHeight[i];
//                    System.out.print(clerksHeight[i] + " ");
                }
            }

//            System.out.println();
            if (sum >= shelfHeight) {
                minimumHeight = Math.min(minimumHeight, sum);
            }

            return;
        }

        isSelected[count] = true;
        selectClerk(clerksHeight, isSelected, shelfHeight, count + 1);
        isSelected[count] = false;
        selectClerk(clerksHeight, isSelected, shelfHeight, count + 1);
    }

}
