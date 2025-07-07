import java.util.*;

class Solution {
    static boolean[] visited;
    static Set<Integer> permSet = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        String[] strArray = numbers.split("");
        visited = new boolean[strArray.length];

        for (int i = 1; i <= numbers.length(); i++) {
            permutation(strArray, "", i);
        }

        for (int number : permSet) {
            if (isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }

    static void permutation(String[] strArray, String current, int r) {
        if (current.length() == r) {
            permSet.add(Integer.parseInt(current));
            return;
        }

        for (int i = 0; i < strArray.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(strArray, current + strArray[i], r);
                visited[i] = false;
            }
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
