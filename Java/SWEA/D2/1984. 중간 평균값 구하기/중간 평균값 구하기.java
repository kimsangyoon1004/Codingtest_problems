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
		sc.nextLine();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			ArrayList<Integer> number = new ArrayList<>();
			for(int i = 0; i < 10; i++) {
				number.add(sc.nextInt());
			}
			int max = 0;
			int min = 100000;
			for(int j = 0; j < 10; j++) {
				if(max < number.get(j)) {
					max = number.get(j);
				}
				if(min > number.get(j)) {
					min = number.get(j);
				}
			}

			number.removeAll(Arrays.asList(Integer.valueOf(max)));
			number.removeAll(Arrays.asList(Integer.valueOf(min)));
			number.removeAll(Arrays.asList(Integer.valueOf(max)));
			number.removeAll(Arrays.asList(Integer.valueOf(min)));
			double average;
			int sum = 0;
			for(int a:number) {
				sum += a;
			}
			average = (double) sum / number.size();
			System.out.printf("#%d %.0f\n", test_case, average);
		}
	}
}