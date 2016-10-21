
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	private int v;
	private LinkedList<Integer> ad[];
	private int[][] L; // matrix holding the shortest path
	private int[][] P; // matrix holding the predecessor

	Graph(int v) { //constructor
		this.v = v;
		ad = new LinkedList[v];
		L = new int[v][v];
		P = new int[v][v];
		for (int i = 0; i < v; i++) {
			ad[i] = new LinkedList();
			for (int j = 0; j < v; j++) {
				L[i][j] = -1;
				P[i][j] = -1;
			}
		}

	}

	void addEdge(int v, int w) {
		ad[v].add(w);
	}

	boolean checkEdge(int v, int w) {
		Iterator<Integer> i = ad[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (n == w) {
				return true;
			}
		}
		return false;
	}

	void genEdge(int n) {
		int r1, r2;
		for (int i = 0; i < n; i++) {
			do {
				// System.out.println("Assigning Edge " + i);
				r1 = (int) (v * Math.random());
				r2 = (int) (v * Math.random());
			} while (checkEdge(r1, r2) == true || r1 == r2);
			addEdge(r1, r2);
			addEdge(r2, r1);
			// System.out.println("Assigned Edge " + i);

		}
	}

	void printGraph() {
		for (int s = 0; s < this.v; s++) {
			printSpecGraph(s);
//			Iterator<Integer> i = ad[s].listIterator();
//			System.out.print(s + ">>");
//			while (i.hasNext()) {
//				int n = i.next();
//				System.out.print(n + ">");
//			}
//			System.out.println("");
		}
	}
	
	void printSpecGraph(int s){
		Iterator<Integer> i = ad[s].listIterator();
		System.out.print(s + ">>");
		while (i.hasNext()) {
			int n = i.next();
			System.out.print(n + ">");
		}
		System.out.println("");
	}

	void BFS(int s, boolean print) { // generate correct P and L matrix
		L[s][s]=0;
		int dist = 1;
		boolean visited[] = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			int t = queue.poll(); // Dequeue a vertex from queue
			if(print) System.out.print(t + ">");

			Iterator<Integer> i = ad[t].listIterator();
			while (i.hasNext()) {   // Get all adjacent vertices of the dequeued vertex s
				int n = i.next();
				if (!visited[n]) {  // If a adjacent has not been visited, then mark it
					visited[n] = true; // visited and enqueue it
					queue.add(n);
					P[s][n] = t;
					if (L[s][t] == dist)
						dist++; // first term would be zero
					L[s][n] = dist;
				}
			}
		}
		if(print) System.out.println("");
	}

	void automateBFS() {
		for (int i = 0; i < v; i++)
			BFS(i, true); //prints
	}

	void fullauto() {
		for (int i = 0; i < v; i++)
			BFS(i, false); //no printing
	}
	
	void shortestpath(int v, int w) {
		if (v==w) {
			System.out.println("Distance = " + L[v][w]);
			return;
		}
		else if(P[v][w] == -1) {
			System.out.println("oops im lost.");
			return;
		}
		int temp = w;
		System.out.print(w+">");
		while(P[v][w] != -1) {
			w = P[v][w];
			if (v==w) System.out.println(v + " Distance = " + L[v][temp]);
			else System.out.print(w+">");
		}
	}

	void printP() {
		System.out.print("      ");
		for (int i = 0; i < v; i++) System.out.format("%6d", i);
		System.out.println();
		for (int i = 0; i < v; i++) {
			System.out.format("%6d", i);
			for (int j = 0; j < v; j++) {
				System.out.format("%6d", P[i][j]);
			}
			System.out.println();
		}
	}

	void printL() {
		System.out.print("      ");
		for (int i = 0; i < v; i++) System.out.format("%6d", i);
		System.out.println();
		for (int i = 0; i < v; i++) {
			System.out.format("%6d", i);
			for (int j = 0; j < v; j++) {
				System.out.format("%6d", L[i][j]);
			}
			System.out.println();
		}
	}
}
