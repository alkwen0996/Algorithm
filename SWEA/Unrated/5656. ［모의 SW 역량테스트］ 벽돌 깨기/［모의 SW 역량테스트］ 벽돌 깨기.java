

import java.awt.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    /*
     * 1. 공을 쏠 위치를 중복순열을 이용해서 골라준다.(selectShotLine)
     * 2. 골라준 위치에 공을 쏜다. (destroy)
     * 2-1. 큐를 이용해 상하좌우 다 깨뜨려준다.
     * 2-3. 만약 깨뜨리는 중에 다른 블럭을 만나면 그 블럭도 큐에 넣고 같이 돌려준다.
     * 3. 다 비었다면 column 배열을 이용해서 블럭을 정리한다.(빈 공간을 채우면서 아래로 모아준다.)
     * 4. N번 만큼 1-3을 반복해 남은 벽돌을 세어준다.
     * 5. 지도를 초기화 한 후 1번부터 반복하며 가장 적게 남은 벽돌의 수를 remainBrick에 저장해 출력한다.
     * */

    private static final String SHARP = "#";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    private static int remainMinimumBlock;
    private static int[][] map;
    private static int[][] originalMap;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOfTestCase = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        for (int i = 1; i <= numberOfTestCase; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int numberOfShot = Integer.parseInt(stringTokenizer.nextToken());
            final int width = Integer.parseInt(stringTokenizer.nextToken());
            final int height = Integer.parseInt(stringTokenizer.nextToken());

            map = new int[height][width];
            originalMap = new int[height][width];

            for (int j = 0; j < height; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                for (int k = 0; k < width; k++) {
                    map[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    originalMap[j][k] = map[j][k];
                }
            }

            remainMinimumBlock = Integer.MAX_VALUE;
            final ShotMachine shotMachine = new ShotMachine(new int[numberOfShot]);
            selectShotLines(0, shotMachine);

            stringBuilder.append(SHARP).append(i).append(SPACE).append(remainMinimumBlock).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    public static void selectShotLines(final int index, final ShotMachine shotMachine) {
        if (index == shotMachine.shotLines.length) {
            /*System.out.println("---------------한턴시작-------------");
            System.out.println("사격 좌표: " + Arrays.toString(shotMachine.shotLines));
            for (int k = 0; k < map.length; k++) {
                System.out.println(Arrays.toString(map[k]));
            }*/

            shotMachine.shotBall();

            /*System.out.println();
            for (int k = 0; k < map.length; k++) {
                System.out.println(Arrays.toString(map[k]));
            }
            System.out.println("---------------한턴종료-------------");

            System.out.println("블록 개수: " + remainMinimumBlock);*/
            remainMinimumBlock = Math.min(countRemainBlock(), remainMinimumBlock);
            revertMap();

            return;
        }

        if (remainMinimumBlock == 0) {
            return;
        }

        for (int i = 0; i < map[0].length; i++) {
            shotMachine.shotLines[index] = i;
            selectShotLines(index + 1, shotMachine);
        }

    }

    private static int countRemainBlock() {
        int remainBlock = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                remainBlock++;
            }
        }

//        System.out.println("남은블록: " + remainBlock);

        return remainBlock;
    }

    private static void fillBlank() {
        for (int i = 0; i < map[0].length; i++) {
            int[] tempArray = new int[map.length];

            for (int j = 0; j < map.length; j++) {
                tempArray[j] = map[j][i];
            }

            tempArray = Arrays.stream(tempArray).filter(index -> index != 0).toArray();

            int tempArrayIndex = tempArray.length - 1;

            for (int j = map.length - 1; j >= 0; j--) {
                if (tempArrayIndex >= 0) {
                    map[j][i] = tempArray[tempArrayIndex--];
                    continue;
                }

                map[j][i] = 0;
            }

        }

    }

    private static void revertMap() {
        for (int i = 0; i < originalMap.length; i++) {
            System.arraycopy(originalMap[i], 0, map[i], 0, map[i].length);
        }
    }

    static class ShotMachine {
        private final int[] shotLines;

        public ShotMachine(final int[] selectLines) {
            this.shotLines = selectLines;
        }

        private void shotBall() {
            for (final int shotLineNumber : shotLines) {
                for (int j = 0; j < map.length; j++) {
                    final int data = map[j][shotLineNumber];

                    if (data != 0) {
                        breakBlocks(new Block(new Point(j, shotLineNumber), data));
                        break;
                    }
                }

                fillBlank();
            }

        }

        public void breakBlocks(final Block block) {
            final Queue<Block> queue = new LinkedList<>();
            queue.offer(block);

            while (!queue.isEmpty()) {
                for (int i = 0, size = queue.size(); i < size; i++) {
                    final Block breakBlock = queue.poll();

                    final int shotBlockX = breakBlock.point.x;
                    final int shotBlockY = breakBlock.point.y;
                    final int power = breakBlock.power;

                    map[shotBlockX][shotBlockY] = 0;
                    // 오른쪽
                    for (int j = shotBlockY; j < map[0].length; j++) {
                        if (map[shotBlockX][j] > 0 && j <= shotBlockY + power - 1) {
                            queue.offer(new Block(new Point(shotBlockX, j), map[shotBlockX][j]));
                        }
                    }

                    // 아래쪽
                    for (int j = shotBlockX; j < map.length; j++) {
                        if (map[j][shotBlockY] > 0 && j <= shotBlockX + power - 1) {
                            queue.offer(new Block(new Point(j, shotBlockY), map[j][shotBlockY]));
                        }
                    }

                    // 왼쪽
                    for (int j = shotBlockY; j >= 0; j--) {
                        if (map[shotBlockX][j] > 0 && j >= shotBlockY - power + 1) {
                            queue.offer(new Block(new Point(shotBlockX, j), map[shotBlockX][j]));
                        }
                    }

                    // 위쪽
                    for (int j = shotBlockX; j >= 0; j--) {
                        if (map[j][shotBlockY] > 0 && j >= shotBlockX - power + 1) {
                            queue.offer(new Block(new Point(j, shotBlockY), map[j][shotBlockY]));
                        }
                    }
                }
            }

        }

    }

    static class Block {
        private final Point point;
        private final int power;

        public Block(final Point point, final int power) {
            this.point = point;
            this.power = power;
        }

    }

}
