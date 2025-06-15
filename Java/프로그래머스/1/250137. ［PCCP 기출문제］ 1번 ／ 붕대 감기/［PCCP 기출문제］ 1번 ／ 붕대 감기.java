class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int lastAttackTime = attacks[attacks.length - 1][0];
        int[] attackTime = new int[lastAttackTime + 1];

        int chargeTime = bandage[0];
        int recoveryPerTime = bandage[1];
        int extraRecovery = bandage[2];

        int currentContinuousRecovery = 0;
        int currentHealth = health;

        // time index
        for (int[] attack : attacks) {
            attackTime[attack[0]] = attack[1];
        }

        for (int t = 0; t <= lastAttackTime; t++) {
            // attack
            if (attackTime[t] > 0) {
                currentContinuousRecovery = 0;  
                currentHealth -= attackTime[t]; 

                if (currentHealth <= 0){
                    return -1;
                } 
            }
            // no attack
            else {
                currentContinuousRecovery++;
                currentHealth += recoveryPerTime;
                if (currentContinuousRecovery == chargeTime) {
                    currentHealth += extraRecovery;
                    currentContinuousRecovery = 0;
                }

                if (currentHealth > health) {
                    currentHealth = health;
                }
            }
        }

        return currentHealth;
    }
}
