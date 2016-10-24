
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class GraphApp {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int choice, c1, c2, c3;
		System.out.println("Welcome!");
		do {
			System.out.println("");
			System.out.println("1 - Generate CPU time taken for preprocessing");
			System.out.println("2 - Manual Mode");
			System.out.println("3 - Terminate");
			System.out.print("Enter Choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				init();
				break;
			case 2:
				System.out.println("Enter number of vertices: ");
				c1 = sc.nextInt();
				Graph g = new Graph(c1);
				System.out.println("Enter number of edges: ");
				c2 = sc.nextInt();
				g.genEdge(c2);
				g.fullauto();
				System.out.println("Preprocessing done!\n");

				do {
					System.out.println("");
					System.out.println("   1 - Print Graph");
					System.out.println("   2 - Print BFS order");
					System.out.println("   3 - Print Matrix P");
					System.out.println("   4 - Print Matrix L");
					System.out.println("   5 - Print All");
					System.out.println("   6 - Run Specific Query");
					System.out.println("   7 - Specific Adjacency List");
					System.out.println("   8 - Back");
					System.out.print("      Enter Choice: ");
					c1 = sc.nextInt();
					switch (c1) {
					case 6:
						System.out.println("Enter index of starting point: ");
						c2 = sc.nextInt();
						System.out.println("Enter index of ending point: ");
						c3 = sc.nextInt();
						g.shortestpath(c3, c2);
						break;
					case 1:
						System.out.println("\nGraph generated: ");
						g.printGraph();
						break;
					case 2:
						System.out.println("\nBFS queue order: ");
						g.automateBFS();
						break;
					case 3:
						System.out.println("\nMatrix showing predecessor: ");
						g.printP();
						break;
					case 4:
						System.out.println("\nMatrix showing shortest dist: ");
						g.printL();
						break;
					case 5:
						System.out.println("\nGraph generated: ");
						g.printGraph();
						System.out.println("\nBFS queue order: ");
						g.automateBFS();
						System.out.println("\nMatrix showing predecessor: ");
						g.printP();
						System.out.println("\nMatrix showing shortest dist: ");
						g.printL();
						break;
					case 7:
						System.out.println("Enter index of list: ");
						c2 = sc.nextInt();
						g.printSpecGraph(c2);
						break;
					}
				} while (c1 < 8);
				g = null;
				break;
			case 3:
				System.out.println("Goodbye.");
			}
		} while (choice < 3);
		sc.close();
	}

	static void init() {
		long stime, etime;
		long t11, t12, t13, t14, t15;
		long t21, t22, t23, t24, t25;
		
		Graph g11 = new Graph(5000);
		g11.genEdge(1000);
		stime = System.nanoTime();
		g11.fullauto();
		etime = System.nanoTime();
		t11 = etime - stime;
		g11 = null;
		System.gc();
		System.out.println("5%");

		Graph g12 = new Graph(5000);
		g12.genEdge(5000);
		stime = System.nanoTime();
		g12.fullauto();
		etime = System.nanoTime();
		t12 = etime - stime;
		g12 = null;
		System.gc();
		System.out.println("10%");

		Graph g13 = new Graph(5000);
		g13.genEdge(10000);
		stime = System.nanoTime();
		g13.fullauto();
		etime = System.nanoTime();
		t13 = etime - stime;
		g13 = null;
		System.gc();
		System.out.println("15%");

		Graph g14 = new Graph(5000);
		g14.genEdge(50000);
		stime = System.nanoTime();
		g14.fullauto();
		etime = System.nanoTime();
		t14 = etime - stime;
		g14 = null;
		System.gc();
		System.out.println("25%");
		
		Graph g15 = new Graph(5000);
		g15.genEdge(100000);
		stime = System.nanoTime();
		g15.fullauto();
		etime = System.nanoTime();
		t15 = etime - stime;
		System.gc();
		g15 = null;
		System.out.println("45%");

		Graph g21 = new Graph(10000);
		g21.genEdge(1000);
		stime = System.nanoTime();
		g21.fullauto();
		etime = System.nanoTime();
		t21 = etime - stime;
		g21 = null;
		System.gc();
		System.out.println("50%");

		Graph g22 = new Graph(10000);
		g22.genEdge(5000);
		stime = System.nanoTime();
		g22.fullauto();
		etime = System.nanoTime();
		t22 = etime - stime;
		g22 = null;
		System.gc();
		System.out.println("55%");

		Graph g23 = new Graph(10000);
		g23.genEdge(10000);
		stime = System.nanoTime();
		g23.fullauto();
		etime = System.nanoTime();
		t23 = etime - stime;
		g23 = null;
		System.gc();
		System.out.println("65%");

		Graph g24 = new Graph(10000);
		g24.genEdge(50000);
		stime = System.nanoTime();
		g24.fullauto();
		etime = System.nanoTime();
		t24 = etime - stime;
		g24 = null;
		System.gc();
		System.out.println("80%");

		Graph g25 = new Graph(10000);
		g25.genEdge(100000);
		stime = System.nanoTime();
		g25.fullauto();
		etime = System.nanoTime();
		t25 = etime - stime;
		g25 = null;
		System.gc();
		System.out.println("99%");
		System.out.println("Writing File...");
		try {
			FileWriter fstream = new FileWriter(System.currentTimeMillis() + ".Results.txt");
			BufferedWriter out = new BufferedWriter(fstream);

			out.write("5000V/1000E:");
			out.newLine();
			out.write(String.valueOf(t11));
			out.newLine();
			out.write("5000V/5000E:");
			out.newLine();
			out.write(String.valueOf(t12));
			out.newLine();
			out.write("5000V/10000E:");
			out.newLine();
			out.write(String.valueOf(t13));
			out.newLine();
			out.write("5000V/50000E:");
			out.newLine();
			out.write(String.valueOf(t14));
			out.newLine();
			out.write("5000V/100000E:");
			out.newLine();
			out.write(String.valueOf(t15));
			out.newLine();
			out.write("10000V/1000E:");
			out.newLine();
			out.write(String.valueOf(t21));
			out.newLine();
			out.write("10000V/5000E:");
			out.newLine();
			out.write(String.valueOf(t22));
			out.newLine();
			out.write("10000V/10000E:");
			out.newLine();
			out.write(String.valueOf(t23));
			out.newLine();
			out.write("10000V/50000E:");
			out.newLine();
			out.write(String.valueOf(t24));
			out.newLine();
			out.write("10000V/100000E:");
			out.newLine();
			out.write(String.valueOf(t25));
			out.newLine();
			out.close();
			System.out.println("Done!\n100%");

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

	}
}
