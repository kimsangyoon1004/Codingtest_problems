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
			ArrayList<Integer> blocks = new ArrayList<>();
			int high = 0;
			int low = 0;
			for(int i = 0; i < N; i++) {
				int number = sc.nextInt();
				blocks.add(number);
			}
			int index = 0;
			while(index + 1 < N) {
				if(blocks.get(index + 1) > blocks.get(index)) {
					if(blocks.get(index + 1) - blocks.get(index) > high) {
						high = blocks.get(index + 1) - blocks.get(index);
					}
				}
				else if(blocks.get(index + 1) < blocks.get(index)){
					if(Math.abs(blocks.get(index + 1) - blocks.get(index)) > low) {
						low = Math.abs(blocks.get(index + 1) - blocks.get(index));
					}
				}
				index++;
			}
			System.out.printf("#%d %d %d\n", test_case, high, low);
		}
	}
}