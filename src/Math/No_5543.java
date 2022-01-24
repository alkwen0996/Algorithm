package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_5543 {
    public static final int BURGERS_COUNT = 3;
    public static final int BEVERAGES_COUNT = 2;
    public static final int DISCOUNT = 50;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<Integer> burgersPrice = new ArrayList<>();
        final List<Integer> beveragesPrice = new ArrayList<>();
        int burgersCount = BURGERS_COUNT;
        int beveragesCount = BEVERAGES_COUNT;

        while (burgersCount-- > 0) {
            burgersPrice.add(Integer.parseInt(bufferedReader.readLine()));
        }

        while (beveragesCount-- > 0) {
            beveragesPrice.add(Integer.parseInt(bufferedReader.readLine()));
        }

        int result = solve(burgersPrice, beveragesPrice);
        System.out.println(result);
    }

    private static int solve(final List<Integer> burgersPrice, final List<Integer> beveragesPrice) {
        int cheapestBurger = burgersPrice.stream()
                .mapToInt(a -> a)
                .min()
                .getAsInt();

        int cheapestBeverage = beveragesPrice.stream()
                .mapToInt(a -> a)
                .min()
                .getAsInt();

        int cheapestMenu = cheapestBurger + cheapestBeverage - DISCOUNT;

        return cheapestMenu;
    }
}
