package BaekJoon.Implementation;

import java.util.Scanner;

public class No_1264 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){

        while(sc.hasNextLine()){
            int cnt = 0;
            String sentence = sc.nextLine().toLowerCase();

            if(sentence.equals("#")){
                break;
            }

            for (int i =0; i<sentence.length();i++){
                char ch = sentence.charAt(i);
                if(ch == 'i' || ch == 'e' || ch == 'o' || ch == 'a' || ch == 'u'){
                    cnt++;
                }
            }

            System.out.println(cnt);

        }// while

    }// main
}// class
