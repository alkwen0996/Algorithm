package BaekJoon.Loop_While;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while((input=bufferedReader.readLine()) != null){
            StringTokenizer stringTokenizer = new StringTokenizer(input," ");
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(a+b);
        }

    }
}
