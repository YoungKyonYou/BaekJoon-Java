package KakaoBlind;

import java.util.*;

public class GPS {
    public static int INF = 99999999;

    public static void main(String[] args) throws Exception {
        int n1 = 7;
        int m1 = 10;
        int[][] edge_list1 = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 }, { 5, 7 },
                { 6, 7 } };
        int k1 = 6;
        int[] gps_log = { 1, 2, 3, 3, 6, 7 };
        System.out.println(solution(n1, m1, edge_list1, k1, gps_log));
    }

    public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int[][] road = new int[n + 1][n + 1];
        // i와 j가 연결되어 있다면 1 아니면 0
        for (int i = 0; i < edge_list.length; i++) {
            int s = edge_list[i][0], e = edge_list[i][1];
            road[s][e] = 1;
            road[e][s] = 1;
        }
        int[][] dp = new int[k][n + 1];
        // 최솟값을 구해야 하므로 모든 값 INF 초기화
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = INF;
            }
        }
        dp[0][gps_log[0]] = 0;
        // 맨 첫번째 값은 정해진 값이기 때문에 0번째 인덱스에는 gps_log[0]의 값이 들어가야 한다.
        for (int i = 1; i < k; i++) {
            // 인덱스 1에서 부터 인덱스 k-1까지 순차적으로 확인
            for (int j = 1; j < n + 1; j++) {
                // 1노드부터 n노드 까지 하나하나씩 확인
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                // 이동을 하지 않을 경우 먼저 확인
                for (int node = 1; node < n + 1; node++) {
                    // 이동을 할 경우
                    if (road[j][node] == 1) {
                        // j노드와 연결된 노드를 확인하고 그 노드들로부터 j로 가는 모든 경우 확인
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][node]);
                    }
                }
                if (j != gps_log[i]) {
                    dp[i][j]++;
                }
                // j노드가 gps_log[i]와 다르다면
                // gps_log를 수정해야 하기 때문에 값을 더해줌
            }
        }
        if (dp[k - 1][gps_log[k - 1]] < INF) {
            return dp[k - 1][gps_log[k - 1]];
        } else {
            return -1;
        }
    }

}