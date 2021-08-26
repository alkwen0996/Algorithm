package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class No_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        List<Integer> numbers = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()){
            StringBuffer stringBuffer = new StringBuffer(stringTokenizer.nextToken());
            numbers.add(Integer.parseInt(stringBuffer.reverse().toString()));
        }

        int bigNumber = numbers.stream()
                .max(Comparator.comparingInt(it -> it))
                .get();

        System.out.println(bigNumber);

    }
}
