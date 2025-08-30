import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for (int i = 0, j = B.length - 1; i < A.length && j >= 0; i++, j--) {
            sum += A[i] * B[j];
        }
        

        return sum;
    }
}