package WoAhHan;

import java.util.*;

public class Problem2 {
    public static void main(String[] args) throws Exception {
        int N = 0;
        int M = 0;

        String[] str = { "08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11" };

        System.out.println(solution(N, M, str));
    }

    public static String solution(int N, int M, String[] str) {
        String ans = "";
        int totalMin = 0;
        for (int i = 0; i < str.length; i += 2) {
            String s1 = str[i];
            String s2 = str[i + 1];
            int h1 = Integer.parseInt(s1.substring(0, 2));
            int m1 = Integer.parseInt(s1.substring(3, 5));
            int h2 = Integer.parseInt(s2.substring(0, 2));
            int m2 = Integer.parseInt(s2.substring(3, 5));
            int hh = h2 - h1;
            int mm = m2 - m1;
            hh = (hh * 60);
            int a = hh + mm;

            if (105 <= a) {
                totalMin += 105;
            } else if (a < 5) {
                continue;
            } else {
                totalMin += a;
            }
        }
        if (Integer.toString(totalMin / 60).length() == 1) {
            ans = "0" + Integer.toString(totalMin / 60);
        } else {
            ans = Integer.toString(totalMin / 60);
        }
        ans += ":";
        ans += Integer.toString(totalMin % 60);

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