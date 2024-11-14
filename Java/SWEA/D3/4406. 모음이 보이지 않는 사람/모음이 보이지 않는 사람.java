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
		String [] aeiou = {"a", "e", "i", "o", "u"};

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String sentence = sc.nextLine();
			
			for(int i = 0; i < aeiou.length; i++) {
				sentence = sentence.replace(aeiou[i], "");
			}
			System.out.printf("#%d %s\n", test_case, sentence);
		}
	}
}