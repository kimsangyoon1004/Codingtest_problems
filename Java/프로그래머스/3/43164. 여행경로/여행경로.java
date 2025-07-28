import java.util.*;

class Solution {
    List<String> path = new ArrayList<>();
    boolean[] visited;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));  
        dfs("ICN", "ICN", tickets, 0);
        return path.get(0).split(" ");
    }

    void dfs(String current, String route, String[][] tickets, int count) {
        if (count == tickets.length) {
            path.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;  
            }
        }
    }
}
