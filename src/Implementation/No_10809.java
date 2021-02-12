package Implementation;

import java.util.Scanner;

public class No_10809 {
    public static void main(String []args){

        String word = getWord();
        checkAlphabet(word);


    }

    private static void checkAlphabet(String word) {
        Character [] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        for (int i =0; i<alpha.length;i++){
            System.out.print(word.indexOf(alpha[i])+" ");
        }
    }

    private static String getWord() {

        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        return word;
    }
}
