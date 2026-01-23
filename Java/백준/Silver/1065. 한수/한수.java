import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N < 100){
           System.out.println(N);
           return;
        }
        // 210
        int ans = 0;
        for(int i = 100; i <= N; i++){
           int a = i / 100;
           int b = (i / 10) % 10;
           int c = i % 10;
           if((a == b) && (b == c)){
               ans++;
               continue;
           }
           if((a - b) == (b - c)){
               ans++;
               continue;
           }
           if((c - b) == (b - a)){
               ans++;
           }
        }
        System.out.println(ans + 99);
    }
}