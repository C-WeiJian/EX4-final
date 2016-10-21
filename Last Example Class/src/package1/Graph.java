package package1;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	private int v;
	private LinkedList<Integer> ad[];
	private int[][] L;
	private int[][] P;

	Graph(int v) {
		this.v = v;
		ad = new LinkedList[v];
		L = new int[v][v];
		P = new int[v][v];
		for (int i = 0; i < v; i++){
			ad[i] = new LinkedList();
			for (int j=0; j < v; j++){
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
	
	void genEdge(int n){
		int r1,r2;
		for (int i=0; i<n; i++){
			do{
			System.out.println("Assigning Edge " + i);
			r1 = (int) (v*Math.random());
			r2 = (int) (v*Math.random());
			} while (checkEdge(r1,r2)==true || r1==r2);
			addEdge(r1,r2);
			addEdge(r2,r1);
			System.out.println("Assigned Edge " + i);
			
		}
	}

	void BFS(int s) {
		boolean visited[] = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			int temp = queue.getFirst();
			int t = queue.poll();
			//System.out.print(s+" ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = ad[t].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
					P[s][n] = t;
				}
			}
		}
	}
	
	void calcL(int s,int e){
		int count = 0;
		int temp = e;
		if(e==s){
			L[s][e]=0;
		}
		else while(P[s][e] != -1){
			e = P[s][e];
			count++;
			if(e==s){
				L[s][temp] = count;
				break;
			}
		}	
	}
	
	void automatecalcL(){
		for(int i = 0; i<v; i++)
		{
		    for(int j = 0; j<v; j++)
		    {
		        calcL(i,j);
		    }
		}
	}
	
	void automatecalcP(){
		for(int i = 0; i<v; i++) BFS(i);
	}
	
	void printP() {
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				System.out.format("%6d", P[i][j]);
			}
			System.out.println();
		}
	}

	void printL() {
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				System.out.format("%6d", L[i][j]);
			}
			System.out.println();
		}
	}

}
