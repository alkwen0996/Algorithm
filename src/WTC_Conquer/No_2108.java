package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class No_2108 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        final List<Integer> values = new ArrayList<>();

        while (N-- > 0) {
            values.add(Integer.parseInt(bufferedReader.readLine()));
        }

        String result = solve(values);
        System.out.println(result);
    }

    private static String solve(final List<Integer> values) {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(average(values)).append("\n");
        stringBuilder.append(middle(values)).append("\n");
        stringBuilder.append(mode(values)).append("\n");
        stringBuilder.append(range(values)).append("\n");

        return stringBuilder.toString();
    }

    private static int mode(final List<Integer> values) {
        final Map<Integer, Integer> counts = new HashMap<>();

        values.sort((value1, value2) -> {
            if (value1 > value2) {
                return 1;
            } else if (value2 > value1) {
                return -1;
            }
            return 0;
        });

        for (Integer value : values) {
            counts.put(value, 0);
        }

        for (Integer value : values) {
            int count = counts.get(value) + 1;
            counts.put(value, count);
        }

        int mode = counts.get(values.get(0));
        for (Integer integer : values) {
            if (mode < counts.get(integer)) {
                mode = counts.get(integer);
            }
        }

        boolean checkModeMany = false;
        for (Integer value : values) {
            if (mode == counts.get(value)) {
                checkModeMany = true;
            }
        }

        final List<Integer> modes = new ArrayList<>();
        if (checkModeMany) {
            for (Entry<Integer, Integer> key : counts.entrySet()) {
                if (mode == key.getValue()) {
                    modes.add(key.getKey());
                }
            }
        }

        if (modes.size() > 1) {
            Collections.sort(modes);
            mode = modes.get(1);
        } else {
            mode = modes.get(0);
        }

        return mode;
    }

    private static int range(final List<Integer> values) {
        return Collections.max(values) - Collections.min(values);
    }

    private static int middle(final List<Integer> values) {
        values.sort((value1, value2) -> {
            if (value1 > value2) {
                return 1;
            } else if (value2 > value1) {
                return -1;
            }
            return 0;
        });

        return values.get((values.size() / 2));
    }

    private static int average(final List<Integer> values) {
        double average = 0;

        for (Integer value : values) {
            average += value;
        }

        return (int) Math.round(average / values.size());
    }
}
