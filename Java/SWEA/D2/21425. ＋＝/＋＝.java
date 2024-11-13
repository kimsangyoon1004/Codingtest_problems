
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
			int A = sc.nextInt();
			int B = sc.nextInt();
			int tempA = A;
			int tempB = B;
			int N = sc.nextInt();
			int count = 0;
           
		while (A <= N && B <= N) {
                if (A > B) {
                    B += A;
                } else {
                    A += B;
                }
                count++;
            }
			System.out.println(count);	
	}
		
	}
}