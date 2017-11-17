package task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

  private static boolean[] marked;
  private static int[] edgeTo;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int queries = in.nextInt();

    for (int i = 0; i < queries; i++) {

      int vertices = in.nextInt();
      int edges = in.nextInt();
      marked = new boolean[vertices];
      edgeTo = new int[vertices];
      for (int i1 = 0; i1 < edgeTo.length; i1++) {
        edgeTo[i1] = -1;
      }
      int s;

      Graph graph = new Graph(vertices);

      for (int j = 0; j < edges; j++) {
        Edge edge = new Edge(in.nextInt() - 1, in.nextInt() - 1);
        graph.addEdge(edge);
      }
      s = in.nextInt() - 1;

      bfs(graph, s);

      pathTo(s);
    }
  }

  private static void pathTo(int start) {
    for (int i = 0; i < edgeTo.length; i++) {
      if (i != start) {
        int sum = 0;
        int cur = edgeTo[i];
        if (cur == -1) {
          System.out.print("-1 ");
        } else {
          while (cur != -1) {
            sum += 6;
            cur = edgeTo[cur];
          }
          System.out.print(sum + " ");
        }
      }
    }
    System.out.println();
  }

  public static void bfs(Graph g, int s) {
    Queue<Integer> queue = new LinkedList<>();
    marked[s] = true;
    queue.add(s);
    while (!queue.isEmpty())
    {
      int v = queue.poll();
      for (int w : g.adj(v))
        if (!marked[w])
        {
          edgeTo[w] = v;
          marked[w] = true;
          queue.add(w);
        }
    }
  }

  private static class Graph {
    List<List<Integer>> adjList = new ArrayList<>();

    public Graph(int size) {
      for (int i = 0; i < size; i++) {
        adjList.add(new ArrayList<>());
      }
    }

    public void addEdge(Edge edge) {
      adjList.get(edge.getX()).add(edge.getY());
      adjList.get(edge.getY()).add(edge.getX());
    }

    public List<Integer> adj(int x) {
      return adjList.get(x);
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