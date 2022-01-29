package DynamicProgramming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Tile01{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        if (n <= 3) {
            System.out.println(n);
            return;
        }
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%15746;
        }
        System.out.println(dp[n]);
    }
    public static void solution() {

    }
}