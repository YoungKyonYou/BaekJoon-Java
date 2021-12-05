package Devovs;
import java.util.*;
public class  Problem2{
    public static void main(String[] args) throws Exception {
        int n1 = 2;
        String[] recipes1 = { "A 3", "B 2"};
        String[] orders1 = { "A 1", "A 2", "B 3", "B 4" };
        
        int n2 = 3;
        String[] recipes2 = { "SPAGHETTI 3", "FRIEDRICE 2", "PIZZA 8" };
        String[] orders2 = { "PIZZA 1", "FRIEDRICE 2", "SPAGHETTI 4", "SPAGHETTI 6", "PIZZA 7", "SPAGHETTI 8" };
        System.out.println(solution(n2, recipes2, orders2));

        
    }

    public static int solution(int n, String[] recipes, String[] orders) {
        HashMap<String, Integer> cookingTime = new HashMap<>();
        HashMap<Integer, String> orderTime = new HashMap<>();
        int finish = orders.length;
        for (int i = 0; i < recipes.length; i++) {
            String[] temp = recipes[i].split(" ");
            cookingTime.put(temp[0], Integer.parseInt(temp[1]));
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < orders.length; i++) {
            String[] temp = orders[i].split(" ");
            orderTime.put(Integer.parseInt(temp[1]), temp[0]);
            queue.add(Integer.parseInt(temp[1]));
        }
        int[] flame = new int[n];
        int time = 1;
        int temp = n;
        while (finish > 0) {
            for (int i = 0; i < n; i++) {
                if (flame[i] == time) {
                    flame[i] = 0;
                    temp++;
                }
            }
            for (int i = 0; i < n; i++) {
                if (!queue.isEmpty() && queue.peek() <= time && temp > 0 && flame[i] == 0) {
                    if (queue.size() == 1) {
                        return cookingTime.get(orderTime.get(queue.peek())) + time;
                    }
                    flame[i] = cookingTime.get(orderTime.get(queue.peek())) + time;
                    queue.poll();
                    temp--;
                    finish--;
                }
            }
            time++;
        }
        int ans = -1;

        return ans;
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