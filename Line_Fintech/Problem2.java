package Line_Fintech;
import java.util.*;

public class Problem2 {

    public static void main(String[] args) throws Exception {
        int[] x = { 1, 2, 4, 2 };
        int[] y = { 1, 1, 4, 2 };
        System.out.println(solution(x, y));
    }

    public static int solution(int[] x, int[] y) {
        int answer = -1;
        Integer[][] coord = new Integer[x.length][2];
        for (int i = 0; i < x.length; i++) {
            coord[i][0] = x[i];
            coord[i][1] = y[i];
        }
        Arrays.sort(coord,(o1,o2)->{
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        });
        for (int i = 0; i < x.length - 1; i++) {

            int len = (int)Math.ceil(Math.sqrt(Math.pow(Math.abs(coord[i][0] - coord[i + 1][0]), 2) + Math.pow(Math.abs(
                    coord[i][1] - coord[i + 1][1]), 2)));
            answer = Math.max(len, answer);
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