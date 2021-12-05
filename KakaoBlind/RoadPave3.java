package KakaoBlind;

import java.util.*;

public class RoadPave3 {
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
    public static int[] dd = { 1, 2, 3, 4 };
    public static int ans = Integer.MAX_VALUE;

    public static class Node {
        public int x;
        public int y;
        public int money;
        public int d;

        public Node(int x, int y, int money, int d) {
            this.x = x;
            this.y = y;
            this.money = money;
            this.d = d;
        }
    }

    public static void print(int[][] board) {
        for (int[] a : board) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        int[][] board4 = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };

        int[][] board3 = { { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 1 }, { 1, 0, 0, 0 } };
        int[][] board2 = { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } };
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
        int N = board.length;

        int[][][] cost = new int[N][N][4];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 0, 1 });
        queue.add(new int[] { 0, 0, 0, 3 });

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dy[k];
                int ny = cur[1] + dx[k];
                int c = cur[2] + (cur[3] == k ? 100 : 600);

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || board[nx][ny] == 1 || cost[nx][ny][k] <= c)
                    continue;
                cost[nx][ny][k] = c;
                queue.add(new int[] { nx, ny, c, k });
            }
        }
        for (int i = 0; i < 4; i++) {
            ans = Math.min(ans, cost[N - 1][N - 1][i]);
        }
        return ans;
    }
}