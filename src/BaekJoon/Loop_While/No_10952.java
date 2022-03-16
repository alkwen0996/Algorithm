package BaekJoon.Loop_While;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            if(a+b==0){
                break;
            }
            System.out.println(a+b);
        }
    }
}
