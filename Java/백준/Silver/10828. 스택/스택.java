

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            String[] operation = line.split(" ");

            switch (operation[0]) {
                case "push":
                    st.push(Integer.parseInt(operation[1]));
                    break;
                case "top":
                    System.out.println(st.isEmpty() ? -1 : st.peek());
                    break;
                case "pop":
                    System.out.println(st.isEmpty() ? -1 : st.pop());
                    break;
                case "size":
                    System.out.println(st.size());
                    break;
                case "empty":
                    System.out.println(st.isEmpty() ? 1 : 0);
                    break;
            }
        }
    }
}
