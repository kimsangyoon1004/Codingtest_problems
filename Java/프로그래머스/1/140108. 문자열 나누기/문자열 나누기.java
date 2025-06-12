class Solution {
    static int count;
    public int solution(String s) {
        count = 0;
        dfs(s);
        return count;
    }

    static void dfs(String word) {
        if(word.length() == 0){
            return;
        }

        int same = 1;
        int diff = 0;
        char first = word.charAt(0);

        for(int i = 1; i < word.length(); i++) {
            if(word.charAt(i) == first) same++;
            else diff++;

            if(same == diff) {
                count++;
                dfs(word.substring(i + 1));
                return;
            }
        }

        
        count++;
    }
}
