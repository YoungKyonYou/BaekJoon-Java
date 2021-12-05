package KakaoBlind;

import java.util.*;

public class TaxiCost {

    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;

        int n2 = 7;
        int s2 = 3;
        int a2 = 4;
        int b2 = 1;

        int[][] fares2 = { { 5, 7, 9 }, { 4, 6, 4 }, { 3, 6, 1 }, { 3, 2, 3 }, { 2, 1, 6 } };
        int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
                { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };
        System.out.println(solution(n, s, a, b, fares));
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] flyd = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    flyd[i][j] = 0;
                } else {
                    flyd[i][j] = 200000001;
                }
            }
        }
        for (int i = 0; i < fares.length; i++) {
            flyd[fares[i][0]][fares[i][1]] = fares[i][2];
            flyd[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (flyd[i][j] > flyd[i][k] + flyd[k][j]) {
                        flyd[i][j] = flyd[i][k] + flyd[k][j];
                    }
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            ans = Math.min(ans, flyd[s][i] + flyd[i][a] + flyd[i][b]);
        }

        return ans;
    }

}