package KakaoBlind;

import java.util.*;

public class LockAndKey {
    public static void main(String[] args) throws Exception {
        int[][] key = { { 0, 0, 0 }, { 0, 1, 1 }, { 1, 0, 1 } };
        int[][] lock = { { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, { 1, 0, 1, 0 }, { 1, 1, 1, 0 } };
        System.out.println(solution(key, lock));

    }

    public static void print(int[][] map) {
        for (int[] a : map) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isMatch(int[][] map, int[][] key, int[][] lock) {
        for (int i = lock.length; i < lock.length * 2; i++) {
            for (int j = lock.length; j < lock.length * 2; j++) {
                if (map[i][j]!=1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solution(int[][] key, int[][] lock) {
        int[][] map = new int[lock.length * 3][lock.length * 3];
        System.out.println(lock.length);
        print(key);
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                map[i + lock.length][j + lock.length] = lock[i][j];
            }
        }
        for (int k = 0; k < 4; k++) {
            for (int i = 1+(lock.length-key.length); i < 1 + (lock.length - key.length)+(key.length + lock.length - 1); i++) {
                for (int j = 1 + (lock.length - key.length); j < 1 + (lock.length - key.length)+(key.length + lock.length - 1); j++) {
                    for (int n = 0; n < key.length; n++) {
                        for (int m = 0; m < key.length; m++) {
                            map[i + n][j + m] += key[n][m];
                        }
                    }
                    print(map);
                    if (isMatch(map, key, lock)) {
                        return true;
                    }

                    for (int n = 0; n < key.length; n++) {
                        for (int m = 0; m < key.length; m++) {
                            map[i + n][j + m] -= key[n][m];
                        }
                    }
                }
            }
            int[][] clockwiseMap = new int[key.length][key.length];
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key.length; j++) {
                    clockwiseMap[key.length - j - 1][i] = key[i][j];
                    System.out.print("i:" + (key.length - j - 1) + " j:" + i + " ");

                }
                System.out.println();
            }

            key = clockwiseMap;
            print(key);
        }

        return false;
        // print(map);
    }
}