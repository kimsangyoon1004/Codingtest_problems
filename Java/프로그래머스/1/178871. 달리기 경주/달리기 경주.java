import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> nameToIndex = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            nameToIndex.put(players[i], i);
        }

        for (String name : callings) {
            int idx = nameToIndex.get(name);  
            if (idx == 0) continue;           
            String front = players[idx - 1];
            players[idx - 1] = name;
            players[idx] = front;
            nameToIndex.put(name, idx - 1);
            nameToIndex.put(front, idx);
        }

        return players;
    }
}
