package Greedy;


import java.io.*;

public class Airport {
    public static int find(int[] parent, int v) {
        if (parent[v] == v) {
            return v;
        } else {
            return parent[v] = find(parent, parent[v]);
        }
    }

    public static void union(int[] parent, int a, int b) {
        int x = find(parent, a);
        int y = find(parent, b);
        parent[x] = y;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int[] parent = new int[G + 1];
        for(int i=1;i<=G;i++)
            parent[i] = i;
        int P = Integer.parseInt(br.readLine());
        int cnt=0;
        for (int i = 0; i < P; i++) {
            int num = Integer.parseInt(br.readLine());
            int x = find(parent, num);
            if (x != 0) {
                union(parent, x, x - 1);
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
    public static void solution() {

    }
}