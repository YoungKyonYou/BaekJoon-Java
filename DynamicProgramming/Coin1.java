package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Coin1{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n + 1];
        int[] dp = new int[k+1];
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for (int c = 1; c < coins.length; c++) {
            for (int i = coins[c]; i <= k; i++) {
                dp[i] += dp[i-coins[c]];
            }
        }
        System.out.println(dp[k]);

    }
    public static void solution() {

    }
}