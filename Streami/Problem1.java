package Streami;
import java.util.*;
public class  Problem1{
    public static void main(String[] args) throws Exception {
        String S = "azABaabza";
        System.out.println(solution(S));
    }

    public static int solution(String S) {
        Set<Character> set = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int cnt = 1;
            boolean[] sequence = new boolean[S.length()];
            sequence[i] = true;
            for (int j = i + 1; j < S.length(); j++) {
                if (Character.isLowerCase(S.charAt(i))) {
                    if (Character.toUpperCase(ch) == S.charAt(j)) {
                        cnt++;
                        sequence[j] = true;
                        break;
                    }
                } else {
                    if (Character.toLowerCase(ch) == S.charAt(j)) {
                        cnt++;
                        break;
                    }
                }
            }
        }

        return answer > 0 ? answer : -1;
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