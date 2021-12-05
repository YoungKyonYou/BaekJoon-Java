package Devovs;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) throws Exception {
        String s = "abcc";
        String s2 = "toothwe";
        System.out.println(solution(s2));
    }

    public static int solution(String s) {
        String[] keyboard = { "qwertyuio", "pasdfghjk", "lzxcvbnm0" };
        int kn = 9;
        int mod = 1000000007;
        char[][] keys = new char[kn][kn];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < kn; j++) {
                keys[i][j] = keyboard[i].charAt(j);
                map.put(keyboard[i].charAt(j), i + j);
            }
        }
        HashMap<String, Integer> comb = new HashMap<>();

        int len = s.length();
        int[] arr = new int[250001];

        for (int i = 1; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length() - i; j++) {
                sb.append(s.charAt(j));
                arr[j] = map.get(s.charAt(j));
            }
            for (int j = 0; j < s.length() - i; j++) {
                int sum = arr[j] + arr[j + 1];
            }
           // StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            int temp1 = map.get(s.charAt(i));
            sb.append(s.charAt(i + 1));
            int temp2 = map.get(s.charAt(i + 1));
            comb.put(sb.toString(), Math.abs(temp1 - temp2));
        }
        int sum1 = 0;
        int sum2 = 0;
        for (String g : comb.keySet()) {
            sum1 += comb.get(g);
        }

        for (int i = 0; i < s.length() - 2; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            int temp1 = map.get(s.charAt(i));
            sb.append(s.charAt(i + 1));
            int temp2 = map.get(s.charAt(i + 1));
            sb.append(s.charAt(i + 2));
            int temp3 = map.get(s.charAt(i + 2));
            comb.put(sb.toString(), Math.abs(temp1 - temp2) + Math.abs(temp2 - temp3));
        }
        for (String g : comb.keySet()) {
            if (g.length() == 3) {
                sum2 += comb.get(g);
            }
        }
        int sum3 = 0;
        for (int i = 0; i < s.length() - 3; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            int temp1 = map.get(s.charAt(i));
            sb.append(s.charAt(i + 1));
            int temp2 = map.get(s.charAt(i + 1));
            sb.append(s.charAt(i + 2));
            int temp3 = map.get(s.charAt(i + 2));
            sb.append(s.charAt(i + 3));
            int temp4 = map.get(s.charAt(i + 3));
            comb.put(sb.toString(), Math.abs(temp1 - temp2) + Math.abs(temp2 - temp3) + Math.abs(temp3 - temp4));
        }
        for (String g : comb.keySet()) {
            if (g.length() == 4) {
                sum3 += comb.get(g);
            }
        }
        for (int i = 0; i < s.length() - 4; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            int temp1 = map.get(s.charAt(i));
            sb.append(s.charAt(i + 1));
            int temp2 = map.get(s.charAt(i + 1));
            sb.append(s.charAt(i + 2));
            int temp3 = map.get(s.charAt(i + 2));
            sb.append(s.charAt(i + 3));
            int temp4 = map.get(s.charAt(i + 3));
            sb.append(s.charAt(i + 4));
            int temp5 = map.get(s.charAt(i + 4));

            comb.put(sb.toString(), Math.abs(temp1 - temp2) + Math.abs(temp2 - temp3) + Math.abs(temp3 - temp4)
                    + Math.abs(temp4 - temp5));
        }
        int sum4 = 0;
        for (String g : comb.keySet()) {
            if (g.length() == 5) {
                sum4 += comb.get(g);
            }
        }

        int ans = 0;
        for (int i = 2; i < len - 1; i++) {

            ans += (sum2 % mod);

        }
        ans += (sum1 * 2 % mod);

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