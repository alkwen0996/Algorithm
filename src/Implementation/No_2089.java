package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2089 {
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        if(input==0)
            System.out.println(0);
        else {
            binary(input);
            System.out.println();
        }

    }//main

    private static void binary(int input){

        if(input==0)
            return ;

        if(input%2 == 0) {
            binary(-(input/2));
            System.out.print(0);
        }else{
            if(input>0){
                binary(-(input/2));
            }else{
                binary((-input+1)/2);
            }
            System.out.print(1);
        }
    }// binary
}// class
