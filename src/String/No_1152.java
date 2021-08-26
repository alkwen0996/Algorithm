package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputData = bufferedReader.readLine();

        StringTokenizer stringTokenizer = new StringTokenizer(inputData);
        List<String> words = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens()){
            words.add(stringTokenizer.nextToken());
        }

        System.out.println(words.size());
    }
}
