package bjoj._01_basic.graph;

import java.util.*;

public class _02667_단지번호붙이기 {
    private static Scanner scanner = new Scanner(System.in);
    private static int [] dx = { -1, 0, +1, 0 };
    private static int [] dy = { 0, -1, 0, +1 };

    public static void main(String[] args) {
        int mapSize = getComplexMapSize();
        int[][] map = buildComplexMap(mapSize);
        //Arrays.stream(map).forEach(line -> System.out.println(Arrays.toString(line)));

        List<Integer> houseCounts = calculateComplexHouseCounts(mapSize, map);
        displayComplexHouseCounts(houseCounts);
    }

    private static int getComplexMapSize() {
        int mapSize = scanner.nextInt();
        scanner.nextLine();
        return mapSize;
    }

    private static int[][] buildComplexMap(int mapSize) {
        int[][] complexMap = new int[mapSize + 2][mapSize + 2];

        for (int y = 1; y <= mapSize; ++y) {
            String line = scanner.nextLine();

            for (int x = 1; x <= mapSize; ++x) {
                if ((line.charAt(x - 1) - '0') == 1) {
                    complexMap[y][x] = 1;
                }
            }
        }
        return complexMap;
    }

    private static List<Integer> calculateComplexHouseCounts(int mapSize, int[][] map) {
        List<Integer> houseCounts = new ArrayList<>();
        for (int y = 1; y <= mapSize; ++y) {
            for (int x = 1; x <= mapSize; ++x) {
                if (map[y][x] == 1) {
                    houseCounts.add(goBfs(map, x, y));
                }
            }
        }
        return houseCounts;
    }

    private static int goBfs(int[][] map, int x, int y) {
        Deque<Integer> xPositions = new ArrayDeque<>();
        Deque<Integer> yPositions = new ArrayDeque<>();

        if (map[y][x] == 1) {
            xPositions.addLast(x);
            yPositions.addLast(y);
            map[y][x]++;
        }

        int houseCount = 0;
        while (!xPositions.isEmpty() && !yPositions.isEmpty()) {
            int originX = xPositions.removeLast();
            int originY = yPositions.removeLast();
            houseCount++;

            for (int i = 0; i < 4; ++i) {
                int checkY = originY + dy[i];
                int checkX = originX + dx[i];
                if (map[checkY][checkX] == 1) {
                    xPositions.addFirst(checkX);
                    yPositions.addFirst(checkY);
                    map[checkY][checkX]++;
                }
            }
        }

        return houseCount;
    }

    private static void displayComplexHouseCounts(List<Integer> houseCounts) {
        Collections.sort(houseCounts);
        System.out.println(houseCounts.size());

        if (houseCounts.size() > 0) {
            for (int houseCount : houseCounts) {
                System.out.println(houseCount);
            }
        }
    }
}
