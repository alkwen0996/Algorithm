package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1373 {
    // 어떤 문자던 -'0'을 하면 원래 문자의 char 값이 생성된다.
    // 정수문자의 경우도 -'0'하면 해당 정수값 가능.
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int result = 0;
        int length = num.length();

        if(length%3 == 1)
            System.out.print(num.charAt(0));

        if(length%3==2)
            System.out.print( (num.charAt(0)-'0')*2+(num.charAt(1)-'0')*1 );

        for (int i=length%3;i<length;i+=3) {
            System.out.print((num.charAt(i) - '0') * 4 + (num.charAt(i + 1) - '0') * 2 + (num.charAt(i + 2) - '0') * 1);
        }

        br.close();

    }// main
}//class
