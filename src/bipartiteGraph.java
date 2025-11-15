import java.util.*;


public class bipartiteGraph {
    static class Edge{
        int src;
        int dest;

        public Edge(int s,int d){
            this.src=s;
            this.dest=d;

        }

    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i =0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
       graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
       graph[4].add(new Edge(4,3));

    }
    // make a detection cycle
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis []=new boolean[graph.length];
        for(int i = 0; i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true; //cycle exist in one of the path

                }

            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean vis[],int curr,int par){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            //case 3
            if(!vis[e.dest]&& detectCycleUtil(graph,vis,e.dest,curr)){
                return true;
            }
            // case 1
            else if (vis[e.dest] && e.dest != par){
                return true;
            }
            // case-2 -> do nothing -> continue

        }
        return false;
    }
    // make a bipartite graph
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[]=new int[graph.length];
        for(int i = 0;i<col.length;i++){
            col[i]=-1;//no color
        }
        Queue<Integer>q = new LinkedList<>();
        for(int i = 0;i<graph.length;i++){
            if(col[i]==-1){//BFS
                q.add(i);
                col[i]=0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j =0;j<graph[curr].size();j++){
                        Edge e = graph[curr].get(j);//e.dest
                        if(col[e.dest]==-1){
                            int nextCol = col[curr]==0? 1:0;//tinray operattion
                            col[e.dest]=nextCol;
                            q.add(e.dest);
                        }
                        else if(col[e.dest]== col[curr]){
                            return false;//NOT bipartite
                        }
                       }
                }

            }

        }
        return true;

    }


    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));


    }
}
