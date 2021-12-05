package KakaoBlind;
import java.util.*;
public class  VoteModification{
    public static void main(String[] args) throws Exception {
        int n1 = 8;
        int k1 = 2;
        String[] cmd1 = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
        String[] cmd2 = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };
        System.out.println(solution(n1, k1, cmd2));
    }
    
    public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        LinkedList<Integer> list = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackValue = new Stack<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int ptr = k;
        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].charAt(0) == 'U') {
                int tempIdx = Character.getNumericValue(cmd[i].charAt(2));
                ptr -= tempIdx;
            } else if (cmd[i].charAt(0) == 'D') {
                int tempIdx = Character.getNumericValue(cmd[i].charAt(2));
                ptr += tempIdx;

            } else if (cmd[i].charAt(0) == 'C') {
                stackValue.add(list.remove(ptr));
                stack.add(ptr);
                if (ptr == list.size()) {
                    ptr--;
                }
            } else {
                int tempIdx = stack.pop();
                if (tempIdx < ptr) {
                    ptr++;
                } 
                int tempValue = stackValue.pop();
                list.add(tempIdx, tempValue);

            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != list.indexOf(i)) {
                list.add(i, -1);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == list.indexOf(i)) {
                answer += 'O';
            } else {
                answer += 'X';
            }
        }

        
        return answer;
    }
}