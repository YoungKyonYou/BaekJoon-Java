package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Lie {
    public static int ans = 0;
    public static int find(int[] map, int x) {
        if (map[x] == x) {
            return x;
        } else {
            return map[x] = find(map, map[x]);
        }
    }

    public static boolean union(int[] map, int a,int b){
        int x=find(map,a);
        int y=find(map,b);
        if(x==y){
            return true;
        }else{
            map[x]=y;
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] map = new int[N + 1];
        for (int i = 1; i <= N; i++)
            map[i] = i;

        StringTokenizer token = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(token.nextToken());
        boolean[] truePeople=new boolean[N+1];
        for (int i = 0; i < T; i++) {
            int b = Integer.parseInt(token.nextToken());
            truePeople[b] = true;
        }

        List<Integer>[] list = new ArrayList[M+1];

        for (int i = 1; i <= M; i++) {
            list[i] = new ArrayList<>();
            StringTokenizer token2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token2.nextToken());
            int pre = Integer.parseInt(token2.nextToken());
            list[i].add(pre);
            for (int j = 1; j < a; j++) {
                int b = Integer.parseInt(token2.nextToken());
                list[i].add(b);
                union(map, b, pre);
                pre = b;
            }
        }
        int p = -1;
        for (int i = 1; i <= N; i++) {
            p = find(map, i);
            if (truePeople[i]) {
                truePeople[p] = true;
            }
        }
        for (int i = 1; i <=M; i++) {
            if (!truePeople[find(map,list[i].get(0))]) {
                ans++;
            }
        }

        System.out.println(ans);
    }

}