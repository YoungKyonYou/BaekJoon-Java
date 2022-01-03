package Streami;
import java.util.*;
public class  Problem2{
    public static void main(String[] args) throws Exception {
        String s = "1111010101111";
        solution(s);
    }

    public static int solution(String S) {
        int cnt1 = 1;
        int cnt0 = 1;
        int cnt = 1;
        int[] dp = new int[1000001];
        int index = 0;
        boolean flag = false;
        int temp = 1;
        for (int i = S.length() - 1; i >= 0; i--) {

            if (S.charAt(i) == '1') {
                if (!flag) {
                    dp[S.length()-i] = cnt;
                    temp = cnt;
                    cnt++;
                } else {
                    dp[S.length()-i] = cnt + dp[index];
                    cnt = cnt + dp[index];
                    flag = false;
                    temp = cnt;
                    cnt++;
                }
            } else {
                dp[S.length()-i] = temp;
                cnt++;
                flag = true;
                index = S.length()-i - 1;
            }
        }
        return 1;
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