package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class LIS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(arr, n));
    }

    public static int solution(int[] arr, int n) {
        int[] dp = new int[1001];
        dp[1] = 1;
        int answer = -1;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (max < dp[j] && arr[j] < arr[i]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}