package DynamicProgramming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class  BuildingBridge{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            long sum = 0;
            long temp = r;
            long tl = r;
            for (int j = 0; j < l - 1; j++) {
                temp *= (tl - 1);
                tl--;
            }
            long tmp = l;
            long tr = l;
            for (int j = l; j > 1; j--) {
                tmp *= (tr - 1);
                tr--;
            }
            sum = (long)(temp / tmp);

            System.out.println(sum);
        }
    }

}