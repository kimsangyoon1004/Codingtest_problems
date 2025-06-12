import java.util.*;
class Solution {
    // Use HashMap(type, score)
    // Comparator.sort
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        // pairs
        String[][] types = { {"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"} };

        
        Map<String, Integer> scores = new HashMap<>();
        
        
        int[] scoreTable = {0, 3, 2, 1, 0, 1, 2, 3};

        for (int i = 0; i < survey.length; i++) {
            String first = String.valueOf(survey[i].charAt(0));  // "A"
            String second = String.valueOf(survey[i].charAt(1)); // "N"
            int choice = choices[i];

            if (choice < 4) {
                scores.put(first, scores.getOrDefault(first, 0) + scoreTable[choice]);
            } else if (choice > 4) {
                scores.put(second, scores.getOrDefault(second, 0) + scoreTable[choice]);
            }
        }

        
        for (String[] pair : types) {
            String type1 = pair[0];
            String type2 = pair[1];
            int score1 = scores.getOrDefault(type1, 0);
            int score2 = scores.getOrDefault(type2, 0);
            
            // sort by alphabet
            
            if (score1 >= score2) {
                answer.append(type1);
            } else {
                answer.append(type2);
            }
        }
        return answer.toString();
    }
}
