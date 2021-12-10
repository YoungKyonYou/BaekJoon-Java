package Line_Fintech;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) throws Exception {
        String[] pixels = { "111111111111111111111111110111111111", "001101001101101100101101010101001100",
                "111101111101101111101111010111111111", "100101100101101101101001010101001001",
                "111111111111111111111111111111111111" };
        System.out.println(solution(pixels));
    }

    public static class digits {
        public String str;

        public digits(String str) {
            this.str = str;
        }
    }

    public static String solution(String[] pixels) {
        String answer = "";
        String zero = "111101101101111";
        String one = "110010010010111";
        String two = "111001111100111";
        String three = "111001111001111";
        String four = "101101111001001";
        String five = "111100111001111";
        String six = "111100111101111";
        String seven = "111101001001001";
        String eight = "111101111101111";
        String nine = "111101111001111";

        List<digits> list = new ArrayList<>();
        list.add(new digits(zero));
        list.add(new digits(one));
        list.add(new digits(two));
        list.add(new digits(three));
        list.add(new digits(four));
        list.add(new digits(five));
        list.add(new digits(six));
        list.add(new digits(seven));
        list.add(new digits(eight));
        list.add(new digits(nine));
        for (int i = 0; i < pixels[0].length(); i += 3) {
            String s = "";
            for (int j = 0; j < 5; j++) {
                s += pixels[j].substring(i, i + 3);
            }
            System.out.println("s: " + s);
            for (int r = 0; r < list.size(); r++) {
                String temp = list.get(r).str;
                if (temp.equals(s)) {
                    answer += r;
                    break;
                }
            }
          //  System.out.println("r: " + r + " str: " + s);
          //  System.out.println("r: " + r + " tep: " + temp);
            // System.out.println();

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