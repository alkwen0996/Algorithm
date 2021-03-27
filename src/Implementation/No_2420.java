package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2420 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long fir = 0,sec=0;


        while(st.hasMoreTokens()){
            fir = Long.parseLong(st.nextToken());
            sec = Long.parseLong(st.nextToken());
        }

        System.out.println(Math.abs(fir-sec));

    }// main
}// class
