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
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] sumarray = new int[N];
			int sum = 0;
			int count = 0;
			double average = 0.0;
			for(int i = 0; i < N; i++) {
				int num = sc.nextInt();
				sumarray[i] = num;
				sum += num;
			}
			average = (double) sum / N;
			for(int number: sumarray) {
				if(number <= average) {
					count++;
				}
			}
			System.out.printf("#%d %d\n", test_case, count);
		}
	}
}