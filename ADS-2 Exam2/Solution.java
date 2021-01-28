import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {

	private static class Edge implements Comparable<Edge> {
		int to, wght;
		public Edge(int to, int wght) {
            this.to = to; this.wght = wght;
        }
		public int compareTo(Edge e) { 
            return this.wght-e.wght; 
        }
	}
	
	public static void main (String [] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int testCase = 1;
		while (true) {
			int N = s.nextInt();
			if (N == 0) break;
            int [][] adjMat = new int [N][N];
            //taking input for vertex 
			for (int i = 0; i < N; i++) for (int i2 = 0; i2 < N; i2++) adjMat[i][i2] = Integer.MAX_VALUE;
			//taking input for delays for that route 
			for (int i = 0; i < N; i++) {
				int C = s.nextInt();
				for (int c = 0; c < C; c++) adjMat[i][s.nextInt() - 1] = s.nextInt();
			}
			
			int src = s.nextInt() - 1;
			int to = s.nextInt() - 1;
			int [] dist = new int [N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[src] = 0;
			
			int [] parent = new int [N];
			for (int n = 0; n < N; n++) parent[n] = n;
			
			PriorityQueue<Edge> queue = new PriorityQueue<>();
			queue.offer(new Edge(src,0));
			while (!queue.isEmpty()) {
				Edge e = queue.poll();
				if (e.to == to) break;
				for (int i = 0; i < N; i++) if (adjMat[e.to][i] != Integer.MAX_VALUE) {
					int wght = e.wght + adjMat[e.to][i];
					if (dist[i] > wght) {
						dist[i] = wght;
						parent[i] = e.to;
						queue.offer(new Edge(i, wght));
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			int curr = to;
			do {
				StringBuilder sb2 = new StringBuilder();
				sb2.append(' ');
				sb2.append(curr + 1);
				sb2.append(sb.toString());
				sb = sb2;
				curr=parent[curr];
			} while (curr != parent[curr]);
			
			System.out.printf("Case %d: Path = %d%s; %d second delay\n", testCase++, src+1, sb.toString(), dist[to]);
        }
        s.close();
	}
}
