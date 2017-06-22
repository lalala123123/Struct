package Main;

import java.util.Comparator;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int[][] graph = new int[n][n];
//		for(int i = 0;i<n;i++){
//			for(int j = 0;j<n;j++){
//				graph[i][j] = sc.nextInt();
//			}
//		}
//		System.out.println(prim(graph, n));
		int m = sc.nextInt();
		Node[] graph = new Node[m];
		for(int i = 0;i<m;i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int dis = sc.nextInt();
			graph[i] = new Node(a,b,dis);
		}
		System.out.println(kruscal(graph, n));
	}

	public static class Node {
		int a;
		int b;
		int dis;

		public Node(int a, int b, int dis) {
			this.a = a>b?a:b;
			this.b = a>b?b:a;
			this.dis = dis;
		}
	}

	public class Comp implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o1.dis > o2.dis ? 1 : -1;
		}

	}

	public static int kruscal(Node[] graph, int n) {
		int sum = 0;
		for (int i = 0; i < n-1; i++) {
			int min = Integer.MAX_VALUE;
			int min_pos = -1;
			for (int j = 0; j < graph.length; j++) {
				if(graph[j].a != graph[j].b && min > graph[j].dis){
					min_pos = j;
					min = graph[j].dis;
				}
			}
			if(min_pos != -1)
			for (int j = 0; j < graph.length; j++) {
				if(graph[j].a == graph[min_pos].b){
					graph[j].a = graph[min_pos].a;
				}
				if(graph[j].b == graph[min_pos].b){
					graph[j].b = graph[min_pos].a;
				}
				if(graph[j].a < graph[j].b){
					int t = graph[j].a;
					graph[j].a = graph[j].b;
					graph[j].b = graph[j].a;
				}
			}
			sum += min;
		}
		return sum;
	}
}
