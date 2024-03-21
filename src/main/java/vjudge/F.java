package vjudge;

import java.util.*;

class Edge implements Comparable<Edge> {
  int src, dest, weight;

  public Edge(int src, int dest, int weight) {
    this.src = src;
    this.dest = dest;
    this.weight = weight;
  }

  @Override
  public int compareTo(Edge other) {
    return this.weight - other.weight;
  }
}

class MST {
  int V, E;
  Edge[] edges;

  public MST(int v, int e) {
    V = v;
    E = e;
    edges = new Edge[E];
  }

  int find(int[] parent, int i) {
    if (parent[i] == -1)
      return i;
    return find(parent, parent[i]);
  }

  void union(int[] parent, int x, int y) {
    int xRoot = find(parent, x);
    int yRoot = find(parent, y);
    parent[xRoot] = yRoot;
  }

  int kruskalMST() {
    Edge[] result = new Edge[V];
    int e = 0;
    int i = 0;
    Arrays.sort(edges);

    int[] parent = new int[V];
    Arrays.fill(parent, -1);

    while (e < V - 1 && i < E) {
      Edge next_edge = edges[i++];
      int x = find(parent, next_edge.src);
      int y = find(parent, next_edge.dest);

      if (x != y) {
        result[e++] = next_edge;
        union(parent, x, y);
      }
    }

    int minimumCost = 0;
    for (i = 0; i < e; ++i)
      minimumCost += result[i].weight;
    return minimumCost;
  }
}

public class F {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    MST mst = new MST(n, m);

    for (int i = 0; i < m; i++) {
      int src = scanner.nextInt() - 1;
      int dest = scanner.nextInt() - 1;
      int weight = scanner.nextInt();
      mst.edges[i] = new Edge(src, dest, weight);
    }

    System.out.println(mst.kruskalMST());
  }
}