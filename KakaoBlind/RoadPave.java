package KakaoBlind;

import java.util.*;

public class RoadPave {
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
    public static int[] dd = { 1, 2, 3, 4 };
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        int[][] board3 = { { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 1 }, { 1, 0, 0, 0 } };
        int[][] board2 = { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } };
        int[][] board4 = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };
        System.out.println(solution(board4));
    }

    public static int solution(int[][] board) {
        int n = board.length;
        board[0][0] = 2;
        dfs(board, 0, 0, 0, n, 0);
        return ans;
    }

    public static void dfs(int[][] board, int total, int x, int y, int n, int d) {
        if (x == n - 1 && y == n - 1) {
            ans = Math.min(ans, total);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int px = x + dx[i];
            int py = y + dy[i];
            if (px >= 0 && py >= 0 && px < n && py < n && board[px][py] == 0) {
                board[px][py] = 2;
                if (d == 0) {
                    dfs(board, total + 100, px, py, n, dd[i]);
                } else if (d == dd[i] || d + dd[i] % 2 == 0) {
                    dfs(board, total + 100, px, py, n, dd[i]);
                } else {
                    dfs(board, total + 600, px, py, n, dd[i]);
                }
                board[px][py] = 0;
            }

        }

    }
}