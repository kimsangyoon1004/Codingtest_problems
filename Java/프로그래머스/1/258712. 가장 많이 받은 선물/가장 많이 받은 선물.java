import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(friends[i], i);
        }

        //  giver → receiver → count
        Map<String, HashMap<String, Integer>> friendMap = new HashMap<>();
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];

            friendMap.putIfAbsent(giver, new HashMap<>());
            HashMap<String, Integer> receiveMap = friendMap.get(giver);
            receiveMap.put(receiver, receiveMap.getOrDefault(receiver, 0) + 1);
        }

         
        int[] giftScore = new int[n]; 

        for (int i = 0; i < n; i++) {
            String giver = friends[i];
            for (int j = 0; j < n; j++) {
                String receiver = friends[j];
                if (giver.equals(receiver)) continue;

                int give = friendMap.getOrDefault(giver, new HashMap<>()).getOrDefault(receiver, 0);
                int receive = friendMap.getOrDefault(receiver, new HashMap<>()).getOrDefault(giver, 0);

                giftScore[i] += give;
                giftScore[i] -= receive;
            }
        }

        
        int[] nextMonthGifts = new int[n];

        for (int i = 0; i < n; i++) {
            String a = friends[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                String b = friends[j];

                int aToB = friendMap.getOrDefault(a, new HashMap<>()).getOrDefault(b, 0);
                int bToA = friendMap.getOrDefault(b, new HashMap<>()).getOrDefault(a, 0);

                if (aToB > bToA) {
                    nextMonthGifts[i]++;
                } else if (aToB == bToA && giftScore[i] > giftScore[j]) {
                    nextMonthGifts[i]++;
                }
            }
        }

        
        int max = 0;
        for (int count : nextMonthGifts) {
            max = Math.max(max, count);
        }

        return max;
    }
}
