package KakaoBlind;
import java.util.*;
public class  JewelryShopping{
    public static void main(String[] args) throws Exception {
        String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
        String[] gems2 = { "AA", "AB", "AC", "AA", "AC" };
        int[] arr = solution(gems2);
        System.out.println(arr[0] + " " + arr[1]);
    }

    public static int[] solution(String[] gems) {
        int[] ans = new int[2];
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        int start = 0;
        int end = Integer.MAX_VALUE;
        int sp = 0;
        for (int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        int total=set.size();
        for (int i = 0; i < gems.length; i++) {
            queue.add(gems[i]);
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            while (map.get(queue.peek()) > 1) {
                sp++;
                String temp = queue.poll();
                map.put(temp, map.get(temp)-1);
            }
            if (map.size() == total && queue.size() < end) {
                start = sp + 1;
                end = queue.size();
            }
        }
        ans[0] = start ;
        ans[1] = start+end-1 ;
        return ans;
    }
}