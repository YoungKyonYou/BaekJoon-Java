package Getcha;

import java.util.*;

public class Problem1 {
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
    public static int answer = 0;

    public static void main(String[] args) throws Exception {
        int[][] board = { { 1, 1, 4, 3 }, { 3, 2, 1, 4 }, { 3, 1, 4, 2 }, { 2, 1, 3, 3 } };
        int[][] board2 = { { 1, 2, 1, 2 }, { 3, 4, 3, 4 }, { 1, 2, 1, 2 }, { 3, 4, 3, 4 } };
        System.out.println(solution(board));

    }

    public static void swap(int[][] board, int px1, int py1, int px2, int py2) {
        int temp = board[px1][py1];
        board[px1][py1] = board[px2][py2];
        board[px2][py2] = temp;
    }
    public static void check(int[][] board, int px, int py, int i, int j, Set<String> visit) {
        int tbcnt = 1;
        int rlcnt = 1;
        int temp = board[px][py];
        int tpx = px;
        int tpy = py;
        tpx--;
        // 위로 보기
        while (tpx >= 0 && temp == board[tpx][py]) {
            tbcnt++;
            tpx--;
        }
        tpx = px;
        tpx++;
        // 아래로보기
        while (tpx < board.length && temp == board[tpx][py]) {
            tbcnt++;
            tpx++;
        }
        tpy++;

        // 오른쪽 보기
        while (tpy < board.length && temp == board[px][tpy]) {
            rlcnt++;
            tpy++;
        }
        tpy = py;
        tpy--;
        // 왼쪽
        while (tpy >= 0 && temp == board[px][tpy]) {
            rlcnt++;
            tpy--;
        }

        if ((tbcnt >= 3 || rlcnt >= 3)) {
            if (visit.add(Arrays.deepToString(board))) {
                System.out.println(Arrays.deepToString(board));
                answer++;
            }
        }
    }

    public static int solution(int[][] board) {
        Set<String> visit = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                for (int k = 0; k < 4; k++) {
                    int px = i + dx[k];
                    int py = j + dy[k];
                    if (px >= 0 && py >= 0 && px < board.length && py < board.length) {
                        swap(board, i, j, px, py);
                        check(board, i, j, px, py, visit);
                        swap(board, i, j, px, py);
                    }
                }
            }
        }
        return visit.size() != 0 ? visit.size() : -1;
    }

    public static void printArrTwo(int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
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