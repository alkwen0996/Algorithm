package Implementation;

import java.util.Scanner;

public class No_2562 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){

        short [] arr = new short [9];

        short max = 0;
        short loc = 0;

        for (short i =0;i<arr.length;i++){
            arr[i] = sc.nextShort();
            if(max<arr[i]){
                max = arr[i];
                loc = (short)(i+1);
            }
        }

        sc.close();

        System.out.println(max+"\n"+loc);

    }// main
}// class
