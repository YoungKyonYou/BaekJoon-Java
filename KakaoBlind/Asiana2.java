package KakaoBlind;
import java.util.*;
public class Asiana2{
    public static void main(String[] args) throws Exception {
        int[] arr = { 1, 2, 6, 3, 7, 2, 6, 6, 3, 7, 6, 2, 2, 9, 1, 2 };
        solution(arr);
    }

    public static void solution(int[] arr) {
        Integer a = 3;
        System.out.println(System.identityHashCode(a));
        a += 2;
        System.out.println("value:" + a + " hash:" + System.identityHashCode(a));
        Integer b = 3;
        System.out.println(System.identityHashCode(b));
        b += 3;
        System.out.println("value:"+b+" hash:"+System.identityHashCode(b));
    }
}