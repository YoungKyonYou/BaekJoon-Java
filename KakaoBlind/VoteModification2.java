package KakaoBlind;
import java.util.*;
public class  VoteModification2{
    public static void main(String[] args) throws Exception {
        int n1 = 8;
        int k1 = 2;
        String[] cmd1 = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
        String[] cmd2 = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };
        System.out.println(solution(n1, k1, cmd2));
    }
    
    public static String solution(int n, int k, String[] cmd) {
        Stack<Integer> remove_order = new Stack<Integer>();
        int table_size = n;
        for (int i = 0; i < cmd.length; i++) {
            char c = cmd[i].charAt(0);
            if (c == 'D')
                k += Integer.parseInt(cmd[i].substring(2));
            else if (c == 'U')
                k -= Integer.parseInt(cmd[i].substring(2));
            else if (c == 'C') {
                remove_order.add(k);
                table_size--;
                if (k == table_size)
                    k--;
            } else if (c == 'Z') {
                if (remove_order.pop() <= k)
                    k++;
                table_size++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < table_size; i++)
            builder.append("O");
        while (!remove_order.isEmpty())
            builder.insert(remove_order.pop().intValue(), "X");
        String answer = builder.toString();
        return answer;
    }
}