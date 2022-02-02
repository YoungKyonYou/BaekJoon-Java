package DynamicProgramming;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.*;
public class AscendingNunber2{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <=j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= 10007;
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum);

       

    }
}