public class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;

        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < n; i++) {
            int pulse1 = (i % 2 == 0) ? 1 : -1;
            int pulse2 = -pulse1;

            sum1 = Math.max(sequence[i] * pulse1, sum1 + sequence[i] * pulse1);
            sum2 = Math.max(sequence[i] * pulse2, sum2 + sequence[i] * pulse2);

            max1 = Math.max(max1, sum1);
            max2 = Math.max(max2, sum2);
        }

        return Math.max(max1, max2);
    }
}
