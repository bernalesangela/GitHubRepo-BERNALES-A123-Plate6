import java.util.Scanner;

public class Problem7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("\n The Incidence Matrix of a Graph : Problem #7 \n [BERNALES, ANGELA NAREEN F.]\n");

		System.out.print("Enter number of vertices in the graph: ");
		int vertices = sc.nextInt();
		System.out.print("Enter number of edges in the graph: ");
		int edges = sc.nextInt();

		int[][] incidenceMatrix = new int[vertices][edges];// initializes the matrix

		for (int i = 0; i < edges; i++) {
			System.out.print("Enter vertices of edge: ");
			int v1 = sc.nextInt(); // input for v1
			int v2 = sc.nextInt(); // input for v2

			incidenceMatrix[v1][i] = 1; // since it is a incidence matrix uses the rows as the vertices
			incidenceMatrix[v2][i] = 1;// and the columns for he edges
		}

		for (int i = 0; i < vertices; i++) {// for rows
			for (int j = 0; j < edges; j++) {// for columns
				System.out.print(incidenceMatrix[i][j] + " ");// print out incidence
			}
			System.out.println();
		}
		System.out.println("Edges of the graph:");
		int count = 0;// outside the loops to retain its value
		for(int i = 0; i < vertices; i++) {// loop for row
			for(int j = i ; j < edges; j++) {//nested loop to scan all columns in the row to add values to matrix. 
				//uses the i since adjacency matrix is symmetrical to avoid recounting the same edge
				int number = incidenceMatrix [i][j];//inside for loop so that its value resets
				if( number == 1) {
					int edge = 0; // inside if statement so value resets to zero
					edge++;// adds count to edge
					System.out.println(i+1 + " <---> " + (j+1) + " = " + edge );
					count++;// adds count
				}
			}
		}
		System.out.println("Total number of edges: " + count);//prints out output
	}
}