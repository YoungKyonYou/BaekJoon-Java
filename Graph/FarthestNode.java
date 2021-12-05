package Graph;
import java.util.*;

public class FarthestNode {
    public static int m = -1;

    public static void main(String[] args) throws Exception {
        int n = 6;
        int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
        System.out.println(solution(n, edge));
    }

    public static int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        boolean[] visit = new boolean[n + 1];
        Integer[] count = new Integer[n + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        visit[1] = true;
        dfs(graph, 1, visit, 1,count);
        Arrays.sort(count, (o1, o2) -> {
            return o2 - o1;
        });
        for (int i = 1; i <= n; i++) {
           // System.out.print(count[i] + " ");
        }
        int ans = 1;
        for (int i = 3; i <= n; i++) {
            if (count[i - 1] == count[i]) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }

    public static void dfs(List<Integer>[] graph, int s, boolean[] visit, int cnt,Integer[] count) {
        for (Integer g : graph[s]) {
            if (!visit[g]) {
                visit[g] = true;
                dfs(graph, g, visit, cnt + 1,count);
                count[g] = Math.min(cnt, count[g]);
                visit[g] = false;
            }
        }

    }
}