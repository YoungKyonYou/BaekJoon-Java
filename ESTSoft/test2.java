package ESTSoft;

import java.util.Scanner;
import java.util.Arrays;

public class test2 {
    public static void printArr(String[][] arr) {
        for (String[] strs : arr) {
            for (String str : strs) {
                System.out.printf("%5s", str);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[][] arr = new String[5][5];
        int n = arr.length;
        int m = arr[0].length;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.toString((j + 1) + (i * 5));
            }
        }
        int count = 0;
        while (count < n * m) {
            printArr(arr);
            int num = scanner.nextInt();
            int i = (num % n) == 0 ? (num / 5) - 1 : num / 5;
            int j = (num % m) - 1 >= 0 ? (num % 5) - 1 : m - 1;

            if (i < 0 || i > n || j < 0 || j > m)
                continue;
            if (num >= 0 && num < (n * m) + 1 && !arr[i][j].equals("X")) {
                arr[i][j] = "X";
                count++;
            }
        }
        printArr(arr);
        System.out.println("25개를 다 바꾸면 종료~!");

    }
}