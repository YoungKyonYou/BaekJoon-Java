package Hanoi;
import java.util.*;
public class  Hanoi{
    public static void main(String[] args) throws Exception {
        int n = 4;
        HanoiTower(n, 'A', 'B', 'C');
    }

    public static void HanoiTower(int n, char from, char by, char to) {
        if (n == 1) {
            System.out.printf("원반 1을 %c에서 %c로 이동\n", from, to);
        } else {
            HanoiTower(n-1, from, to, by);
            System.out.printf("원반 %d을(를) %c에서 %c로 이동 \n", n, from, to);
            HanoiTower(n - 1, by, from, to);
        }
    }
}