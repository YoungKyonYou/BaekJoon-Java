package ESTSoft;
import java.util.*;
public class  Problem1{
    public static void main(String[] args) throws Exception {
        //3
        String[] scores = { "AAFAFA", "FEECAA", "FABBCB", "CBEDEE", "CCCCCC" };

        //3
        String[] scores2 = { "BCD", "ABB", "FEE","CCC" };
        System.out.println(solution(scores));
    }

    public static int solution(String[] scores) {
        int answer = 0;
        for (int i = 0; i < scores.length; i++) {
            int score = 0;
            int max = -1;
            int min = Integer.MAX_VALUE;
            int cntF = scores[i].length() - scores[i].replace("F", "").length();
            int cntA = scores[i].length() - scores[i].replace("A", "").length();
            if (cntF >= 2) {
                continue;
            } else if (cntA >= 2) {
                answer++;
                continue;
            }
            for (int j = 0; j < scores[i].length(); j++) {
                int point = (70 - (int) scores[i].charAt(j));
                max = Math.max(max, point);
                min = Math.min(min, point);
                score += point;
            }
            score -= max;
            score -= min;
            double average = ((double) score / (scores[i].length() - 2));
            if (Double.compare(average, 3.0) >= 0) {
                answer++;
            }
        }
        return answer;
    }
    
    public static void printArrTwo(int[][] arr) {
        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
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

    public static void printListTwo(List<Integer>[] list) {
        for (List<Integer> l : list) {
            for (Integer a : l) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMap(HashMap<Character, Integer> map) {
        for (Character a : map.keySet()) {
            System.out.println("key: " + a + " value:" + map.get(a));
        }
        System.out.println();
    }
}