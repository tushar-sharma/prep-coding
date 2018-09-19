import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;


/*
 * Implement graph using adjacency matrix
 */
public class GraphMatrix {

    private static boolean[][] adjMatrix;
    private static int numOfVertices;

    public GraphMatrix() {
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
            int vertex =  Integer.parseInt(input[0]);
            int edge = Integer.parseInt(input[1]);
            adjMatrix[vertex][edge] = true;
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
    }

}
