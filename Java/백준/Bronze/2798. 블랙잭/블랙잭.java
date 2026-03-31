import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for(int i = 0; i < N - 2; i++){
            for(int j = i + 1; j < N - 1; j++){
                for(int k = j + 1; k < N; k++){
                    sum = cards[i] + cards[j] + cards[k];
                    
                    if(sum <= M && sum > max){
                        max = sum;
                    }
                }
            }
        }
        
        System.out.println(max);
        
       
    }
    
    
    
}