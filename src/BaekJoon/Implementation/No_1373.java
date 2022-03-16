package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1373 {
    // 어떤 문자던 -'0'을 하면 원래 문자의 char 값이 생성된다.
    // 정수문자의 경우도 -'0'하면 해당 정수값 가능.
    public static void main(String args[]) throws IOException {

        int [] powNums = {1,2,4};
        char [] results;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        //3 자리를 맞추는 방법
        //따로 예외처리하는 방법

        //풀이 2
        int charsLen = chars.length;
        int resLen = 0;

        if(charsLen % 3 ==0){
            resLen = (charsLen / 3)-1;
        }else{
            resLen = charsLen /3 ;
        }

        results = new char[resLen+1];

        int num=0,index=0 ;

        while(--charsLen>=0){
            num += (chars[charsLen]-'0') * powNums[index];
            if(index ==2){
                results[resLen] = (char)(num +'0');
                resLen--;
                index=0;
                num =0;
            }else{
                index++;
            }// if~else
        }// while

        if(resLen==0)
            results[resLen] = (char)(num+'0');

        System.out.println(new String(results));

        /* 풀이 1.
        int result = 0;
        int length = num.length();

        if(length%3 == 1)
            System.out.print(num.charAt(0));

        if(length%3==2)
            System.out.print( (num.charAt(0)-'0')*2+(num.charAt(1)-'0')*1 );

        for (int i=length%3;i<length;i+=3) {
            System.out.print((num.charAt(i) - '0') * 4 + (num.charAt(i + 1) - '0') * 2 + (num.charAt(i + 2) - '0') * 1);
        }
        */

        br.close();

    }// main
}//class
