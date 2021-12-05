package WoAhHan;

import java.util.*;

public class Problem1 {

    public static void main(String[] args) throws Exception {
        int N = 0;
        int M = 0;
        int[] arr = { 3, 3, 3, 3, 3, 3 };
        String[] str = {};
        int[] count = new int[3];
        count = solution(N, M, arr);
        for (int a : count) {
            System.out.print(a + " ");
        }

        System.out.println();

    }

    public static int[] solution(int N, int M, int[] arr) {
        int[] count = new int[4];
        int max = -1;
        int[] ans = new int[3];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < 4; i++) {
            max = Math.max(max, count[i]);
        }
        for (int i = 0; i < 3; i++) {
            ans[i] = max - count[i + 1];
        }
        return ans;
    }

    public static void printArrTwo(int[][] arr) {
        for (int[] a : arr) {
            System.out.print(Arrays.toString(a) + " ");
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