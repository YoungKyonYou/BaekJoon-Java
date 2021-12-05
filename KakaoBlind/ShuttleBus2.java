package KakaoBlind;


import java.util.*;

public class ShuttleBus2 {
    public static void main(String[] args) throws Exception {
        int n1 = 1;
        int t1 = 1;
        int m1 = 5;
        String[] timetable1 = { "08:00", "08:01", "08:02", "08:03" };

        int n2 = 2;
        int t2 = 10;
        int m2 = 2;
        String[] timetable2 = { "09:10", "09:09", "08:00" };

        int n3 = 2;
        int t3 = 1;
        int m3 = 2;
        String[] timetable3 = { "09:00", "09:00", "09:00", "09:00" };

        int n4 = 1;
        int t4 = 1;
        int m4 = 5;
        String[] timetable4 = { "00:01", "00:01", "00:01", "00:01", "00:01" };

        int n5 = 1;
        int t5 = 1;
        int m5 = 1;
        String[] timetable5 = { "23:59" };

        int n6 = 10;
        int t6 = 60;
        int m6 = 45;
        String[] timetable6 = { "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
                "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59" };
       // System.out.println(solution(n2, t2, m2, timetable2));
        // System.out.println(solution(n1, t1, m1, timetable1));
        // System.out.println(solution(n3, t3, m3, timetable3));
        // System.out.println(solution(n6, t6, m6, timetable6));
        // System.out.println(solution(n5, t5, m5, timetable5));
        assert solution(n1, t1, m1, timetable1).equals("09:00");
        assert solution(n2, t2, m2, timetable2).equals("09:09");
        assert solution(n3, t3, m3, timetable3).equals("08:59");
        assert solution(n4, t4, m4, timetable4).equals("00:00");
        assert solution(n5, t5, m5, timetable5).equals("09:00");
        assert solution(n6, t6, m6, timetable6).equals("18:00");

    }

    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.sort(timetable);
        int s = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < timetable.length; i++) {
            int hour = Integer.parseInt(timetable[i].substring(0, 2));
            int min = Integer.parseInt(timetable[i].substring(3, 5));
            int time = hour * 60 + min;
            pq.add(time);
        }
        int ans = 0;
        int busTime=540;
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
            while (!pq.isEmpty()) {
                int crew = pq.poll();
                if (crew <= busTime && list[i].size() < m) {
                    list[i].add(crew);

                } else {
                    pq.add(crew);
                    break;
                }
                ans = crew - 1;
            }
            busTime += t;

        }
        if (list[n - 1].size() < m) {
            ans = busTime - t;
        }
        String hh = String.format("%02d", ans / 60);
        String mm = String.format("%02d", ans % 60);
        return hh+":"+mm;
    }
}