import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<Character> skillQueue = new LinkedList<>();
        for(int i = 0; i < skill.length(); i++){
            skillQueue.offer(skill.charAt(i));
        }
        for(int i = 0; i < skill_trees.length; i++){
            String eachSkill = skill_trees[i];
            boolean isSkill = true;
            for(int j = 0; j < eachSkill.length(); j++){
                if(skillQueue.contains(eachSkill.charAt(j))){
                    if(eachSkill.charAt(j) == skillQueue.peek()){
                        skillQueue.poll();
                    }
                    else{
                        isSkill = false;
                        break;
                    }
                }  
            }
            if(skillQueue.isEmpty() || isSkill){
                answer++;
            }
            skillQueue.clear();
            // init
            for(int k = 0; k < skill.length(); k++){
                skillQueue.offer(skill.charAt(k));
            }
        }
        return answer;
    }
}