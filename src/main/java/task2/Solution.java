package task2;

import java.util.ArrayList;
import java.util.Arrays;
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
    int vertices = in.nextInt();
    int edges = in.nextInt();

    for (int i = 0; i < queries; i++) {

      marked = new boolean[vertices];
      edgeTo = new int[vertices];
      int s;

      Graph graph = new Graph(vertices);

      for (int j = 0; j < edges; j++) {
        Edge edge = new Edge(in.nextInt(), in.nextInt());
        graph.addEdge(edge);
      }
      s = in.nextInt();

      bfs(graph, s);

      System.out.println(Arrays.toString(edgeTo));
    }
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