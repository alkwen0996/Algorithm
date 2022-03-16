package BaekJoon.Implementation;

import java.util.Scanner;

public class No_11718 {
    public static void main(String[] args){

        String str = "";
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            str = sc.nextLine();
            System.out.println(str);
            if(str.isEmpty()){
                break;
            }
        }
        sc.close();

    }// main
}// class
