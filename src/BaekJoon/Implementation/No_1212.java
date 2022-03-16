package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1212 {
    public static void main(String args[]) throws IOException {

        String [] two = {"000","001","010","011","100","101","110","111"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int inputLen = input.length();
        boolean first = true;

        if(inputLen == 1 && input.charAt(0) == '0')
            System.out.print(0);

        for (int i=0;i<inputLen;i++){
            int tmp = input.charAt(i)-'0';

            if(first && tmp<4){
                if(tmp == 0)
                    continue;
                else if(tmp == 1)
                    System.out.print("1");
                else if(tmp == 2)
                    System.out.print("10");
                else if(tmp == 3)
                    System.out.print("11");
                first = false;
            }else{
                System.out.print(two[tmp]);
                first = false;
            }
        }// for_i

    }// main
}// class
