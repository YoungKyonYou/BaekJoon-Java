package Graph;
import java.util.*;
public class  Rank2{
    public static void main(String[] args) throws Exception {
        int n = 5;
        int[][] result = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
        System.out.println(solution(n, result));
    }

    public static void print(int[][] flyod) {
        for (int i = 1; i < flyod.length; i++) {
            for (int j = 1; j < flyod[i].length; j++) {
                System.out.print(flyod[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
    public static int solution(int n, int[][] results) {
        int INF = n * n + 1;
        int ans = 0;
        int[][] flyod = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    flyod[i][j] = 0;
                } else {
                    flyod[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < results.length; i++) {
            flyod[results[i][0]][results[i][1]] = 1;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (flyod[i][j] > flyod[i][k] + flyod[k][j]) {
                        flyod[i][j] = flyod[i][k] + flyod[k][j];
                    }
                }
            }
        }
        print(flyod);
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 1; j <= n; j++) {
                if (flyod[i][j] == INF && flyod[j][i] == INF && i != j) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;

    }
}