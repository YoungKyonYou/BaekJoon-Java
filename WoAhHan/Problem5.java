package WoAhHan;

import java.util.*;

public class Problem5 {
    public static void main(String[] args) throws Exception {
        int rows = 3;
        int columns = 4;
        int[][] arr = { { 8, 2, 13, 14 }, { 16, 10, 4, 15 }, { 17, 11, 12, 6 } };
        solution(rows, columns);
        System.out.println();
    }

    public static boolean checkZero(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0)
                    return true;
            }
        }
        return false;
    }

    public static void solution(int rows, int columns) {
        int[][] map = new int[rows][columns];
        int count = 1;
        int x = 0;
        int y = 0;
        map[x][y] = 1;
        map[0][3] = 3;
        x = 1;
        y = 3;
        // 하->동
        int[] dx = { 1, 0 };
        int[] dy = { 0, 1 };
        while (true) {

            // 홀수
            if (count % 2 == 1) {
                x += dx[1];
                y += dy[1];
                if (y == columns) {
                    y = 0;
                }
                if (map[x][y] != 0 && (((count + 1) % 2 == 1 && map[x][y] % 2 == 1)
                        || ((count + 1) % 2 == 0 && map[x][y] % 2 == 0))) {
                    break;
                }
                map[x][y] = count + 1;
                count++;
            } // 짝수
            else {
                x += dx[0];
                y += dy[0];
                if (x == rows) {
                    x = 0;
                }
                if (map[x][y] != 0 && (((count + 1) % 2 == 1 && map[x][y] % 2 == 1)
                        || ((count + 1) % 2 == 0 && map[x][y] % 2 == 0))) {
                    break;
                }
                map[x][y] = count + 1;
                count++;
            }
            printArrTwo(map);
            if (!checkZero(map)) {
                break;
            }

        }
        printArrTwo(map);

    }

    public static void printArrTwo(int[][] arr) {
        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArrOne(int[] arr) {
        System.out.println(Arrays.toString(arr) + " ");
        System.out.println();
    }

    public static void printList(List<Integer> list) {
        for (int a : list) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void printMap(HashMap<Integer, Integer> map) {
        for (Integer a : map.keySet()) {
            System.out.println("key: " + a + " value:" + map.get(a));
        }
        System.out.println();
    }
}