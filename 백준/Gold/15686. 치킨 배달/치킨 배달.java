import java.awt.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static final String NEW_LINE = "\n";
    public static final String SPACE = " ";

    public static List<Point> chickenHouses, houses;
    public static int N, K;
    public static int[][] city;
    public static int minimumChickenDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        city = new int[N][N];
        chickenHouses = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                if (city[i][j] == 1) {
                    houses.add(new Point(i, j));
                }

                if (city[i][j] == 2) {
                    chickenHouses.add(new Point(i, j));
                }
            }
        }

        minimumChickenDistance = Integer.MAX_VALUE;
        combination(0, 0, new boolean[chickenHouses.size()]);
        System.out.println(minimumChickenDistance);
    }

    private static void combination(final int count, final int start, final boolean[] isSelected) {
        if (count == K) {
            int distance = calculateChickenDistance(isSelected);

            if (minimumChickenDistance > distance) {
                minimumChickenDistance = distance;
            }

            return;
        }

        for (int i = start; i < chickenHouses.size(); i++) {
            isSelected[i] = true;
            combination(count + 1, i + 1, isSelected);
            isSelected[i] = false;
        }
    }

    private static int calculateChickenDistance(final boolean[] isSelected) {
        int cityDistance = 0;
        int minimumDistance;
        int distance;

        for (Point house : houses) {
            minimumDistance = Integer.MAX_VALUE;

            for (int j = 0; j < chickenHouses.size(); j++) {
                if (isSelected[j]) {
                    Point chickenHouse = chickenHouses.get(j);
                    distance = Math.abs(chickenHouse.x - house.x) + Math.abs(chickenHouse.y - house.y);

                    if (minimumDistance > distance) {
                        minimumDistance = distance;
                    }
                }
            }

            cityDistance += minimumDistance;
        }

        return cityDistance;
    }

}