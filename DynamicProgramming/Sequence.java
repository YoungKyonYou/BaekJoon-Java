package DynamicProgramming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Sequence{
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] num = new int[T];
        for (int i = 0; i < T; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        List<Long> answer = solution(T, num);
        for (long a : answer) {
            System.out.println(a);
        }
    }

    public static List<Long> solution(int T, int[] num) {
        
        List<Long> answer=new ArrayList<>();
        for (int i = 0; i < T; i++) {
            
            if (num[i] <= 3) {
                answer.add(1L);
                continue;
            }
            if (num[i] <= 5) {
                answer.add(2L);
                continue;
            }
            long[] dy = new long[num[i] + 1];
            dy[1] = dy[2] = dy[3] = 1;
            dy[4] = dy[5] = 2;
            for (int j = 6; j <= num[i]; j++) {
                dy[j] = dy[j - 5] + dy[j - 1];
            }
            answer.add(dy[dy.length-1]);
        }
        return answer;
    }
}