import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        
        TreeMap<Integer, Integer> dpq = new TreeMap<>();
        for(int i = 0; i < operations.length; i++){
            String[] values = operations[i].split(" ");
            String operation = values[0];
            int value = Integer.parseInt(values[1]);
            if(operation.equals("I")){
                dpq.put(value, dpq.getOrDefault(value, 0) + 1);
            }
           else if(operation.equals("D") && value == 1){
                if(!dpq.isEmpty()) {
                    int max = dpq.lastKey();
                    dpq.put(max, dpq.get(max) - 1);
                    if(dpq.get(max) == 0){
                        dpq.remove(max);
                    }
                }
            }
            else if(operation.equals("D") && value == -1){
                if(!dpq.isEmpty()) {
                    int min = dpq.firstKey();
                    dpq.put(min, dpq.get(min) - 1);
                    if(dpq.get(min) == 0){
                        dpq.remove(min);
                    }
                }
            }
        }
        if(dpq.size() == 0){
            return new int[]{0, 0};
        }
        else{
            return new int[]{dpq.lastKey(), dpq.firstKey()};
        }
        
        
        
    }
}