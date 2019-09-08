import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        testGraph();
//        testDfs();
  //      testBfs();
    }

    private static void testGraph() {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        //graph.addVertex("Тамбов");
        //graph.addVertex("Орел");
        //graph.addVertex("Саратов");
        //graph.addVertex("Курск");
        //graph.addVertex("Воронеж");

        /*graph.addEdge("Тула", "Липецк", 8);
        graph.addEdge("Липецк", "Воронеж", 15);

        graph.addEdge("Рязань", "Тамбов", 7);
        graph.addEdge("Тамбов", "Саратов", 1);
        graph.addEdge("Саратов", "Воронеж", 8);

        graph.addEdge("Калуга", "Орел", 3);
        graph.addEdge("Орел", "Курск", 5);
        graph.addEdge("Курск", "Воронеж",12);*/

        graph.addEdge("Москва", "Тула");
        graph.addEdge("Москва", "Калуга");
        graph.addEdge("Тула", "Рязань");
        graph.addEdge("Рязань", "Липецк");
        graph.addEdge("Калуга", "Липецк");


        graph.display();
        Stack<String> path = graph.minRoad("Москва", "Липецк");
        //System.out.println(path.size());
        System.out.println("\n Кратчайший путь:");
        showShortPath(path);
    }

    private static void showShortPath(Stack<String> path) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        while ( !path.isEmpty() ) {
            if (!isFirst) {
                sb.append(" -> ");
            }
            isFirst = false;
            sb.append(path.pop());
        }

        System.out.println(sb);
    }
  /*  private static void testDfs() {
        Graph graph = new Graph(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("B", "E");
        graph.addEdge("E", "C");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

//        graph.dfs("A");
 //       graph.dfsRec("A");
        //A B E C D F G
    }*/

   /* private static void testBfs() {
        Graph graph = new Graph(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("B", "E", 15);
        graph.addEdge("E", "H", 12);
        graph.addEdge("C", "F", 18);
        graph.addEdge("D", "G", 11);

        //graph.bfs("A", "C");
    }*/
}
