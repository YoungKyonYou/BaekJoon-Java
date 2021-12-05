package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CycleGame2 {
    static public int cnt = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        List<Integer>[] list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            boolean[] visit = new boolean[N];
            token = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(token.nextToken());
            int v2 = Integer.parseInt(token.nextToken());
            list[v1].add(v2);
            //list[v2].add(v1);
            boolean flag = solution(list, N, M, visit, 0);
            if(flag)
                break;
            cnt = 0;
        }
        System.out.println(cnt);

    }

    public static boolean solution(List<Integer>[] list, int N, int M, boolean[] visit, int s) {

        for (int a : list[s]) {
            if (!visit[a]) {
                visit[a] = true;
                cnt++;
                boolean flag = solution(list, N, M, visit, a);
                if (flag) {
                    return true;
                }

            } else {
                return true;
            }
        }
        return false;
    }
}