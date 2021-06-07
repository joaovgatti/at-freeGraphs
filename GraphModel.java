import java.util.*;

public class GraphModel {

    HashMap<Integer, List<Integer>> map;

    private int v;
    private int componentCount;
    private boolean[] visited;
    private boolean solved;
    private int[] components;


    public GraphModel(int v){

        this.v = v;
        map = new HashMap<>();

    }


    public void addVertice(int s){
        map.put(s, new ArrayList<>());

    }

    public void addEdge(int u, int v){

        if(!map.containsKey(u)){
            addVertice(u);
        }
        if(!map.containsKey(v)){
            addVertice(v);
        }

        map.get(u).add(v);
        map.get(v).add(u);
    }

    public ArrayList<Integer> getAdjacencyVertices(int vertice){

        var list = new ArrayList<Integer>();

        list.add(vertice);

        list.addAll(map.get(vertice));

        return list;

    }

    public GraphModel getAssociatedGraph(int vertice){

        var vizinhos = getAdjacencyVertices(vertice);

        var size = v - vizinhos.size();

        GraphModel  associatedGraph = new GraphModel(size);

        for(int v : map.keySet()){
            if(!vizinhos.contains(v)){
                associatedGraph.addVertice(v);
                for(int w : map.get(v)){
                    if(!vizinhos.contains(w)){
                        associatedGraph.map.get(v).add(w);
                    }
                }
            }
        }
        return associatedGraph;
    }

    public List<Integer> getComponents() {
        solve();
        var list = new ArrayList<Integer>();
        for (int component : components) {
            list.add(component);
        }
        list.remove(0);
        return list;
    }

    public int getConnectedComponentsByVertice(int vertice){
        var list = getComponents();
        return list.get(vertice-1);
    }


    public void solve() {
        if (solved) return;

        visited = new boolean[this.v];
        components = new int[this.v];
        for (int i = 1; i < this.v; i++) {
            if (!visited[i]) {
                componentCount++;
                dfs(i);
            }
        }

        solved = true;
    }

    private void dfs(int at) {
        visited[at] = true;
        components[at] = componentCount;
        for (int to : getAdjacencyVertices(at)) {
            if (!visited[to]){
                dfs(to);
            }
        }
    }




    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (int v : map.keySet()) {
            builder.append(v + ": ");
            for (int w : map.get(v)) {
                builder.append(w + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }


}
