package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_5622 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] inputDatas = bufferedReader.readLine().toCharArray();

        int sum = 0;
        for (char c : inputDatas) {
            if(c<='C'){
                sum+=3;
            }else if(c<='F'){
                sum+=4;
            }else if(c<='I'){
                sum+=5;
            }else if(c<='L'){
                sum+=6;
            }else if(c<='O'){
                sum+=7;
            }else if(c<='S'){
                sum+=8;
            }else if(c<='V'){
                sum+=9;
            }else if(c<='Z'){
                sum+=10;
            }else{
                sum+=11;
            }
        }
        System.out.println(sum);
    }
}
