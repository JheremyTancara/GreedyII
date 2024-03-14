# Exercise Analysis
### Find the minimum spanning tree of the graph.
- [ ] Author: Jheremy Kevin Tancara Zambrana
_ _ _
### Analyze the problem F of the contest:
***
- Explication Problem:
  A Minimum Spanning Tree of a graph is a subgraph that contains all the vertices of the original graph and is a tree (connected and without cycles). Furthermore, the sum of the weights of all the edges in this tree must be minimal among all possible spanning trees that can be formed with the original graph.
  The most commonly used algorithms to find the MST are Kruskal's algorithm and Prim's algorithm.
  Kruskal's Algorithm: It starts with all vertices in separate sets and gradually adds the lightest edges that do not form cycles until all vertices are connected.
  Prim's Algorithm: It starts with an arbitrary vertex and gradually adds the nearest vertex to the MST structure until all vertices are connected.
  In this problem, a graph with N nodes and M edges is provided, along with the weights of the edges. The objective is to find the total sum of the weights of all the edges in the Minimum Spanning Tree.

- Logic Code:
  Edge Class:
    * This class defines an edge in the graph.
    * It contains three attributes: src, dest, and weight.
    * These attributes represent the source vertex, destination vertex, and the weight of the edge, respectively.
    * The class implements the Comparable interface to enable sorting based on edge weights.
  
  MST Class:
    * This class handles the operations related to finding the Minimum Spanning Tree (MST).
    * It has attributes V (number of vertices), E (number of edges), and an array of edges representing the edges in the graph.
    * The class contains methods for finding the MST using Kruskal's algorithm.
    * The find() method finds the parent of a vertex in a disjoint set.
    * The union() method performs a union operation on two disjoint sets.
    * The kruskalMST() method computes the MST using Kruskal's algorithm.
    * It sorts the edges in non-decreasing order of weight.
    * It initializes a parent array to track disjoint sets.
    * It iterates through the sorted edges, adding edges to the MST if they do not create a cycle.
    * It calculates the total weight of the MST.
  
  Main Method:
    * Reads input values for the number of nodes n and edges m.
    * Creates an instance of the MST class.
    * Reads the edges of the graph and initializes the edges array.
    * Calls the kruskalMST() method to find the MST and prints the total weight.

- Questionnaire:

    * Identify the greedy choice
      - Select the Lightest Edge: Start by selecting the edge with the smallest weight from the graph.
      - Add Edges Without Forming Cycles: Iterate over the remaining edges in increasing order of weight. Add edges that do not create cycles with previously selected edges.
      - Stop When All Nodes are Connected: Terminate the process once all nodes are connected.

    * Identify the optimal substructure
      - Formula for Optimal Solution (SO): Let's denote SO as the sum of weights of edges in the Minimum Spanning Tree (MST). We can represent this as:
      - Selection of Edges in MST: The optimal structure involves selecting edges in such a way that the total weight of the MST (SO) is minimized.
      - Avoidance of Cycles: The MST structure ensures that no cycles are formed, as it's a tree by definition.
      - Efficient Connection of All Nodes: The optimal MST connects all nodes in the graph with the minimum total edge weight.



