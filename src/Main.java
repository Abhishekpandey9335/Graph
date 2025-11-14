import java.util.*;

public class Main {
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

    public static void main(String[] args) {
        int V= 5;//no. of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];//null -> empty ArrayList
        // for traversing
        for(int i = 0; i<V;i++){
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
        //2's neighbour
        for(int i =0;i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }



    }
}