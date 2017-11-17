package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int queries = in.nextInt();
    int vertices = in.nextInt();
    int edges = in.nextInt();

    for (int i = 0; i < queries; i++) {

      Graph graph = new Graph(vertices);

      for (int j = 0; j < edges; j++) {
        Edge edge = new Edge(in.nextInt(), in.nextInt());
        graph.addEdge(edge);
      }

      int s = in.nextInt();

    }
  }

  public void bfs

  private static class Graph {
    List<List<Integer>> adjList = new ArrayList<>();

    public Graph(int size) {
      for (int i = 0; i < size; i++) {
        adjList.add(new ArrayList<>());
      }
    }

    public void addEdge(Edge edge) {
      adjList.get(edge.getX() - 1).add(edge.getY() - 1);
    }

    public List<Integer> adj(int x) {
      return adjList.get(x - 1);
    }
  }

  private static class Edge {
    int x;
    int y;

    public Edge(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }


}