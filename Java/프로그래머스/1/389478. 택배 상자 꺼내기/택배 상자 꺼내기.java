class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;

        int row = (num - 1) / w;           
        int lastColIndex = w - 1;          
        int col;

        
        if (row % 2 == 0) {
            // Even row: left to right
            col = (num - 1) % w;
        } else {
            // Odd row: right to left
            col = lastColIndex - (num - 1) % w;
        }

        
        int totalRows = (n + w - 1) / w; 
        for (int r = row; r < totalRows; r++) {
            int boxNumber;

            if (r % 2 == 0) {
                // Even row: left to right
                boxNumber = r * w + col + 1;
            } else {
                // Odd row: right to left
                boxNumber = r * w + (w - 1 - col) + 1;
            }

            if (boxNumber <= n) {
                answer++;
            }
        }

        return answer;
    }
}
