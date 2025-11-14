import java.util.*;

public class BFS {
    static class Edge{
        int src;
        int dest;
        int wt;
        // make constructor
        public Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt = w;
        }


    }
    // make a function for creating graph
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i= 0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        //Storing elements
        //0-vertex
        graph[0].add(new Edge(0,1,5));
        //1-vertex
        graph[1].add(new Edge(1,0,4));
        graph[1].add(new Edge (2,2,2));
        graph[1].add(new Edge(2,1,2));
        //2-vertex
        graph[2].add(new Edge(2,2,4));
        graph[2].add(new Edge(2,1,2));
        //3-vertex
        graph[3].add(new Edge(2,0,2));

    }
    // make a function for implementing BFS
    public static void bfs(ArrayList<Edge>[]graph){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[]= new boolean[graph.length];
        q.add(0);// Source 0
        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){//visit curr
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i =0; i<graph[curr].size();i++){
                    Edge e= graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }


    public static void main(String[] args) {
        int V= 7;//no. of vertices
        ArrayList<Edge>graph[]=new ArrayList[V];
        createGraph(graph);
        bfs(graph);




    }
}