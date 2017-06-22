package Graph;

import java.util.HashSet;
import java.util.Set;

public class Prim {

	public static int prim(int[][] graph, int n) {
		boolean[] is_select = new boolean[n];
		is_select[0] = true;
		int sum = 0;
		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		for (int num = 0; num < n; num++) {
			int min = Integer.MAX_VALUE;
			int pos = -1;
			for (int i : set) {

				for (int j = 0; j < n; j++) {
					if (is_select[j]) {
						continue;
					}
					if (min > graph[i][j]) {
						min = graph[i][j];
						pos = j;
					}
				}
			}
			if (pos < 0) {
				break;
			}
			set.add(pos);
			is_select[pos] = true;
			sum += min;
		}
		return sum;
	}
}
