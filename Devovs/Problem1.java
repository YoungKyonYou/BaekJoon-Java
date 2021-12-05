package Devovs;
import java.util.*;

public class Problem1 {

    public static void main(String[] args) throws Exception {
        int n = 0;
        String[] drum = { "######", ">#*###", "####*#", "#<#>>#", ">#*#*<", "######" };
        System.out.println(solution(drum));
    }

    public static int solution(String[] drum) {
        int n = drum.length;
        int ans = 0;
        char[][] charMap = new char[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                charMap[i][j] = drum[i].charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            charMap[n][i] = '0';
        }
        for (int i = 0; i < n; i++) {
            boolean[][] visit = new boolean[n][n];
            int x = 0;
            int y = i;
            int cnt = 0;
            while (charMap[x][y] != '0') {
                if (charMap[x][y] == '#') {
                    x += 1;
                } else if (charMap[x][y] == '>') {
                    y += 1;
                } else if (charMap[x][y] == '<') {
                    y -= 1;
                } else if (charMap[x][y] == '*') {
                    cnt++;
                    x += 1;
                    if (cnt == 2) {
                        break;
                    }
                }
                if (charMap[x][y] == '0') {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
      public static void printArrTwo(int[][] arr) {
        for (int[] a : arr) {
            System.out.print(Arrays.toString(a));
        }
        System.out.println();
    }

    public static void printArrOne(int[] arr) {
        System.out.println(Arrays.toString(arr));
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