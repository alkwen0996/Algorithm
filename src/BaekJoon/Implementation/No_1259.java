package BaekJoon.Implementation;

import java.util.Scanner;

public class No_1259 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){

        while(true){

            String Palindrome = sc.next();

            if(Palindrome.equals("0"))
                break;

            Character [] arr = new Character[Palindrome.length()];

            for (int i =0;i<Palindrome.length();i++)
                arr[i] = Palindrome.charAt(i);

            String Compare = "";
            for (int i =Palindrome.length()-1;i>=0;i--)
                Compare+=arr[i];

            if(Palindrome.equals(Compare))
                System.out.println("yes");
            else
                System.out.println("no");
        }

    }// main
}// class
