package BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023 {

    private static int result = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int numberOfPeople = Integer.parseInt(stringTokenizer.nextToken());
        final int numberOfFriends = Integer.parseInt(stringTokenizer.nextToken());

        List<List<Integer>> relations = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            relations.add(new ArrayList<>());
        }

        for (int i = 0; i < numberOfFriends; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int friend1 = Integer.parseInt(stringTokenizer.nextToken());
            final int friend2 = Integer.parseInt(stringTokenizer.nextToken());

            relations.get(friend1).add(friend2);
            relations.get(friend2).add(friend1);
        }

        for (int i = 0; i < numberOfPeople; i++) {
            boolean[] checkRelationship = new boolean[numberOfPeople];

            checkRelationship[i] = true;
            dfs(i, 0, checkRelationship, relations);
            checkRelationship[i] = false;

            if (result == 1) {
                break;
            }
        }

        System.out.println(result);
    }

    private static void dfs(final int index, final int depth, final boolean[] checkRelationship, final List<List<Integer>> relations) {
        if (depth == 4) {
            result = 1;

            return;
        }

        for (int i = 0; i < relations.get(index).size(); i++) {
            int relation = relations.get(index).get(i);

            if (checkRelationship[relation]) {
                continue;
            }

            checkRelationship[relation] = true;
            dfs(relation, depth + 1, checkRelationship, relations);
            checkRelationship[relation] = false;
        }
    }

}
