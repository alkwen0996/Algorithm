package Implementation;

import java.util.Scanner;

public class No_2490 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){

        int back;
        int cnt;
        for (int j=0;j<3;j++){
            cnt=0;
            for(int i=0;i<4;i++){
                back = sc.nextInt();
                if(back==0){
                    cnt++;
                }//if
            }//for_i
            switch (cnt){
                case 0: System.out.println("E"); break;
                case 1: System.out.println("A"); break;
                case 2: System.out.println("B"); break;
                case 3: System.out.println("C"); break;
                case 4: System.out.println("D"); break;
            }
        }//for_j



    }// main
}// class
