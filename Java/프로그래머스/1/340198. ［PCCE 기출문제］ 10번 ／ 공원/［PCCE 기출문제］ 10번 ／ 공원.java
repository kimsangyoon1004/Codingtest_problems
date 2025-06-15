import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats); 
        int answer = -1;

        
        for (int m = mats.length - 1; m >= 0; m--) {
            int size = mats[m];
            boolean canPlace = false;

            
            for (int i = 0; i <= park.length - size; i++) {
                for (int j = 0; j <= park[0].length - size; j++) {
                    boolean ok = true;

                    
                    for (int x = i; x < i + size; x++) {
                        for (int y = j; y < j + size; y++) {
                            if (!park[x][y].equals("-1")) {
                                ok = false;
                                break;
                            }
                        }
                        if (!ok) break;
                    }

                    if (ok) {
                        canPlace = true;
                        break;
                    }
                }
                if (canPlace) break;
            }

            if (canPlace) {
                answer = size;
                break;
            }
        }

        return answer;
    }
}
