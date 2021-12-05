package KakaoBlind;

import java.util.*;

public class RoadPave2 {
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
        int[][] board3 = { { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 1 }, { 1, 0, 0, 0 } };
        int[][] board2 = { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } };
        System.out.println(solution(board3));
    }

    public static int solution(int[][] board) {
        int n = board.length;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, 0));
        board[0][0] = 0;
        boolean[][][] visit = new boolean[n][n][5];
        for (int i = 1; i < 5; i++) {
            visit[0][0][i] = true;
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == n - 1 && node.y == n - 1) {
                ans = Math.min(ans, node.money);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int px = node.x + dx[i];
                int py = node.y + dy[i];
                if (px >= 0 && py >= 0 && px < n && py < n && !visit[px][py][dd[i]] && board[px][py] != 1) {
                    visit[px][py][dd[i]] = true;
                    if (node.d == 0) {
                        queue.add(new Node(px, py, node.money + 100, dd[i]));
                    } else if ((node.d + dd[i]) % 2 == 0) {
                        queue.add(new Node(px, py, node.money + 100, dd[i]));
                    } else {
                        queue.add(new Node(px, py, node.money + 600, dd[i]));
                    }

                }
            }
        }

        
        return ans;
    }

}