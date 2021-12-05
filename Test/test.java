package Test;
import java.util.*;
public class  test{
    public static void main(String[] args) throws Exception {
        String[] arr = { "a", "b", "c", "d", "e" };
        solution(arr);
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
        String s = "hello ";
        solution2(s);
        System.out.println(s);
    }

    public static void solution(String[] arr) {
        arr[0] = "b";
        arr[1] = "d";

    }
    
    public static void solution2(String arr) {
        arr += "test";

    }
}