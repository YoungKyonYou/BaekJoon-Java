package DynamicProgramming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Stickers{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N=Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][N + 1];
            int[][] dp = new int[2][N + 1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if (N <= 1) {
                System.out.println(stickers[0][1] > stickers[1][1] ? stickers[0][1] : stickers[1][1]);
                continue;
            }
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];
            dp[0][2] = stickers[0][2]+stickers[1][1];
            dp[1][2] = stickers[1][2]+stickers[0][1];

            for (int j = 3; j <= N; j++) {
                for (int i = 0; i < 2; i++) {
                    if(i==0){
                        dp[i][j] = Math.max(dp[i + 1][j - 2] + stickers[i][j], dp[i + 1][j - 1] + stickers[i][j]);
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j - 2] + stickers[i][j], dp[i - 1][j - 1] + stickers[i][j]);
                    }
                }
            }

            System.out.println(dp[1][N]>dp[0][N]?dp[1][N]:dp[0][N]);
        }
    }
    public static void solution() {

    }
}