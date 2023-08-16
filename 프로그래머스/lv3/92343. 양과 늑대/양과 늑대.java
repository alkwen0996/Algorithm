import java.util.LinkedList;
import java.util.List;

class Solution {
    
    public int maximumSheep;
    
    public int solution(int[] info, int[][] edges) {
        List<List<Integer>> tree = makeTree(edges);
        maximumSheep = 0;
        
        List<Integer> nextVertexes = new LinkedList<>();
        nextVertexes.add(0);
        
        dfs(tree, nextVertexes, info, 0, 0, 0);

        return maximumSheep;
    }

    public void dfs(final List<List<Integer>> tree, final List<Integer> nextVertexes, final int[] info, final int current, int sheep, int wolf) {
        if (info[current] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        if (sheep <= wolf) {
            return;
        }

        if (maximumSheep < sheep) {
            maximumSheep = sheep;
        }

        List<Integer> newNextVertexes = new LinkedList<>(nextVertexes);
        newNextVertexes.remove(Integer.valueOf(current));

        if (tree.get(current) != null) {
            newNextVertexes.addAll(tree.get(current));
        }

        for (Integer nextVertex : newNextVertexes) {
            dfs(tree, newNextVertexes, info, nextVertex, sheep, wolf);
        }

    }

    public List<List<Integer>> makeTree(final int[][] edges) {
        List<List<Integer>> tree = new LinkedList<>();

        for (int i = 0; i <= edges.length; i++) {
            tree.add(new LinkedList<>());
        }

        for (final int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];

            tree.get(vertex1).add(vertex2);
        }

        return tree;
    }
    
}