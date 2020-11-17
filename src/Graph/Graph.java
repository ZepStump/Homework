package Graph;

//Java code to demonstrate Graph representation 
//using ArrayList in Java 

import java.util.*; 

class Graph { 
   
 // A utility function to add an edge in an 
 // undirected graph 
 static void addEdge(int[][] adj, 
                     int u, int v) 
 { 
     adj[u][v]=1;
     adj[v][u]=1;
 } 

 // A utility function to print the adjacency list 
 // representation of graph 
 static void printGraph(int[][] adj) 
 { 
     for (int i = 0; i < adj.length; i++) { 
         System.out.print("Adjacent to the " + i +" are: ");  
         for (int j = 0; j < adj.length; j++) { 
             if (adj[i][j]==1)
            	 System.out.print(j+" ");
         } 
         System.out.println(); 
     } 
 } 

 // Driver Code 
 public static void main(String[] args) 
 { 
     // Creating a graph with 5 vertices 
     int V = 5; 
     int[][] adj = new int[V][V]; 
       
     for (int i = 0; i < V; i++)
     {
         for (int j=0; j<V;j++)
         {
        	 adj[i][j]=0;
         }
     }
     // Adding edges one by one 
     addEdge(adj, 0, 1); 
     addEdge(adj, 0, 4); 
     addEdge(adj, 1, 2); 
     addEdge(adj, 1, 3); 
     addEdge(adj, 1, 4); 
     addEdge(adj, 2, 3); 
     addEdge(adj, 3, 4); 
       
     printGraph(adj); 
 } 
} 
