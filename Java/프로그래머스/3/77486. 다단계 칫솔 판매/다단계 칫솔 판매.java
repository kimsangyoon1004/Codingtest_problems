import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> profit = new HashMap<>();

       
        for (int i = 0; i < n; i++) {
            parent.put(enroll[i], referral[i]);
            profit.put(enroll[i], 0); 
        }

        
        for (int i = 0; i < seller.length; i++) {
            String cur = seller[i];
            int money = amount[i] * 100;

            while (!cur.equals("-") && money > 0) {
                int give = money / 10;
                int keep = money - give;

                profit.put(cur, profit.get(cur) + keep);
                cur = parent.get(cur);
                money = give;
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = profit.get(enroll[i]);
        }

        return answer;
    }
}
