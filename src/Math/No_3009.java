package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No_3009 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<Integer> x = new ArrayList<>();
        final List<Integer> y = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            x.add(Integer.parseInt(stringTokenizer.nextToken()));
            y.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        Collections.sort(x);
        Collections.sort(y);

        solve(x, y);
    }

    private static void solve(final List<Integer> x, final List<Integer> y) {
        final StringBuilder stringBuilder = new StringBuilder();

        if(!x.get(0).equals(x.get(1))){
            stringBuilder.append(x.get(0)).append(" ");
        }else{
            stringBuilder.append(x.get(2)).append(" ");
        }

        if(!y.get(0).equals(y.get(1))){
            stringBuilder.append(y.get(0)).append(" ");
        }else{
            stringBuilder.append(y.get(2)).append(" ");
        }

        System.out.println(stringBuilder.toString());

    }
}
