package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CountCircleGroups {
    public static int cnt = 0;

    public static int find(int[] map, int x) {
        if (map[x] == x) {
            return x;
        } else {
            return map[x] = find(map, map[x]);
        }
    }

    public static void union(int[] map, int x, int y) {
        int px = find(map,x);
        int py = find(map, y);

        if (px != py) {

            map[py] = px;
        }
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            cnt = 0;

            int N = Integer.parseInt(br.readLine());
            cnt=N;
            int[] map = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                map[j] = j;
            }
            int x = 0, y = 0, r = 0;
            int[][] cord = new int[N][3];
            for (int p = 0; p < N; p++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                x = Integer.parseInt(token.nextToken());
                y = Integer.parseInt(token.nextToken());
                r = Integer.parseInt(token.nextToken());
                cord[p][0] = x;
                cord[p][1] = y;
                cord[p][2] = r;
                // dfs(visit, x, y, r);
            }
            boolean[] visit = new boolean[N + 1];
            for (int j = 0; j < cord.length; j++) {
                for (int k = j + 1; k < cord.length; k++) {
                    double dis = Math
                            .sqrt(Math.pow((cord[j][0] - cord[k][0]), 2) + Math.pow((cord[j][1] - cord[k][1]), 2));
                    if (dis <= cord[j][2] + cord[k][2]) {
                        if (find(map, j + 1) != find(map, k + 1)) {
                            union(map, j + 1, k + 1);
                            cnt--;
                        }
                    }
                }
            }


           // print(visit);

            System.out.println(cnt);
        }

    }

    public static void print(boolean[][] visit) {
        for (boolean[] b : visit) {
            for (boolean bc : b) {
                if (bc) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    
}