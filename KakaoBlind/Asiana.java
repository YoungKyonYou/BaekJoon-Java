package KakaoBlind;

import java.util.*;

public class Asiana {
    public static void main(String[] args) throws Exception {
        // 답
        // 1,4,10,6,15,18,20,22,23,24,29,26,32,31,33,34
        int[][] paths = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 10, 7 }, { 7, 6 }, { 15, 17 }, { 17, 18 }, { 20, 22 },
                { 23, 24 }, { 29, 27 }, { 27, 26 }, { 34, 33 }, { 32, 31 } };

        // 답
        // 1,4,8,6
        int[][] paths2 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 8, 7 }, { 7, 6 } };

        // 답
        // 1,2,3,6,10,9
        int[][] paths3 = { { 3, 4 }, { 1, 2 }, { 4, 5 }, { 10, 9 }, { 5, 6 } };

        // 답
        // 1,4,5,8,9,10
        int[][] paths4 = { { 9, 10 }, { 7, 8 }, { 5, 6 }, { 6, 7 }, { 3, 4 }, { 1, 2 }, { 2, 3 } };

        
        int[][] paths5 = { { 1, 2 }, { 4, 5 }, { 10, 9 }, { 3, 4 } };
        solution(paths);

    }

    public static void solution(int[][] paths) {
        Arrays.sort(paths, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        print(paths);
        List<Integer> answer = new ArrayList<>();
        int[][] temp = new int[paths.length][2];
        boolean[] visit = new boolean[paths.length];
        int idx = 0;
        for (int i = 0; i < paths.length; i++) {
            int second = paths[i][1];
            int first = paths[i][0];
            if (!visit[i]) {
                temp[idx][0] = paths[i][0];
                temp[idx][1] = paths[i][1];
                visit[i] = true;
            } else {
                continue;
            }

            for (int j = 0; j < paths.length; j++) {
                if (second == paths[j][0] && i != j && !visit[j]) {
                    temp[idx][1] = paths[j][1];
                    second = paths[j][1];
                    visit[j] = true;
                }
                if (first == paths[j][1] && i != j && !visit[j]) {
                    temp[idx][0] = paths[j][0];
                    first = paths[j][0];
                    visit[j] = true;
                }
            }
            idx++;
        }

        print(temp);

    }

    public static void print(int[][] paths) {
        for (int i = 0; i < paths.length; i++) {
            System.out.println(paths[i][0] + " " + paths[i][1]);
        }
        System.out.println();
    }
}