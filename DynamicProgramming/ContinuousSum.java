package DynamicProgramming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class  ContinuousSum{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr=new int[n+1];
        for (int i = 1; i <=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(arr,n));
    }

    public static int solution(int[] arr, int n) {
        arr[0] = Integer.MIN_VALUE + 2000000;
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            arr[i] = Math.max(arr[i - 1] + arr[i], arr[i]);
            answer=Math.max(answer,arr[i]);
        }
        return answer;
    }
}