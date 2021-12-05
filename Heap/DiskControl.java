package Heap;

import java.util.*;

public class DiskControl {

    public static void main(String[] args) throws Exception {
        int[][] jobs = { { 1, 3 }, { 1, 9 }, { 2, 6 } };
        int[][] jobs2 = { { 24, 10 }, { 28, 39 }, { 43, 20 }, { 37, 5 }, { 47, 22 }, { 20, 47 }, { 15, 34 }, { 15, 2 },
                { 35, 43 }, { 26, 1 } };
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int ans = 0;

        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        int idx = 0;
        int end = 0;
        int sum = 0;
        int count=0;
        while (count<jobs.length) {
            while (idx < jobs.length && jobs[idx][0]<=end ) {
                pq.add(jobs[idx++]);
            }
            if (pq.isEmpty()) {
                end=jobs[idx][0];
            }else{
                int[] temp=pq.poll();
                sum += (end + temp[1]) - temp[0];
                end += temp[1];
                count++;
            }
        }
        ans = (int) (sum / jobs.length);
        return ans;
    }

}