package WoAhHan;
import java.util.*;

public class Problem3 {
    /*public static class Food {
        public int cost;
        public int benefit;

        public Food(int cost, int benefint) {
            this.cost = cost;
            this.benefit = benefint;
        }
    }*/
    public static void main(String[] args) throws Exception {
        int N = 0;
        int M = 0;
        int[] arr = {};
        String[] material = { "r 10", "a 23", "t 124", "k 9"};
        String[] menu = { "PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50",
                "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"};
        String[] sell = { "BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"};
        System.out.println(solution(N, M, material, menu, sell));
    }

    public static int solution(int N, int M, String[] material, String[] menu, String[] sell) {
        int ans = 0;
        int[] materialCost = new int[30];
        HashMap<String, Integer> menuCost = new HashMap<>();
        for (int i = 0; i < material.length; i++) {
            materialCost[material[i].charAt(0) - 'a'] = Integer
                    .parseInt(material[i].substring(2, material[i].length()));
        }
        for (int i = 0; i < menu.length; i++) {
            String[] str = menu[i].split(" ");
            int foodCost = 0;
            for (int j = 0; j < str[1].length(); j++) {
                foodCost += materialCost[str[1].charAt(j) - 'a'];
            }
            menuCost.put(str[0], Integer.parseInt(str[2]) - foodCost);
        }
        for (int i = 0; i < sell.length; i++) {
            String[] str = sell[i].split(" ");
            ans += (Integer.parseInt(str[1]) * menuCost.get(str[0]));
        }
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

    public static void printMap(HashMap<String, Integer> map) {
        for (String a : map.keySet()) {
            System.out.println("key: " + a + " value:" + map.get(a));
        }
        System.out.println();
    }
}