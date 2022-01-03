package Line_Fintech;
import java.util.*;
public class  Problem5{
    public static void main(String[] args) throws Exception {
        String[] str = { "AABAAA", "BABABB", "BABBAAAB", "BABAAABAABBABBA" };
        solution(str);
    }

    public static int solution(String[] strs) {
        int answer = 0;
        for (int i = 0; i < strs.length; i++) {
            boolean flag1 = strs[i].matches("[AAB+]+,[BAA+A]+");
            System.out.println(flag1);
            if (flag1) {
                answer++;
            }
        }

        return answer;
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