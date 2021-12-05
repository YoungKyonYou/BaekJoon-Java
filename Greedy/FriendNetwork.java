package Greedy;

import java.io.*;
import java.util.*;

public class FriendNetwork {
    public static int find(int a, int[] parent) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a], parent);
        }
    }

    public static int union(int a, int b, int[] parent,int[] level) {
        int x = find(a,parent);
        int y = find(b, parent);
        if (x != y) {
            parent[x] = y;
            level[y] += level[x];
            level[x] = 1;
        }
        return level[y];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] parent = new int[N * 3];
            int[] level = new int[N * 3];
            int cnt = 1;
            for (int j = 1; j < N * 3; j++) {
                parent[j] = j;
                level[j] = 1;
            }
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                if (!map.containsKey(s1)) {
                    map.put(s1, cnt++);
                }
                if (!map.containsKey(s2)) {
                    map.put(s2, cnt++);
                }
                sb.append(union(map.get(s1), map.get(s2), parent, level) + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}