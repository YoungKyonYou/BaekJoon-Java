package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CycleGame {
    public static int[] map;
    public static int v1, v2;
    public static int N, M;
    public static int q, r;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    
    public static int find(int x) {
        if (map[x] == x) {
            return x;
        } else {
            return map[x] = find(map[x]);
        }
    }
    public static void union(int x, int y) {
        int a = find( x);
        int b = find( y);
        if (a != b) {
            map[b] = a;
        }
    }
    public static void main(String[] args) throws Exception {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = i;
        }
        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(token.nextToken());
            v2 = Integer.parseInt(token.nextToken());
            q = find(v1+1);
            r = find(v2+1);
            if (q== r) {
                System.out.println(i + 1);
                return;
            }
            union( v1+1, v2+1);

        }
        System.out.println(0);

    }

}