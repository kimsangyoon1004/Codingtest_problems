import java.util.*;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"}; 
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();
			Double[] totalscore = new Double[N];
			for(int i = 0; i < N; i++) {
				int mid_test = sc.nextInt();
				int final_test = sc.nextInt();
				int homework = sc.nextInt();
				totalscore[i] = (mid_test * 0.35) + (final_test * 0.45) + (homework * 0.2);
			}
			
			Double temp = totalscore[K - 1];
			Arrays.sort(totalscore, Collections.reverseOrder());
			int rank = Arrays.asList(totalscore).indexOf(temp);
			String answer = grade[rank / (N / 10)];
			System.out.printf("#%d %s\n", test_case, answer);
		}
	}
}