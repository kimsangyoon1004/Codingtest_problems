import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = -1;
        Arrays.sort(A);         // 1,3,5,7
        Arrays.sort(B);         // 2,2,6,8
        int aIndex = 0;
        int bIndex = 0;
        int win = 0;
        while(aIndex < A.length && bIndex < B.length){
            if(B[bIndex] > A[aIndex]){
                win++;
                aIndex++;
            }
            bIndex++;
        }
        return win;
    }
}