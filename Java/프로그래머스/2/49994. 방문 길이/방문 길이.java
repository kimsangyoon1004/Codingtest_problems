import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 0;
        int y = 0;

        Set<String> visited = new HashSet<>();

        for (char dir : dirs.toCharArray()) {
            int nx = x;
            int ny = y;

            if (dir == 'U') ny++;
            else if (dir == 'D') ny--;
            else if (dir == 'L') nx--;
            else if (dir == 'R') nx++;

            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            String path1 = x + "," + y + "->" + nx + "," + ny;
            String path2 = nx + "," + ny + "->" + x + "," + y;
            
            if (!visited.contains(path1) && !visited.contains(path2)) {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }

            x = nx;
            y = ny;
        }

        return answer;
    }
}