import java.util.*;
import java.io.FileInputStream;


class Solution
{
public static void main(String args[]) throws Exception{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();

		String [] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String day = sc.nextLine();
			int count = 0;
			String temp = day;
			if(day.equals("SUN")) {
				temp = "MON";
				count = 1;
			}
			else {
				temp = day;
				count = 0;
			}
			
			
			while(!temp.equals("SUN")) {
				count++;
				temp = days[Arrays.asList(days).indexOf(temp) + 1];
				
			}
			System.out.printf("#%d %d\n", test_case, count);
		}
	}
}