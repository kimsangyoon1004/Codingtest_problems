import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    String[] vowel = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word) + 1;
    }

    public void dfs(String str, int depth) {
        if (depth > 5) return;
        if (!str.equals("")) list.add(str);

        for (int i = 0; i < 5; i++) {
            dfs(str + vowel[i], depth + 1);
        }
    }
}
