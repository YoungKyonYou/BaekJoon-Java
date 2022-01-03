package Getcha;

import java.util.*;

public class Problem2 {
    public static void main(String[] args) throws Exception {
        int N = 5;
        int[][] relation = { { 1, 2 }, { 4, 2 }, { 3, 1 }, { 4, 5 } };
        int[] answer = solution(N, relation);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int N, int[][] relation) {
        List<Integer>[] nodes = new ArrayList[N + 1];
        int[] answer = new int[N];
        for (int i = 0; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < relation.length; i++) {
            nodes[relation[i][0]].add(relation[i][1]);
            nodes[relation[i][1]].add(relation[i][0]);
        }
        for (int i = 1; i <= N; i++) {
            bfs(nodes, i, N, answer);
        }


        return answer;
    }

    public static void bfs(List<Integer>[] nodes, int start, int N, int[] answer) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        queue.add(start);
        visit[start] = true;
        int temp = queue.poll();
        for (Integer node : nodes[temp]) {
            if (!visit[node]) {
                visit[node] = true;
                queue.add(node);
            }
        }
        int idx = queue.size();
        answer[start - 1] += queue.size();
        for (int i = 0; i < idx; i++) {
            temp = queue.poll();
            for (Integer node : nodes[temp]) {
                if (!visit[node]) {
                    visit[node] = true;
                    queue.add(node);
                }
            }
        }
        answer[start - 1] += queue.size();
    }

    public static void printArrTwo(int[][] arr) {
        for (int[] a : arr) {
            System.out.print(Arrays.toString(a));
        }
        System.out.println();
    }

    public static void printArrOne(int[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void printList(List<Integer> list) {
        for (int a : list) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void printMap(HashMap<Integer, Integer> map) {
        for (Integer a : map.keySet()) {
            System.out.println("key: " + a + " value:" + map.get(a));
        }
        System.out.println();
    }
}