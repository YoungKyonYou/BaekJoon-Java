package NTech;

import java.util.*;
import java.time.*;
import java.text.SimpleDateFormat;

public class Problem2 {
    public static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) throws Exception {
        String join_date = "2019/12/01 SUN";
        String join_date2 = "2019/12/01 SUN";
        String join_date3 = "2019/11/21 THU";
        String resign_date = "2019/12/31";
        String resign_date2 = "2020/03/02";
        String resign_date3 = "2019/11/21";
        String[] holidays = { "12/25" };
        String[] holidays2 = { "01/02", "12/24", "03/01" };
        String[] holidays3 = { "12/23" };
        System.out.println(solution(join_date, resign_date, holidays));
    }

    public static void year(int year) {
        if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
            days[2] = 29;
        } else {
            days[2] = 28;
        }
    }

    public static int dayInt(String str) {
        switch (str) {
            case "MON":
                return 1;
            case "TUE":
                return 2;
            case "WED":
                return 3;
            case "THU":
                return 4;
            case "FRI":
                return 5;
            case "SAT":
                return 6;
            case "SUN":
                return 7;
            default:
                return 0;
        }
    }

    public static int solution(String join_date, String resign_date, String[] holidays) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < holidays.length; i++) {
            map.put(holidays[i], 1);
        }
        String[] tempJoin = join_date.split("/");
        String[] tempResign=resign_date.split("/");
        int sYear = Integer.parseInt(tempJoin[0]);
        int sMonth = Integer.parseInt(tempJoin[1]);
        int sDay = Integer.parseInt(tempJoin[2].substring(0, 2));
        int eYear = Integer.parseInt(tempResign[0]);
        int eMonth = Integer.parseInt(tempResign[1]);
        int eDay = Integer.parseInt(tempResign[2]);
        int idx=dayInt(tempJoin[2].substring(3,6));
        
        for (int i = sYear; i <= eYear; i++) {
            year(i);
            if (i != eYear) {
                for (int j = sMonth; j <= 12; j++) {
                    for (int k = sDay; k <= days[sMonth]; k++) {
                        idx=((idx-1)%7)+1;
                        String str = String.format("%02d", j) + "/" + String.format("%02d", k);
                        if (idx != 6 && idx != 7 && !map.containsKey(str)) {
                            answer++;
                            System.out.println(str+" idx:"+idx);
                        }
                        idx++;
                    }
                }
            } else if (i == eYear) {
                int start = sYear == eYear ? sMonth : 1;
                for (int j = start; j <= eMonth; j++) {
                    for (int k = sDay; k <= days[j]; k++) {
                        idx = ((idx - 1) % 7) + 1;
                        String str = String.format("%02d", j) + "/" + String.format("%02d", k);
                        if (idx != 6 && idx != 7 && !map.containsKey(str)) {
                            System.out.println(str+" idx:"+idx);
                            answer++;
                        }
                        if (j == eMonth && k == eDay) {
                            break;
                        }
                        idx++;
                    }
                }
            }
        }
        return answer;
    }
}