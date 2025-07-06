import java.io.*;
import java.util.*;

class UndirectedGraph {
    private int count;
    private int[][] vertexMatrix;

    public UndirectedGraph(int count){
        this.count = count;
        vertexMatrix = new int[count][count];
    }

    public void addEdges(int from, int to, int weight){
        vertexMatrix[from][to] = weight;
        vertexMatrix[to][from] = weight;
    }

    public int[][] getMatrix() {
        return vertexMatrix;
    }
}

class DfsSearch{
    int count;
    boolean[] visited;
    Stack<Integer> stack;
    int[][] matrix;

    public DfsSearch(int count){
        this.count = count;
        visited = new boolean[count];
        stack = new Stack<Integer>();
    }

    public void dfsTraversal(){
        stack.push(0);
        visited[0] = true;

        while(!stack.isEmpty()){
            int node = stack.pop();
            System.out.println(node + " ");

            for (int i = 0; i < count; i++) {
                if(matrix[node][i] != 0 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        int count = 7;
        UndirectedGraph graph = new UndirectedGraph(count);
        DfsSearch dfsSearch = new DfsSearch(count);

        graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(1, 3, 1);
        graph.addEdges(1, 4, 1);
        graph.addEdges(2, 5, 1);
        graph.addEdges(2, 6, 1);
        graph.addEdges(4, 5, 1);
        graph.addEdges(3, 7, 1);

        dfsSearch.matrix = graph.getMatrix();
        dfsSearch.dfsTraversal();
    }
}