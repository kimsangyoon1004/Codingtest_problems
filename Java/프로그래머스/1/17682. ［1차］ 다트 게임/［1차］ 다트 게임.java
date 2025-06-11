import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int start = 0;
        List<Integer> list = new ArrayList<>();
        String D;
        String S;
        String T;
        int d;
        int s;
        int t;
        int listindex = -1;
        for(int i = 0; i < dartResult.length(); i++){
            if(dartResult.charAt(i) == 'D'){
                D = dartResult.substring(start, i);
                d = Integer.parseInt(D);
                int Dpow = (int)Math.pow(d, 2);
                list.add(Dpow);
                listindex++;
                start = i + 1;
            }
            else if(dartResult.charAt(i) == 'S'){
                S = dartResult.substring(start, i);
                s = Integer.parseInt(S);
                int Spow = (int)Math.pow(s, 1);
                list.add(Spow);
                listindex++;
                start = i + 1;
            }
            else if(dartResult.charAt(i) == 'T'){
                T = dartResult.substring(start, i);
                t = Integer.parseInt(T);
                int Tpow = (int)Math.pow(t, 3);
                list.add(Tpow);
                listindex++;
                start = i + 1;
            }
            else if(dartResult.charAt(i) == '*'){
                if(listindex == 0){
                    list.set(listindex, list.get(listindex) * 2);
                }
                else{
                    list.set(listindex - 1, list.get(listindex - 1) * 2);
                    list.set(listindex, list.get(listindex) * 2);
                }
                start = i + 1;
            }
            else if(dartResult.charAt(i) == '#'){
                list.set(listindex, list.get(listindex) * (-1));
                start = i + 1;
            }
        }
        for(int a : list){
            answer += a;
        }
        return answer;
    }
}