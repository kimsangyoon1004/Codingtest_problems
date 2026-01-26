import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> answer_list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> order_list = new ArrayList<>();
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                order_list.add(num);
                }
            answer_list.add(order_list);
        }
        Collections.sort(answer_list, (a, b) -> {
           if(a.get(0).equals(b.get(0))){
               return(Integer.compare(a.get(1), b.get(1)));
           }
           return(Integer.compare(a.get(0), b.get(0)));
        });
       for(List<Integer> list : answer_list){
           for(int num : list){
               System.out.print(num + " ");
           }
           System.out.println();
       }
        
    }
}