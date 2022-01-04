package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class WineTasting2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i <=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(arr, n));

    }

    public static int solution(int[] arr, int n) {
        int[] dy = new int[arr.length+1];
        dy[0] = 0;
        dy[1] = arr[0];
        dy[2] = arr[0] + arr[1];
        for (int i = 3; i < arr.length; i++) {
            dy[i] = Math.max(dy[i-1],Math.max(arr[i - 2] + dy[i - 3] + arr[i-1], dy[i - 2]+arr[i-1]));
        }
        return dy[dy.length - 1];
    }
}