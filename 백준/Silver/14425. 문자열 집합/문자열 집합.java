import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(bufferedReader.readLine(), 0);
        }

        for (int i = 0; i < m; i++) {
            String input = bufferedReader.readLine();

            if(map.containsKey(input)) {
                map.replace(input, map.get(input) + 1);
            }
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        int count = 0;

        for (Map.Entry<String, Integer> entry : entries) {
            count += entry.getValue();
        }

        System.out.println(count);
    }
} // class
