package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_10814 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        final List<member> members = new ArrayList<>();

        int order = 0;
        while (N-- > 0) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            members.add(new member(Integer.parseInt(stringTokenizer.nextToken()), stringTokenizer.nextToken(), order++));
        }

        String result = solve(members);
        System.out.println(result);
    }

    private static String solve(final List<member> members) {
        final StringBuilder stringBuilder = new StringBuilder();

        members.sort((member1, member2) -> {
            if (member1.age > member2.age) {
                return 1;
            } else if (member1.age < member2.age) {
                return -1;
            } else {
                if (member1.order < member2.order) {
                    return -1;
                } else if (member1.order > member2.order) {
                    return 1;
                }
            }
            return 0;
        });

        for (member member : members) {
            stringBuilder.append(member.age).append(" ").append(member.name).append("\n");
        }

        return stringBuilder.toString();
    }

    private static class member {
        private int age;
        private String name;
        private int order;

        public member(final int age, final String name, final int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }
    }
}
