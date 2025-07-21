class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long result = countDots(k, d);
        return result;
    }

    public static long countDots(int k, int d) {
        long count = 0;

        for (int x = 0; x <= d; x += k) {
            
            double maxY = Math.sqrt((long)d * d - (long)x * x);
            count += (long)(maxY / k) + 1; 
        }

        return count;
    }
}