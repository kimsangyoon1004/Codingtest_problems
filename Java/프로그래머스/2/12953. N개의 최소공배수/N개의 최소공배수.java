class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++){
            answer = LCM(answer,arr[i]);
        }
        return answer;
    }
    // 최대공약수
    static int GCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    // 최소공배수
    static int LCM(int a, int b){
        return a / GCD(a, b) * b;
    }
    
}