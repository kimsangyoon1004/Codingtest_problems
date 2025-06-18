class Solution {
    // sliding window
    public int solution(int n) {
        int answer = 0;
        int left = 1;
        int right = 1;
        int sum = 1;
        while(left <= n){
            if(sum == n){
                answer++;
                sum -= left;
                left++;
            }
            else if(sum < n){
                right++;
                sum += right;
            }
            // sum > n
            else{
               sum -= left; 
               left++;
            }
        }
        
        return answer;
    }
}