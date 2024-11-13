import java.util.*;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int number = N - M + 1;
			int[] numarr = new int[number * number];
			int [][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int index = 0;
			for(int i = 0; i < number; i++) {
				for(int j = 0; j < number; j++) {
					int sum = 0;
					for(int m = 0; m < M; m++) {
						for(int k = 0; k < M; k++) {
							sum += map[i + m][j + k];
						}
					}
					numarr[index++] = sum;
				}
			}
		
			Arrays.sort(numarr);
			
			System.out.printf("#%d %d\n", test_case, numarr[number * number - 1]);
			
		}
	}
}