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
            sum+=(int)(c-'A')/3+3;
            if(c == 'Y' || c == 'V' || c == 'S' || c == 'Z'){
                sum--;
            }
        }
        System.out.println(sum);
    }
}
