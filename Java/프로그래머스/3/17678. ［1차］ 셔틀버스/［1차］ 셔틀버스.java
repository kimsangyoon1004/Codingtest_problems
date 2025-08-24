import java.util.*;
class Solution {    
    public String solution(int n, int t, int m, String[] timetable) {
        int[] crew = Arrays.stream(timetable)
                           .mapToInt(Solution::timeToMinute)
                           .sorted()
                           .toArray();
        int busTime = 540; // 09:00
        int idx = 0;
        int answer = 0;
        for(int i = 0; i < n; i++){
            int lastCrew = -1;
            int cnt = 0;
            
            while(cnt < m && idx < crew.length && crew[idx] <= busTime){
                lastCrew = crew[idx];
                idx++;
                cnt++;
            }
            
            if(cnt == m){
                answer = lastCrew - 1;
            }
            else{
                answer = busTime;
            }
            
            busTime += t;
        }
        
        return minuteToTime(answer);
    }
    static int timeToMinute(String times){
        String[] time = times.split(":");
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        int totalMin = hour * 60 + min;
        return totalMin;
    }
    static String minuteToTime(int times){
        int hour = times / 60;
        int min = times % 60;
        String time = String.format("%02d:%02d", hour, min);
        return time;
    }
}