package NTech;

import java.util.*;
import java.time.*;
import java.text.SimpleDateFormat;

public class Problem {
    public static void main(String[] args) throws Exception {
        String join_date = "2019/12/01 SUN";
        String join_date2 = "2019/12/01 SUN";
        String join_date3 = "2019/11/21 SUN";
        String resign_date = "2019/12/31";
        String resign_date2 = "2020/03/02";
        String resign_date3 = "2019/11/21";
        String[] holidays = { "12/25" };
        String[] holidays2 = { "01/02", "12/24", "03/01" };
        String[] holidays3 = { "12/23" };
        System.out.println(solution(join_date, resign_date, holidays));
    }

    public static int solution(String join_date, String resign_date, String[] holidays) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < holidays.length; i++) {
            map.put(holidays[i], 1);
        }
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy/MM/dd");
        String[] tempJoin = join_date.split("/");
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(tempJoin[0]), Integer.parseInt(tempJoin[1]) - 1,
                Integer.parseInt(tempJoin[2].substring(0, 2)) - 1);
        answer = 0;
        while (true) {
            cal.add(Calendar.DATE, 1);
            if (!map.containsKey(sdformat.format(cal.getTime()).substring(5, 10))) {
                if (!(cal.get(Calendar.DAY_OF_WEEK) == 1 || cal.get(Calendar.DAY_OF_WEEK) == 7)) {
                    answer++;
                }
            }
            if (sdformat.format(cal.getTime()).equals(resign_date))
                break;
        }
        return answer;
    }
}