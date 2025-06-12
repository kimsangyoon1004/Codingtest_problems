class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] xdir = {1, 0, -1, 0};
        int[] ydir = {0, -1, 0, 1};
        String color = board[h][w];
        for(int i = 0; i < 4; i++){
            int nextx = h + xdir[i];
            int nexty = w + ydir[i];
            if(nextx >= 0 && nextx < board.length && nexty >= 0 && nexty < board[0].length){
                if(board[nextx][nexty].equals(color)){
                    answer++;
                }
            }
        }
        return answer;
    }
}