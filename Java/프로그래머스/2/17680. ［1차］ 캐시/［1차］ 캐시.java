import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;

       
        if (cacheSize == 0){
            return cities.length * 5;
        } 

        List<String> LRU = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            boolean isHit = false;

            if (LRU.contains(city)) {
                LRU.remove(city);
                LRU.add(city);
                isHit = true;
            } else {
                if (LRU.size() >= cacheSize) {
                    LRU.remove(0);
                }
                LRU.add(city);
                isHit = false;
            }

            if (isHit) {
                time += 1;
            } else {
                time += 5;
            }
        }

        return time;
    }
}
