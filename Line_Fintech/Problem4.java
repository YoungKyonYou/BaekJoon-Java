package Line_Fintech;
import java.util.*;

public class Problem4 {
    static int answer = -1;
    public static void main(String[] args) throws Exception {
        int[][] needs = { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        int r = 2;
        solution(needs, r);
        System.out.println(answer);
    }

    public static void count(int[] combi, int[][] needs) {
        int cnt=0;
        for (int i = 0; i < needs.length; i++) {
            boolean flag = false;
            for (int j = 0; j < combi.length; j++) {
                if (needs[i][j] == 1 && combi[j] != 1) {
                    flag = true;
                }
            }
            if (!flag) {
                cnt++;
            }
        }
        answer=Math.max(answer, cnt);
    }

    

    public static void DFS(int[] combi, int L, int s, int r,int len,int[][] needs) {
        if (L == r) {
            count(combi, needs);
        } else {
            for (int i = s; i < len; i++) {
                combi[i] = 1;
                DFS(combi, L + 1, i + 1, r, len,needs);
                combi[i] = 0;
            }
        }
    }

    public static int solution(int[][] needs, int r) {
        int[] combi = new int[needs[0].length];
        DFS(combi,0, 0, r,combi.length,needs);
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