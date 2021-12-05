package KakaoBlind;

import java.util.*;

public class RoadPave4 {
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
        int n = board.length;
        int[][][] visit = new int[n][n][4];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);
            }
        }
        queue.add(new int[] { 0, 0, 0, 1 });
        queue.add(new int[] { 0, 0, 0, 2 });
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int px = temp[0] + dx[i];
                int py = temp[1] + dy[i];

                int c = temp[2] + ((temp[3] == i) ? 100 : 600);
                if (px == n - 1 && py == n - 1) {
                    ans = Math.min(ans, c);
                }
                if (px >= 0 && py >= 0 && px < n && py < n && c < visit[px][py][i] && board[px][py] != 1) {
                    visit[px][py][i] = c;
                    queue.add(new int[] { px, py, c, i });
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            ans = Math.min(visit[n - 1][n - 1][i], ans);
        }
        return ans;
    }
}