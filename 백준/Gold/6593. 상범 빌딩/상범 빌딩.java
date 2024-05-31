import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int l = Integer.parseInt(stringTokenizer.nextToken());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            char[][][] building = new char[l][r][c];
            Queue<Location> queue = new LinkedList<>();
            Location exit = null;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String line = bufferedReader.readLine();

                    for (int k = 0; k < c; k++) {
                        building[i][j][k] = line.charAt(k);

                        if (building[i][j][k] == 'S') {
                            queue.add(new Location(i, j, k));
                        }

                        if (building[i][j][k] == 'E') {
                            exit = new Location(i, j, k);
                        }
                    }
                }

                bufferedReader.readLine();
            }

            stringBuilder.append(bfs(building, queue, exit)).append("\n");
        }

        System.out.println(stringBuilder);
    } // main

    private static String bfs(final char[][][] building, final Queue<Location> queue, final Location exit) {
        boolean[][][] isVisited = new boolean[building.length][building[0].length][building[0][0].length];
        Location sangBum = queue.peek();
        isVisited[sangBum.z][sangBum.y][sangBum.x] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[] dz = {1, -1};

        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Location current = queue.poll();

                if (current.x == exit.x && current.y == exit.y && current.z == exit.z) {
                    return "Escaped in " + minutes + " minute(s).";
                }

                for (int j = 0; j < dx.length; j++) {
                    int nextX = current.x + dx[j];
                    int nextY = current.y + dy[j];

                    if (nextX < 0 || nextY < 0 || nextX >= building[0][0].length || nextY >= building[0].length) {
                        continue;
                    }

                    if (isVisited[current.z][nextY][nextX] || building[current.z][nextY][nextX] == '#') {
                        continue;
                    }

                    queue.add(new Location(current.z, nextY, nextX));
                    isVisited[current.z][nextY][nextX] = true;
                }

                for (final int z : dz) {
                    int nextZ = current.z + z;

                    if (nextZ < 0 || nextZ >= building.length) {
                        continue;
                    }

                    if (isVisited[nextZ][current.y][current.x] || building[nextZ][current.y][current.x] == '#') {
                        continue;
                    }

                    queue.add(new Location(nextZ, current.y, current.x));
                    isVisited[nextZ][current.y][current.x] = true;
                }
            }

            minutes++;
        }

        return "Trapped!";
    }

    static class Location {
        int x;
        int y;
        int z;

        public Location(final int z, final int y, final int x) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
} // class
