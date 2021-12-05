package DynamicProgramming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class  Triangle{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n+1][n+1];
        
        for (int i = 1; i <=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = i-1; j >= 0; j--) {
                triangle[i][(i-1)-j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(triangle, n));
    }

    public static int solution(int[][] triangle, int n) {
        int[][] dp = new int[n + 1][n + 1];
        int idx = 1;
        dp[1][0] = triangle[1][0];
        for (int i = 2; i <= n; i++) {
            dp[i][0]= (triangle[i][0]+ dp[i-1][0]);
            dp[i][idx]= (triangle[i][idx]+ dp[i-1][idx-1]);
            idx++;
        }
        idx=1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= idx; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];

            }
            idx++;
        }
        System.out.println();
        int answer = -1;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n][i]);
        }
        return answer;
    }
}