package WTC_2021;

import java.util.*;

public class No_03 {
    static Map<Character, Integer> ingredients;

    public static void main(String[] args) {
        String[] ings = {"x 25", "y 20", "z 1000"};
        String[] menu = {"AAAA xyxy 15", "TTT yy 30", "BBBB xx 30"};
        String[] sell = {"BBBB 3", "TTT 2"};


        int result = solution(ings, menu, sell);
        System.out.println(result);
    }

    private static int solution(final String[] ings, final String[] menu, final String[] sell) {
        int profit = 0;

        ingredients = ingredientsPrice(ings);
        final Map<String, Menu> menus = menuIngredientsAndPrice(menu);
        final Map<String, Integer> sellPerformances = sellPerformance(sell);

        for (String key : sellPerformances.keySet()) {
            int sellCount = sellPerformances.get(key);
            profit += menus.get(key).calculateProfit() * sellCount;
        }

        return profit;
    }

    private static Map<String, Integer> sellPerformance(final String[] sell) {
        final Map<String, Integer> sellPerformances = new HashMap<>();

        for (final String s : sell) {
            final StringTokenizer stringTokenizer = new StringTokenizer(s);
            sellPerformances.put(stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken()));
        }

        return sellPerformances;
    }

    private static Map<String, Menu> menuIngredientsAndPrice(final String[] menu) {
        final Map<String, Menu> menus = new HashMap<>();

        for (final String s : menu) {
            final StringTokenizer stringTokenizer = new StringTokenizer(s);
            String menuName = stringTokenizer.nextToken();
            menus.put(menuName, new Menu(menuName, ingredientsList(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }

        return menus;
    }

    private static List<Ingredient> ingredientsList(final String oneMenuIngredient) {
        char[] oneMenuIngredientChars = oneMenuIngredient.toCharArray();
        final List<Ingredient> list = new ArrayList<>();

        for (final char oneMenuIngredientChar : oneMenuIngredientChars) {
            list.add(new Ingredient(oneMenuIngredientChar, ingredients.get(oneMenuIngredientChar)));
        }

        return list;
    }

    private static Map<Character, Integer> ingredientsPrice(final String[] ings) {
        final Map<Character, Integer> ingredients = new HashMap<>();

        for (final String ing : ings) {
            final StringTokenizer stringTokenizer = new StringTokenizer(ing);
            ingredients.put(stringTokenizer.nextToken().charAt(0), Integer.parseInt(stringTokenizer.nextToken()));
        }

        return ingredients;
    }

    private static class Menu {
        private String menuName;
        private List<Ingredient> ingredients;
        private int sellPrice;

        public Menu(final String menuName, final List<Ingredient> ingredients, final int sellPrice) {
            this.menuName = menuName;
            this.ingredients = ingredients;
            this.sellPrice = sellPrice;
        }

        public int calculateProfit() {
            return sellPrice - ingredients.stream().mapToInt(a -> a.price).sum();
        }
    }

    private static class Ingredient {
        private char name;
        private int price;

        public Ingredient(final char name, final int price) {
            this.name = name;
            this.price = price;
        }
    }
}
