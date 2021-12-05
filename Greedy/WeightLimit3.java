package Greedy;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class WeightLimit3 {
    public static int ans = 0;
    public static class Edge {
        public int v2;
        public int w;

        public Edge(int v2, int w) {
            this.v2 = v2;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Edge>[] list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        int min=Integer.MAX_VALUE;
        int max=-1;
        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
            min=Math.min(min,c);
            max=Math.max(max,c);
        }
        StringTokenizer token2=new StringTokenizer(br.readLine());
        int s=Integer.parseInt(token2.nextToken());
        int e=Integer.parseInt(token2.nextToken());
        int start = min;
        int end = max;
        while (start <= end) {
            boolean[] visit = new boolean[N + 1];
            int mid = (start + end) / 2;
            if (dfs(list, N, M, visit, s, e, mid)) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean dfs(List<Edge>[] list, int N, int M, boolean[] visit, int start, int end, int weight) {
        if (visit[start]) {
            return false;
        }
        visit[start] = true;
        if (start == end) {
            return true;
        }
        for (Edge e : list[start]) {
            if (e.w>=weight) {
                if(dfs(list,N,M,visit,e.v2,end,weight))
                    return true;
            }
        }
        return false;
    }
}
