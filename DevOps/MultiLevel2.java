package DevOps;

import java.util.HashMap;

public class MultiLevel2 {
    //시간초과!
    public static void main(String[] args) throws Exception {
        String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
        String[] enroll2 = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
        String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
        String[] referral2 = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
        String[] seller = { "young", "john", "tod", "emily", "mary" };
        String[] seller2 = { "sam", "emily", "jaimie", "edward"};
        int[] amount = { 12, 4, 2, 5, 10 };
        int[] amount2 = { 2, 3, 5, 4 };
        int[] results = solution(enroll, referral, seller, amount);
        for (int a : results) {
            System.out.print(a + " ");
        }
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] result = new int[enroll.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
        }
        for (int i = 0; i < amount.length; i++) {
            String currentSeller = seller[i];
            int total = amount[i] * 100;
            while(!currentSeller.equals("-") && total!=0){
                int idx = map.get(currentSeller);
                double interest = (total * 0.1);
                result[idx] += (total - (int) interest);
                total = (int) interest;
                currentSeller = referral[idx];
            }
        }
        /*for (int i = 0; i < amount.length; i++) {
            String currentSeller = seller[i];
            int total = amount[i] * 100;
            int idx = 0;
            while (!currentSeller.equals("-")) {
                for (int j = 0; j < enroll.length; j++) {
                    if (enroll[j].equals(currentSeller)) {
                        idx = j;
                        break;
                    }
                }
                double interest=(total*0.1);
                result[idx]+= (total - (int) interest);
                total = (int) interest;
                currentSeller = referral[idx];
            }
        }*/

        return result;
    }
}