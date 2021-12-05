package KakaoBlind;

import java.util.*;

public class IllegalUser2 {
    public static int ans = 0;

    public static void main(String[] args) throws Exception {
        String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] user_id2 = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] user_id3 = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] banned_id = { "fr*d*", "abc1**" };
        String[] banned_id2 = { "*rodo", "*rodo", "******" };
        String[] banned_id3 = { "fr*d*", "*rodo", "******", "******" };

        System.out.println(solution(user_id2, banned_id2));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        boolean[] visit = new boolean[user_id.length];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
        }
        dfs(user_id, banned_id, 0, visit, 0, set);
        return ans;
    }

    public static boolean duplicate(Set<String> set, String[] user_id, boolean[] visit) {
        String temp = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < user_id.length; i++) {
            if (visit[i]) {
                list.add(user_id[i]);
            }
        }
        Collections.sort(list);
        for (String s : list) {
            temp += s;
        }
        return set.add(temp);
    }

    public static void dfs(String[] user_id, String[] banned_id, int cnt, boolean[] visit, int s, Set<String> set) {
        if (cnt == banned_id.length) {
            if (duplicate(set, user_id, visit)) {
                ans++;
            }
            return;
        } else {
            for (int j = s; j < banned_id.length; j++) {
                for (int i = 0; i < user_id.length; i++) {
                    if (user_id[i].matches(banned_id[j]) && !visit[i]) {
                        visit[i] = true;
                        dfs(user_id, banned_id, cnt + 1, visit, j + 1, set);
                        visit[i] = false;
                    }
                }
            }
        }

    }
}