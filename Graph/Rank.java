package Graph;
import java.util.*;
public class  Rank{
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

        int[][] floyd = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                floyd[i][j] = INF;
            }
            floyd[i][i] = 0;
        }
        print(floyd);

        for (int i = 0; i < results.length; i++) {
            floyd[results[i][0]][results[i][1]] = 1;
        }
        print(floyd);
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (floyd[i][j] > floyd[i][k] + floyd[k][j]) {
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                    }
                }
            }
        }
        print(floyd);
        int result = 0;
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 1; j <= n; j++) {
                if (i != j && floyd[i][j] == INF && floyd[j][i] == INF) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                result++;
        }
        return result;
    }
}