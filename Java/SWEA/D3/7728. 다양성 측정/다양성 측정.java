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
			String number = sc.nextLine();
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i = 0; i < number.length(); i++) {
				Integer key = number.charAt(i) - '0';
				map.put(key, 1);
			}
			System.out.printf("#%d %d\n",  test_case, map.size());

		}
	}
}