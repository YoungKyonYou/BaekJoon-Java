package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class WeightLimit {
    static int ans = 0;
    static int max = 0;
    public static class Node implements Comparable<Node>{
        public int v1;
        public int v2;
        public int w;

        public Node(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }

        public int compareTo(Node n) {
            return n.w - w;
        }
    }
    public static int find(int a, int[] map) {
        if (map[a] == a) {
            return a;
        } else {
            return map[a] = find(map[a], map);
        }
    }

    public static boolean union(int a, int b, int[] map) {
        int x = find(a, map);
        int y = find(b, map);
        if (x == y)
            return true;
        else
            map[x] = y;
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] map = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            map[i] = i;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(token.nextToken());
            int p2 = Integer.parseInt(token.nextToken());
            int w = Integer.parseInt(token.nextToken());
            pq.add(new Node(p1, p2, w));
            // union(p1, p2, map, weight, w);
        }

        StringTokenizer t = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(t.nextToken());
        int b = Integer.parseInt(t.nextToken());

        while (pq.isEmpty() == false) {
            // edge extract
            Node cur = pq.poll();
            // two nodes connected by this edge to be checked if they already belong to the
            // same graph

            if (union(cur.v1, cur.v2, map) == true)
                continue;
            // 새로 union 시켜 줄 때(기존에 두 노드가 같은 그래프가 아니었던 경우) 마다, start,end가 같은 그래프 소속이 되었는지 확인
            // 같은 그래프 소속이라면, 최대 중량을 찾은 것 --> 종료
            if (sameGraph(a, b,map) == false)
                continue;
            max = cur.w;
            break;
        }

        System.out.println(max);
    }
    
    public static boolean sameGraph(int a, int b,int[] map) {
        int ra = find(a,map);
        int rb = find(b,map);
        if (ra == rb)
            return true;
        else
            return false;
    }
}