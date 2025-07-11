class Solution {
   public int solution(int[] arrayA, int[] arrayB) {
    int gcdA = arrayA[0];
    int gcdB = arrayB[0];
    
    for (int i = 1; i < arrayA.length; i++) {
        gcdA = gcd(gcdA, arrayA[i]);
        gcdB = gcd(gcdB, arrayB[i]);
    }

    int answer = 0;

    
    boolean validA = true;
    for (int b : arrayB) {
        if (b % gcdA == 0) {
            validA = false;
            break;
        }
    }
    if (validA) answer = Math.max(answer, gcdA);

   
    boolean validB = true;
    for (int a : arrayA) {
        if (a % gcdB == 0) {
            validB = false;
            break;
        }
    }
    if (validB) answer = Math.max(answer, gcdB);

    return answer;
 }
    static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
    }

}