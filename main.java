import java.util.Arrays;

public class main {

    public static void main(String[] args){

        var size = 12;
        GraphModel graph = new GraphModel(size);
        /*int[][] componentStructure = new int[size][size];
        for(int i =0; i < size; i++ ){
            for(int j =0; j < size; j++){
                var associatedGraph = graph.getAssociatedGraph(i);

            }
        }
*/
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(2,6);
        graph.addEdge(3,7);
        graph.addEdge(3,6);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(8,9);
        graph.addEdge(10,11);




        System.out.println("The Graph G is:");
        var graphStringfy = graph.toString();
        System.out.println(graphStringfy);


        System.out.println("os componentes conexos de G sao");
        var ccs = graph.getComponents();
        System.out.println(ccs);

        System.out.println("o componente conexo do vertice 11 eh");
        System.out.println(graph.getConnectedComponentsByVertice(11));



        System.out.println("The neighborhood of vertice 5 is:");
        System.out.println(graph.getAdjacencyVertices(5));

        var associatedGraph = graph.getAssociatedGraph(5);
        System.out.println("The graph G - N[5] is: ");
        System.out.println(associatedGraph);






    }

}
