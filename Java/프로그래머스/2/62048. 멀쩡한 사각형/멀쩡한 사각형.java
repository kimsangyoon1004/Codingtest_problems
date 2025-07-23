class Solution {
    public long solution(int w, int h) {
        long W = w;
        long H = h;
        return W * H - (W + H - gcd(w, h));
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
