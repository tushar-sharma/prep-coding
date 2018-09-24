/*
 * implement graph using adjacency matrix
 * input: inputList.tx
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

@SuppressWarnings("unchecked")
public class GraphList {
     private static Map<Integer, ArrayList<Integer>> adjList;
     private static int numOfVertices;

     public GraphList() {
         adjList = new HashMap<Integer, ArrayList<Integer>>();
     }

     /*
      * copy content of file into adjacency list
      * v (number of vertices)
      * vertex1:vertext2,vertex3,...(here path is from vertex1 to vertext2,vertext3,...)
      */
     public static void readInput(String filename) throws FileNotFoundException {

         File file = new File(filename);
         Scanner sc = new Scanner(file);
         int vertex1, vertex2;

         numOfVertices = Integer.parseInt(sc.nextLine());

         while(sc.hasNextLine()) {
             ArrayList<Integer> neighbors = new ArrayList<Integer>();

             String[] input = sc.nextLine().split(":");
             vertex1 = Integer.parseInt(input[0]);
             String[] vertices = input[1].split(",");


             for (String v : vertices) {
                 vertex2 = Integer.parseInt(v);
                 neighbors.add(vertex2);
             }

             adjList.put(vertex1, neighbors);

         }
     }

     public static ArrayList<Integer> outEdges(int vertex) {

         return new ArrayList<Integer>(adjList.get(vertex));
     }

     public static ArrayList<Integer> inEdges(int vertex) {

         ArrayList<Integer> arrayInEdges = new ArrayList<Integer>();

         for (int i = 0; i < numOfVertices;  i++) {
             ArrayList<Integer> tempVertices = adjList.get(i);
             if (tempVertices != null) {
                 if (tempVertices.contains(vertex)) {
                     arrayInEdges.add(i);
                 }
             }
         }
         return arrayInEdges;
     }

     public static void main(String[] args) throws IOException {

         if (args.length == 0) {
             System.out.println("No arguments passed");
             System.exit(0);
         }

         GraphList graphList = new GraphList();

         graphList.readInput(args[0]);

         System.out.println(graphList.inEdges(4));
     }
}

