package Graph;

import java.util.Scanner;

public class Floyd {
	public static void start() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] graph = new int[n][n];
		for (int i = 0; i < n * n; i++) {
			graph[i / n][i % n] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < n; i++) {
			graph[i][i] = 0;
		}
		while (m-- != 0) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int d = sc.nextInt();
			graph[a][b] = Math.min(graph[a][b], d);
			graph[b][a] = Math.min(graph[b][a], d);
		}
		floyd(graph, n);
		for (int i = 0; i < n; i++) {
			String st = "";
			for (int j = 0; j < n; j++) {
				st += graph[i][j] + " ";
			}
			System.out.println(st);
		}
	}

	public static void floyd(int[][] dis, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (dis[i][k] < Integer.MAX_VALUE && dis[k][j] < Integer.MAX_VALUE)
						dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
				}
			}
		}
	}

}
