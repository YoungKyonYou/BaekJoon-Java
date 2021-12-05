package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class WeightLimit2 {
    static int ans = 0;

    public static class Node  {
        public int v2;
        public int w;

        public Node(int v2, int w) {
            this.v2 = v2;
            this.w = w;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min = 0;
        int max = 0;
        List<Node>[] list = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            list[i]=new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(token.nextToken());
            int p2 = Integer.parseInt(token.nextToken());
            int w = Integer.parseInt(token.nextToken());
            list[p1].add(new Node(p2,w));
            list[p2].add(new Node(p1, w));
            min = Math.min(min, w);
            max = Math.max(max, w);
        }

        StringTokenizer t = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(t.nextToken());
        int b = Integer.parseInt(t.nextToken());

        

        while(min<=max){
            int mid = (min + max) / 2;
            if (bfs(list, N, a, b,mid)) {
                ans = Math.max(ans, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        

        System.out.println(ans);
    }

    public static boolean bfs(List<Node>[] list, int N, int a, int b, int weight) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        boolean[] visit = new boolean[N + 1];
        visit[a] = true;

        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            if (temp == b)
                return true;
            for (int i = 0; i < list[temp].size(); i++) {
                if (!visit[list[temp].get(i).v2] && list[temp].get(i).w >=weight) {
                    visit[list[temp].get(i).v2] = true;
                    queue.add(list[temp].get(i).v2);
                }
            }

        }
        return false;
    }

}