package Implementation;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;

public class No_1152 {
    public static void main(String args[]) throws IOException {

        int cnt = 0;
        int pre_str = 32;
        int str;

        while(true){
            str = System.in.read();
            if(str == 32){
                if(pre_str!=32){
                    cnt++;
                }
            }
            else if(str == 10){
                if(pre_str != 32){
                    cnt++;
                    break;
                }
            }
            pre_str = str;
        }

        System.out.println(cnt);


        /* 풀이2
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        StringTokenizer st = new StringTokenizer(str," ");
        System.out.println(st.countTokens());
        */

        /* 풀이 1
        int cnt = 0;
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                cnt+=1;
            }
        }

        String [] strArr = new String[3];
        strArr = str.split(" ");

        cnt =0;
        for(int i=0;i< strArr.length;i++){
            if(strArr[i].length()>0){
                cnt+=1;
            }
        }
        System.out.println(cnt);
        */


    }// main
}// class
