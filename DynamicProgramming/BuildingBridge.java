package DynamicProgramming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BuildingBridge {
    static long[][] dy = new long[31][31];
    public static long DFS(int n, int r) {
        if (dy[n][r] > 0)
            return dy[n][r];
        if (n == r || r == 0)
            return 1;
        else
            return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
           

            System.out.println(DFS(r,l));
        }
    }

}