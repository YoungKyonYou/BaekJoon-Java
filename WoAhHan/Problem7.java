package WoAhHan;
import java.util.*;
public class  Problem7{
    public static void main(String[] args) throws Exception {
        int N = 0;
        int M = 0;
        int[] arr = {};
        String[] grid2 = { "A", "MAN", "DRINK", "WATER11" };
        String[] grid = { "1", "234", "56789" };
        boolean clockwise = false;

        solution(grid2, clockwise);
        System.out.println();
    }

    public static List<String> solution(String[] grid, boolean clockwise) {
        List<String> ans = new ArrayList<>();
        boolean[][] visit = new boolean[grid.length][grid[grid.length - 1].length()];
        char[][] map = new char[grid.length][grid[grid.length - 1].length()];

        int k = grid.length - 1;
        for (int i = 0; i < map.length; i++) {
            int idx = 0;
            int space = 0;
            for (int j = 0; j < map[i].length; j++) {

                if ( space >= k && idx < grid[i].length()) {
                    map[i][j] = grid[i].charAt(idx++);
                }
                space++;
            }
            k--;
        }
      //  printArrTwo(map);
      if (clockwise) {
          for (int t = 0; t < grid.length; t++) {
              String s = "";
              for (int i = map.length - 1; i >= 0; i--) {
                  int cnt = 0;
                  for (int j = map[i].length - 1; j >= 0; j--) {
                      if (!visit[i][j] && map[i][j] != '\0' && cnt < 2) {
                          s += Character.toString(map[i][j]);
                          visit[i][j] = true;
                          cnt++;
                      }
                  }
              }
              ans.add(s);
          }
      } 
      else {
          for (int t = 0; t < grid.length; t++) {
              String s = "";
              for (int i = 0; i < map.length; i++) {
                  int cnt = 0;
                  String temp = "";
                  for (int j = 0; j < map[i].length; j++) {
                      if (!visit[i][j] && map[i][j] != '\0' && cnt < 2) {
                          temp += Character.toString(map[i][j]);
                          visit[i][j] = true;
                          cnt++;
                      }
                  }
                  StringBuffer sb = new StringBuffer(temp);
                  s += sb.reverse().toString();
              }
              ans.add(s);
          }
      }
      Collections.sort(ans,(o1,o2)->{
          return o1.length()-o2.length();
      });
      printList(ans);
    
        return ans;
    }
    
    public static void printArrTwo(char[][] arr) {
        for (char[] a : arr) {
            for (char b : a) {
                System.out.print(b+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void printArrTwo(boolean[][] arr) {
        for (boolean[] a : arr) {
            for (boolean b : a) {
                if(b){
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArrOne(int[] arr) {
        System.out.println(Arrays.toString(arr) + " ");
        System.out.println();
    }

    public static void printList(List<String> list) {
        for (String a : list) {
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