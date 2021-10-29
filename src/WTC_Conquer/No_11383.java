package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_11383 {
    public static final String NOT_EYFA = "Not Eyfa";
    public static final String EYFA = "Eyfa";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        final List<String> firstImages = new ArrayList<>();
        final List<String> secondImages = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            firstImages.add(bufferedReader.readLine());
        }

        for (int i = 0; i < N; i++) {
            secondImages.add(bufferedReader.readLine());
        }

        String result = solve(firstImages, secondImages);
        System.out.println(result);
    }

    private static String solve(final List<String> firstImages, final List<String> secondImages) {
        String result = EYFA;

        for (int i = 0; i < firstImages.size(); i++) {
            if (!checkImage(firstImages.get(i), secondImages.get(i))) {
                result = NOT_EYFA;
            }
        }

        return result;
    }

    private static boolean checkImage(final String firstImage, final String secondImage) {
        final StringBuilder firstImageCopyLetters = new StringBuilder();
        char[] firstImageCharacters = firstImage.toCharArray();

        for (final char firstImageCharacter : firstImageCharacters) {
            firstImageCopyLetters.append(firstImageCharacter).append(firstImageCharacter);
        }

        return firstImageCopyLetters.toString().equals(secondImage);
    }
}
