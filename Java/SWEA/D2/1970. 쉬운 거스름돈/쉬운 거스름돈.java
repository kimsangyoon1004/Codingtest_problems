
import java.util.Scanner;
import java.io.FileInputStream;

// 돈을 제일 최소로 거슬러줘야한다. 그러기 위해선 그리디 알고리즘을 사용할 수 있다. 
// 돈을 리스트에 있는 돈의 종류중에 최대로 나눌수 있는 돈의 종류로 나누어주고 그 돈의 종류당 몫을 저장하고 나머지를 가지고 나머지 돈의 종류로 나누어준다.
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] moneylist = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int[] answer = new int[moneylist.length];
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int division = 0;
			int remainder = 0;
			String moneystr = "";
			for(int i = 0; i < moneylist.length; i++) {
				division = N / moneylist[i];
				remainder = N % moneylist[i];
				N = remainder;
				answer[i] = division;
				moneystr += answer[i] + " ";
			}
			
			System.out.println("#" + test_case);
			System.out.println(moneystr);	
		}
	
	}
}