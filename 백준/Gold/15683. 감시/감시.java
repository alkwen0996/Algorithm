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
    private static int N, M, minimumBlindSpotCount;
    private static int[][] office;
    private static List<Camera> cameras;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        cameras = new ArrayList<>();
        office = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cameras.add(new Camera(office[i][j], new Point(i, j)));
                }
            }
        }

        minimumBlindSpotCount = Integer.MAX_VALUE;
        findMinimumBlindSpot(0, office);
        System.out.println(minimumBlindSpotCount);
    }

    private static void findMinimumBlindSpot(final int count, final int[][] office) {
        if (count == cameras.size()) {
            int blindSpotCount = 0;

            for (final int[] line : office) {
                for (int j = 0; j < office[0].length; j++) {
                    if (line[j] == 0) {
                        blindSpotCount++;
                    }
                }
            }

            if (blindSpotCount < minimumBlindSpotCount) {
                minimumBlindSpotCount = blindSpotCount;
            }

            return;
        }

        Camera camera = cameras.get(count);

        for (int i = 0; i < 4; i++) {
            int[][] copyOffice = new int[N][M];

            for (int j = 0; j < copyOffice.length; j++) {
                copyOffice[j] = office[j].clone();
            }

            camera.checkMonitorArea(copyOffice, i);
            findMinimumBlindSpot(count + 1, copyOffice);
        }

    }

    static class Camera {
        private int type;
        private Point point;

        public Camera(final int type, final Point point) {
            this.type = type;
            this.point = point;
        }

        public void checkMonitorArea(final int[][] copyOffice, final int direction) {
            if (this.type == 1) {
                if (direction == 0) {
                    monitorRightDirection(copyOffice);
                } else if (direction == 1) {
                    monitorDownDirection(copyOffice);
                } else if (direction == 2) {
                    monitorLeftDirection(copyOffice);
                } else {
                    monitorUpperDirection(copyOffice);
                }
            } else if (this.type == 2) {
                if (direction == 0 || direction == 2) {
                    monitorRightDirection(copyOffice);
                    monitorLeftDirection(copyOffice);
                } else {
                    monitorDownDirection(copyOffice);
                    monitorUpperDirection(copyOffice);
                }
            } else if (this.type == 3) {
                if (direction == 1) {
                    monitorUpperDirection(copyOffice);
                    monitorRightDirection(copyOffice);
                } else if (direction == 2) {
                    monitorRightDirection(copyOffice);
                    monitorDownDirection(copyOffice);
                } else if (direction == 3) {
                    monitorDownDirection(copyOffice);
                    monitorLeftDirection(copyOffice);
                } else {
                    monitorLeftDirection(copyOffice);
                    monitorUpperDirection(copyOffice);
                }
            } else if (this.type == 4) {
                if (direction == 1) {
                    monitorLeftDirection(copyOffice);
                    monitorUpperDirection(copyOffice);
                    monitorRightDirection(copyOffice);
                } else if (direction == 2) {
                    monitorUpperDirection(copyOffice);
                    monitorRightDirection(copyOffice);
                    monitorDownDirection(copyOffice);
                } else if (direction == 3) {
                    monitorRightDirection(copyOffice);
                    monitorDownDirection(copyOffice);
                    monitorLeftDirection(copyOffice);
                } else {
                    monitorDownDirection(copyOffice);
                    monitorLeftDirection(copyOffice);
                    monitorUpperDirection(copyOffice);
                }
            } else {
                monitorRightDirection(copyOffice);
                monitorLeftDirection(copyOffice);
                monitorDownDirection(copyOffice);
                monitorUpperDirection(copyOffice);
            }

        }

        private void monitorRightDirection(final int[][] copyOffice) {
            int x = this.point.x;
            int y = this.point.y;

            for (int i = y; i < M; i++) {
                if (copyOffice[x][i] == 6) {
                    break;
                }

                if (copyOffice[x][i] != 0) {
                    continue;
                }

                copyOffice[x][i] = -1;
            }
        }

        private void monitorLeftDirection(final int[][] copyOffice) {
            int x = this.point.x;
            int y = this.point.y;

            for (int i = y; i >= 0; i--) {
                if (copyOffice[x][i] == 6) {
                    break;
                }

                if (copyOffice[x][i] != 0) {
                    continue;
                }

                copyOffice[x][i] = -1;
            }

        }

        private void monitorUpperDirection(final int[][] copyOffice) {
            int x = this.point.x;
            int y = this.point.y;

            for (int i = x; i >= 0; i--) {
                if (copyOffice[i][y] == 6) {
                    break;
                }

                if (copyOffice[i][y] != 0) {
                    continue;
                }

                copyOffice[i][y] = -1;
            }
        }

        private void monitorDownDirection(final int[][] copyOffice) {
            int x = this.point.x;
            int y = this.point.y;

            for (int i = x; i < copyOffice.length; i++) {
                if (copyOffice[i][y] == 6) {
                    break;
                }

                if (copyOffice[i][y] != 0) {
                    continue;
                }

                copyOffice[i][y] = -1;
            }
        }

        @Override
        public String toString() {
            return "Camera{" +
                    "type=" + type +
                    ", point=" + point +
                    '}';
        }

    }

}