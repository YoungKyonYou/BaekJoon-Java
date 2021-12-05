package Greedy;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class WeightLimit4 {
    public static int ans = 0;

    public static class Edge {
        public int v1;
        public int v2;
        public int w;

        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
    }

    public static int find(int[] map, int a) {
        if (map[a] == a) {
            return a;
        } else {
            return map[a] = find(map, map[a]);
        }
    }

    public static boolean union(int[] map, int a, int b) {
        int x = find(map, a);
        int y = find(map, b);
        if (x == y) {
            return true;
        } else {
            map[x] = y;
            return false;
        }
    }

    public static boolean sameGraph(int[] map, int a, int b) {
        int x = find(map, a);
        int y = find(map, b);
        if (x == y) {
            return false;
        } else {
            return true;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] map = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            return o2.w - o1.w;
        });
        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());
            pq.add(new Edge(a,b, c));
        }
        StringTokenizer token2=new StringTokenizer(br.readLine());
        int s=Integer.parseInt(token2.nextToken());
        int e = Integer.parseInt(token2.nextToken());
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (union(map, edge.v1, edge.v2)) {
                continue;
            }

            if (sameGraph(map, s, e)) {
                continue;
            }
            ans = edge.w;
            break;
        }
        System.out.println(ans);

       
    }


}
