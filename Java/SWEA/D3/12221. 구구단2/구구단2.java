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
			int first = sc.nextInt();
			int second = sc.nextInt();
			int answer = 0;
			if(first > 9 || second > 9) {
				answer = -1;
			}
			else {
				answer = first * second;
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}