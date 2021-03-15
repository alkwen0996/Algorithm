package Implementation;

import java.util.Scanner;

public class No_1094 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){

        short a = sc.nextShort();

        int length = 64;
        int cnt = 0;

        while(a>0){

          if(length>a){
              length/=2;
          }else{
              cnt++;
              a-=length;
          }
        }

        System.out.println(cnt);

    }// main
}// class
