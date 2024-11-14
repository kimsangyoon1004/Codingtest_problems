import java.util.*;
import java.util.Scanner;
import java.io.FileInputStream;

// 맵에 1000명의 학생들의 점수를 넣는다.
// 만약 학생의 점수가 중복으로 들어가면 그 점수의 value값에 1을더해준다.
// 맵을 탐색하고 value값이 최대값인 key를 찾아서 출력해준다.
class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			HashMap<Integer, Integer> map = new HashMap<>();
			
			int row = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < 1000; i++) {
				Integer test = sc.nextInt();
				map.put(test, map.getOrDefault(test, 0) + 1);
			}
			
			int max = -100;
			Collection<Integer> values = map.values();
			
			for(Integer number : values) {
				if(number > max) {
					max = number;
				}
			}
			int answer = 0;
			Set<Integer> keySet = map.keySet();
			for(Integer key: keySet) {
				if(map.get(key) == max) {
					answer = key;
				}
			}
			System.out.printf("#%d %d\n", test_case, answer);
		

		}
	}
}