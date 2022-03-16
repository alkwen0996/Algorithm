package BaekJoon.Loop_For;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int X = Integer.parseInt(stringTokenizer.nextToken());


        stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        while (stringTokenizer.hasMoreTokens()){
            int num = Integer.parseInt(stringTokenizer.nextToken());
            if(num< X){
                System.out.print(num+" ");
            }
        }

        bufferedReader.close();
    }
}
