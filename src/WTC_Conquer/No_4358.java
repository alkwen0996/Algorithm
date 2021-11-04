package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_4358 {
    public static final String SPACE = " ";
    public static final String NEW_LINE = "\n";
    public static final int DEFAULT_VALUE = 0;
    public static final String STRING_FORMAT = "%.4f";
    public static final int HUNDRED = 100;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final Map<String, Integer> treeTypes = new HashMap<>();

        String inputTree;
        int count = 0;

        while (true) {
            inputTree = bufferedReader.readLine();
            if (inputTree == null || inputTree.length() == 0) {
                break;
            }
            treeTypes.put(inputTree, treeTypes.getOrDefault(inputTree, DEFAULT_VALUE) + 1);
            count++;
        }

        String result = solve(treeTypes, count);
        System.out.println(result);
    }

    private static String solve(final Map<String, Integer> treeTypes, final int count) {
        final StringBuilder stringBuilder = new StringBuilder();
        final List<TreeType> treeTypeRatio = new ArrayList<>();


        for (String treeTypeKey : treeTypes.keySet()) {
            treeTypeRatio.add(new TreeType(treeTypeKey, (treeTypes.get(treeTypeKey) / (double) (count) * HUNDRED)));
        }

        treeTypeRatio.sort(Comparator.comparing(treeType -> treeType.treeType));

        for (TreeType treeType : treeTypeRatio) {
            stringBuilder.append(treeType.treeType).append(SPACE).append(String.format(STRING_FORMAT, treeType.ratio)).append(NEW_LINE);
        }

        return stringBuilder.toString();
    }

    private static class TreeType {
        private final String treeType;
        private final Double ratio;

        public TreeType(final String treeType, final Double ratio) {
            this.treeType = treeType;
            this.ratio = ratio;
        }
    }
}
