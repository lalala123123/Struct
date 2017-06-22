package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class SPFA {

	public static int spfa(ArrayList<Map<Integer, Integer>> graph, int n, int start, int end) {
		int[] dis = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		boolean[] is_inQueue = new boolean[n];
		is_inQueue[start] = true;
		while (queue.size() > 0) {
			int now = queue.pollFirst();
			is_inQueue[now] = false;
			for (Entry<Integer, Integer> m : graph.get(now).entrySet()) {
				if (dis[m.getKey()] > dis[now] + m.getValue()) {
					dis[m.getKey()] = dis[now] + m.getValue();
					if (!is_inQueue[m.getKey()]) {
						queue.add(m.getKey());
						is_inQueue[m.getKey()] = true;
					}
				}
			}
		}
		return dis[end];
	}
}
