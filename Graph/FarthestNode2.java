package Graph;

import java.util.*;

public class FarthestNode2 {
    public static int m = -1;

    public static void main(String[] args) throws Exception {
        int n = 6;
        int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
        System.out.println(solution(n, edge));
    }
    public static int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList();
        int answer = 0;
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
            // graph[edge[i][0]].add(edge[i][1]);
            // graph[edge[i][1]].add(edge[i][0]);
        }
        boolean[] visit = new boolean[n + 1];
        Integer[] count = new Integer[n + 1];
        Arrays.fill(count, 0);
        visit[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (int g : graph.get(node)) {
                if (!visit[g]) {
                    visit[g] = true;
                    count[g] = count[node] + 1;
                    // count[g] = Math.min(count[g], node.count + 1);
                    queue.add(g);
                }
            }
        }
        /*int max = 0;
        for (int i = 2; i <= n; i++) {
            if (max < count[i]) {
                max = count[i];
                answer = 1;
            } else if (max == count[i]) {
                answer++;
            }
        }*/
        
          Arrays.sort(count, Collections.reverseOrder());
          for (int i = 0; i <= n; i++) {
              if (count[0] == count[i]) {
                  answer++;
              }
            
          }
         
        // System.out.println();
        return answer;
    }

}