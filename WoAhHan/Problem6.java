package WoAhHan;

import java.util.*;

public class Problem6 {
    public static void main(String[] args) throws Exception {
        int N = 0;
        int M = 0;
        double time = 3.5;
        String[][] plans = { { "홍콩", "11PM", "9AM" }, { "엘에이", "3PM", "2PM" } };
        int[] arr = {};
        String[] str = {};

        System.out.println(solution(time, plans));
    }

    public static String solution(double time, String[][] plans) {
        double goMon = 1;
        double goFri = 9.5;
        double leaveFri = 6;
        double leaveMon = 6;
        for (int i = 0; i < plans.length; i++) {
            String dayS = plans[i][1].substring(plans[i][1].length() - 2, plans[i][1].length());
            double travelS = Double.parseDouble(plans[i][1].substring(0, plans[i][1].length() - 2));

            String dayE = plans[i][2].substring(plans[i][2].length() - 2, plans[i][2].length());
            double travelE = Double.parseDouble(plans[i][2].substring(0, plans[i][2].length() - 2));

            // 출발 정보
            if (dayS.equals("PM")) {
                if (leaveFri > travelS) {
                    double d = leaveFri - travelS;
                    time -= d;
                } 
            } else if (dayS.equals("AM")) {
                if (travelS < goFri) {
                    double d = 8.5;
                    time -= d;
                } else {
                    double d = 12 - travelS;
                    time -= d;
                }
            }
            if (time <= 0) {
                if (i - 1 < 0) {
                    return "호치민";
                }
                return plans[i - 1][0];
            }

            // 도착 정보
            // 월요일 도착
            if (dayE.equals("PM")) {
                if (goMon < travelE && travelE<leaveMon) {
                    double d = travelE - goMon;
                    time -= d;
                } else if (goMon < travelE && travelE > leaveMon) {
                    double d = 6;
                    time -= d;
                }
            } 
            if (time <= 0) {
                if (i - 1 < 0) {
                    return "호치민";
                }
                return plans[i - 1][0];
            }
        }
        
        return "호치민";
    }

    public static void printArrTwo(int[][] arr) {
        for (int[] a : arr) {
            System.out.print(Arrays.toString(a) + " ");
        }
        System.out.println();
    }

    public static void printArrOne(int[] arr) {
        System.out.println(Arrays.toString(arr) + " ");
        System.out.println();
    }

    public static void printList(List<Integer> list) {
        for (int a : list) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void printMap(HashMap<Integer, Integer> map) {
        for (Integer a : map.keySet()) {
            System.out.println("key: " + a + " value:" + map.get(a));
        }
        System.out.println();
    }
}