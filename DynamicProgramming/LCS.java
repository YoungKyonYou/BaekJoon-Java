package DynamicProgramming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class LCS{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[] dp = new int[str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            int temp = 0;
            for (int j = 0; j < str2.length(); j++) {
                if (temp < dp[j]) {
                    temp = dp[j];
                    continue;
                }
                if (str1.charAt(i) == str2.charAt(j) && (temp+1 > dp[j] || dp[j]==0)) {
                    dp[j] = temp + 1;
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[str2.length()-1]);
    }
    public static void solution() {

    }
}