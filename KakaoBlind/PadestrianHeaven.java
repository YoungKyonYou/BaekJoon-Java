package KakaoBlind;
import java.util.*;

public class PadestrianHeaven {
    public static int MOD = 20170805;

    public static void main(String[] args) throws Exception {
        int m1 = 3;
        int n1 = 6;
        int[][] city_map = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };
        System.out.println(solution(m1, n1, city_map));
    }

    public static void print(int[][] dp) {
        for (int[] a : dp) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m + 1][n + 1][2];
        dp[1][1][0] = dp[1][1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cityMap[i - 1][j - 1] == 0) {
                    dp[i][j][0] += (dp[i - 1][j][0] + dp[i][j - 1][1]) % MOD;
                    dp[i][j][1] += (dp[i - 1][j][0] + dp[i][j - 1][1]) % MOD;
                } else if (cityMap[i - 1][j - 1] == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                } else {
                    dp[i][j][0] = (dp[i - 1][j][0]);
                    dp[i][j][1] = (dp[i][j - 1][1]);
                }
            }
        }
        return dp[m][n][0];
 
    }
}