package DynamicProgramming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class  Triangle2{
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
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    triangle[i][j] = triangle[i - 1][j]+triangle[i][j];
                } else {
                    triangle[i][j] = Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, triangle[n][i]);
        }
        
        return answer;
    }
}