import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a,b) -> {
            return Integer.compare(a[1], b[1]); // {[-20,-15], [-18,-13], [-14,-5], [-5,-3]}
        });
        int count = 0;
        int beforeCamera = Integer.MIN_VALUE;
        for(int[] route : routes){
            if(route[0] > beforeCamera){
                beforeCamera = route[1];
                count++;
            }
        }
        return count;
    }
}