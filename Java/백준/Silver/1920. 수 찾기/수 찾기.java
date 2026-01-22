import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        while(st2.hasMoreTokens()){
           int exist = 0;
           int num2 = Integer.parseInt(st2.nextToken());
           if(set.contains(num2)){
               exist = 1;
           }
           System.out.println(exist);
        }
    }    
}
