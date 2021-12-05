package WoAhHan;

import java.util.*;

public class Problem4 {

    public static void main(String[] args) throws Exception {
        int N = 0;
        int M = 0;
        int[] arr = {};
        String[] str = {};
        String s = "wowwow";
        List<Integer> ans = solution(s);
        for (int a : ans) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println();

    }

    public static List<Integer> solution(String s) {
        List<Integer> ans = new ArrayList<>();
        char c = s.charAt(0);
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                cnt++;
            } else {
                ans.add(cnt);
                c = s.charAt(i);
                cnt = 1;
            }
        }
        ans.add(cnt);
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            ans.set(0, ans.get(0) + ans.get(ans.size() - 1));
            ans.remove(ans.size() - 1);
        }
        Collections.sort(ans);
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