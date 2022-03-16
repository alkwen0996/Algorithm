package BaekJoon.Function;

import java.util.ArrayList;
import java.util.List;

public class No_4673 {
    public static final int LIST_SIZE = 10001;

    public static void main(String[] args) {
        List<Boolean> numberList = new ArrayList<>(LIST_SIZE);

        numberList.add(false);
        for (int i = 1; i < LIST_SIZE; i++) {
            numberList.add(false);
        }

        for (int i = 1; i < LIST_SIZE; i++) {
            int selfNumber = findNotSelfNumber(i);
            if(selfNumber < LIST_SIZE){
                numberList.set(selfNumber, true);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < numberList.size(); i++){
            if(!numberList.get(i)){
                stringBuilder.append(i).append("\n");
            }
        }
        System.out.println(stringBuilder);

    }

    private static int findNotSelfNumber(int i) {
        int n = i;
        char[] numberCharactersArray = String.valueOf(i).toCharArray();

        for (char numberCharacter : numberCharactersArray) {
            n += Integer.parseInt(String.valueOf(numberCharacter));
        }

        return n;
    }
}
