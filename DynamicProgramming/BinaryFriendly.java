package DynamicProgramming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class  BinaryFriendly{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

    public static long solution(int n) {
        if (n == 1 || n==2) 
            return 1;

        long b = 1;
        long sum = 1;
        for (int i = 3; i <= n; i++) {
            long temp = sum;
            sum += b;
            b = temp;
        }
        return sum;
    }
}