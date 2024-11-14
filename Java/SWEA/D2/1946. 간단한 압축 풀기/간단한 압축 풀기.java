import java.util.*;
import java.util.Scanner;
import java.io.FileInputStream;

// Queue에 입력받은 알파벳들을 숫자에 맞게 집어넣는다. 
// 각 rows는 10개의 columns을 가질수있다. 
// 위 조건에 맞게 10개의 column에 알파벳을 큐에서 뺴서 출력하고 10개가 되면 다음줄에 이어서 큐에서 뺴서 출력한다.
class Solution
{
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			sc.nextLine();
			Queue<String> queue = new LinkedList<>();
			int letter_sum = 0;
			for(int i = 0; i < N; i++) {
				String[] letter = sc.nextLine().split(" ");
				int idx = 0;
				letter_sum += Integer.parseInt(letter[1]);
				while(idx < Integer.parseInt(letter[1])) {
					queue.offer(letter[0]);
					idx++;
				}
			}
			int rows = (letter_sum / 10) + 1;
            System.out.printf("#%d\n", test_case);
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < 10; j++) {
					if(queue.isEmpty()) {
						break;
					}
					System.out.print(queue.poll());	
				}
				
				System.out.println();
			}
			
			
		}
	}

}