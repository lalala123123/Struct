package Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Dijstra {

	public static int dijstra() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt() - 1;
		int t = sc.nextInt() - 1;
		int[][] dis = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dis[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int d = sc.nextInt();
			dis[a][b] = Math.min(d, dis[a][b]);
			dis[b][a] = Math.min(d, dis[b][a]);
		}
		int[] distanse = new int[n];
		for (int i = 0; i < n; i++) {
			distanse[i] = dis[s][i];
		}
		distanse[s] = 0;
		boolean[] is_find = new boolean[n];
		is_find[s] = true;
		for (int a = 0; a < n; a++) {
			for (int i = 0; i < n; i++) {
				if (!is_find[i]) {
					continue;
				}
				int min = Integer.MAX_VALUE;
				int min_pos = -1;
				for (int j = 0; j < n; j++) {
					if (i == j) {
						continue;
					}
					if (dis[i][j] < Integer.MAX_VALUE && min > distanse[i] + dis[i][j]) {
						min = distanse[i] + dis[i][j];
						min_pos = j;
					}
				}
				if (min_pos == -1) {
					break;
				}
				is_find[min_pos] = true;
				distanse[min_pos] = min;
				if (min_pos == t) {
					break;
				}
			}
		}
		return distanse[t];
	}
}
