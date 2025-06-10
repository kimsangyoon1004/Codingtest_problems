import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
    int cnt = 0;
    int wMin = Math.min(wallet[0], wallet[1]);
    int wMax = Math.max(wallet[0], wallet[1]);
    int bMin = Math.min(bill[0], bill[1]);
    int bMax = Math.max(bill[0], bill[1]);

    while (bMax > wMax || bMin > wMin) {
        bMax /= 2;
        cnt++;

        if (bMax < bMin) {
            int tmp = bMax;
            bMax = bMin;
            bMin = tmp;
        }
    }

    return cnt;
}

    
   
}