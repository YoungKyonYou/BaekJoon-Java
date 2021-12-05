package DevOps;

import java.util.*;

public class MultiLevel {
    public static void main(String[] args) throws Exception {
        String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
        String[] enroll2 = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
        String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
        String[] referral2 = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
        String[] seller = { "young", "john", "tod", "emily", "mary" };
        String[] seller2 = { "sam", "emily", "jaimie", "edward"};
        int[] amount = { 12, 4, 2, 5, 10 };
        int[] amount2 = { 2, 3, 5, 4 };
        int[] results = solution(enroll2, referral2, seller2, amount2);
        for (int a : results) {
            System.out.print(a + " ");
        }
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, LinkedList<String>> relation = new HashMap<>();
        HashMap<String, Integer> benefit = new HashMap<>();
        int each = 100;
        int[] result = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            if (!referral[i].equals("-")) {
                if (relation.containsKey(referral[i])) {
                    LinkedList<String> enrollList = new LinkedList<>();
                    LinkedList<String> temp = relation.get(referral[i]);
                    for (String s : temp) {
                        enrollList.addFirst(s);
                    }
                    enrollList.addFirst(referral[i]);
                    relation.put(enroll[i], enrollList);
                } else {
                    LinkedList<String> temp = new LinkedList<>();
                    temp.addFirst(referral[i]);
                    relation.put(enroll[i], temp);
                }
            } else {
                LinkedList<String> temp = new LinkedList<>();
                relation.put(enroll[i], temp);
            }
            benefit.put(enroll[i], 0);
        }
        for (int i = 0; i < seller.length; i++) {
            LinkedList<String> people = relation.get(seller[i]);
            int total = each * amount[i];
            int profit = (int) Math.round(total * 0.9);
            benefit.put(seller[i], profit + benefit.get(seller[i]));
            total = total - profit;
            for (int j = 0; j < people.size(); j++) {
                int tempProfit = benefit.get(people.get(j));
                benefit.put(people.get(j), (int) (Math.round(total * 0.9)) + tempProfit);
                total = total - (int) Math.round(total * 0.9);
            }
        }
        for (int i = 0; i < enroll.length; i++) {
            result[i] = benefit.get(enroll[i]);
        }

        return result;
    }
}