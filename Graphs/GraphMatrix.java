import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Implement graph using adjacency matrix
 */
@SuppressWarnings("unchecked")
public class GraphMatrix {

    private static boolean[][] adjMatrix;
    private static int numOfVertices;

    public static void addEdge(int vertex1, int vertex2) {
        adjMatrix[vertex1][vertex2] = true;
    }

    public static void removeEdge(int vertex1, int vertex2) {
        adjMatrix[vertex1][vertex2] = false;
    }

    public static boolean hasEdge(int vertex1, int vertex2) {
        return adjMatrix[vertex1][vertex2];
    }

    public static ArrayList<Integer> outEdges(int vertex) {

        ArrayList<Integer> outEdges = new ArrayList();

        for (int i = 0; i < numOfVertices; i++) {
            if (adjMatrix[vertex][i]) {
                outEdges.add(i);
            }
        }

        return outEdges;
    }

    public static ArrayList<Integer> inEdges(int vertex) {

        ArrayList<Integer> inEdges = new ArrayList();

        for (int i = 0; i < numOfVertices; i++) {
            if (adjMatrix[i][vertex]) {
                inEdges.add(i);
            }
        }

        return inEdges;
    }



    /*
     * copy text file to populate adjMatrix
     * @param : text file
     */
    public static void readInput(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner sc = new Scanner(file);

        numOfVertices = Integer.parseInt(sc.nextLine());
        adjMatrix = new boolean[numOfVertices][numOfVertices];


        while(sc.hasNextLine()) {
            String[] input = sc.nextLine().split(":");
            int vertex1 =  Integer.parseInt(input[0]);
            int vertex2 = Integer.parseInt(input[1]);
            adjMatrix[vertex1][vertex2] = true;
        }
    }

    /*
     * @param : arguments from command line
     * v - number of vertices
     */
    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("No arguments passed");
            System.exit(0);
        }

        GraphMatrix  graphMatrix = new GraphMatrix();

        graphMatrix.readInput(args[0]);

        System.out.println(graphMatrix.outEdges(2));
        System.out.println(graphMatrix.inEdges(2));

    }

}
