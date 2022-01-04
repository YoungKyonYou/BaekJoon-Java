package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class WineTasting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(arr, n));

    }

    public static int solution(int[] arr, int n) {
        int[] dy = new int[arr.length];
        if (n >= 1) {
            dy[0] = arr[0];
        }
        if (n >= 2) {
            dy[1] = arr[0] + arr[1];
        }
        if (n >= 3) {
            dy[2] = Math.max(dy[1],Math.max(arr[1] + arr[2], arr[0] + arr[2]));
        }
        for (int i = 3; i < arr.length; i++) {
            dy[i] = Math.max(dy[i-1],Math.max(arr[i - 1] + dy[i - 3] + arr[i], dy[i - 2]));
        }
        return dy[dy.length - 1];
    }
}