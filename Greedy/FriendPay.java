package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class FriendPay {
    static int ans = 0;
    static int K = 0;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] money = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            list[idx].add(x);
            list[x].add(idx);
        }

        boolean[] visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!bfs(visit, i, money, list)) {
                System.out.println("Oh no");
                return;
            }
        }
        System.out.println(ans);
    }

    public static boolean bfs(boolean[] visit, int s, int[] money, List<Integer>[] list) {
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        if (!visit[s]) {
            q.add(s);
            pq.add(money[s]);
            visit[s] = true;
        } else {
            return true;
        }
        while (!q.isEmpty()) {

            int a = q.poll();
            for (int x : list[a]) {
                if (!visit[x]) {
                    pq.add(money[x]);
                    q.add(x);
                    visit[x] = true;
                }
            }
        }
        if (!pq.isEmpty() && K - pq.peek() >= 0) {
            int m=pq.poll();
            K -= m;
            ans+=m;
            return true;
        }else if (!pq.isEmpty() && K - pq.peek() < 0) {
            return false;
        }

        return true;
            
    }
}