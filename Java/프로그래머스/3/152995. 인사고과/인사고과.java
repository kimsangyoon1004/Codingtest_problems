import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int[] wanHo = scores[0];
        int wanHoSum = wanHo[0] + wanHo[1];
        
        Arrays.sort(scores, (a,b) -> {
            if(a[0] != b[0]){
                return Integer.compare(b[0], a[0]);
            }
            else{
                return Integer.compare(a[1], b[1]);
            }
        });

        int maxPeer = 0;
        int rank = 1;
        boolean isWanHoDropped = false;
        
        for (int[] score : scores) {
            if (score[1] < maxPeer) {
                if (score == wanHo) {
                    isWanHoDropped = true;
                }
                continue;
            }

            maxPeer = Math.max(maxPeer, score[1]);
            if (score != wanHo && score[0] + score[1] > wanHoSum) {
                rank++;
            }
        }

        return isWanHoDropped ? -1 : rank;
    
    }
}