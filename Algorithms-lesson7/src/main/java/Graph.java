import java.util.*;

import static java.util.Arrays.fill;

public class Graph {
    private final ArrayList<Vertex> vertexList;
    private final boolean[][] adjMat;
    private int size;
    //private static int infinity = Integer.MAX_VALUE / 2;


    public Graph(int maxVerts) {
        this.vertexList = new ArrayList<>();
        this.adjMat = new boolean[maxVerts][maxVerts];
        for(int i = 0; i < maxVerts; i++){
            for(int j = 0; j < maxVerts; j++){
                this.adjMat[i][j] = false;
            }
        }
        this.size = 0;
    }

    public boolean addVertex(String name){
        if(size == adjMat.length){
            return false;
        }
        else{
            Vertex vertex = new Vertex(name);
            vertexList.add(vertex);
            size++;
        }
        return true;
    }

    private int indexOf(String findedName) {
        for (int i = 0; i < size; i++) {
            if (vertexList.get(i).getName().equals(findedName)) {
                return i;
            }
        }

        return -1;
    }

    public boolean addEdge(String firstName, String secondName){
        int first = indexOf(firstName);
        int second = indexOf(secondName);
        if(first == -1 || second == -1){
            return false;
        }
        else{
            adjMat[first][second] = adjMat[second][first] = true;
        }
        return true;
    }

    public boolean addEdges(String firstName, String... secondNames) {
        boolean res = false;
        for (String secondName : secondNames) {
            addEdge(firstName, secondName);
            res = true;
        }
        return res;
    }

    public void display(){
        System.out.println("------------");
        for(int i = 0; i < vertexList.size(); i++){
            System.out.print(vertexList.get(i).getName() + ":  ");
            String list = "";
            for(int j = 0; j < adjMat.length; j++){
                if(adjMat[i][j]){
                    if(list != ""){
                        list += " -> ";
                    }
                    list += vertexList.get(j).getName();
                }
            }
            System.out.println(list);
        }
        System.out.println("------------");
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        //System.out.println(vertex.getName());
        queue.add(vertex);
        vertex.setVisited(true);
    }

    public void bfs(String firstName) {  //, String secondName) {
        int start = indexOf(firstName);
        if (start == -1) {
            throw new IllegalArgumentException("Неверный пункт отправления: " + firstName);
        }
        /*int finish = indexOf(secondName);
        if (finish == -1) {
            throw new IllegalArgumentException("Неверный пункт прибытия: " + secondName);
        }
        int[] dist = new int[adjMat.length];
        fill(dist, infinity);
        dist[start] = 0;

        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex vertex = vertexList.get(start);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek(), dist);
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }

        resetVertexState();*/

        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex vertex = vertexList.get(start);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }

        resetVertexState();
    }


    private Vertex getNearUnvisitedVertex(Vertex currentVertex) {
        int currentIndex = vertexList.indexOf(currentVertex);
        //System.out.println( currentVertex.getName());

        for (int i = 0; i < size; i++) {
            if (adjMat[currentIndex][i] && !vertexList.get(i).getVisited()) {
                //System.out.println("next vertex " + currentVertex.getName());
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }



    public Stack<String> minRoad(String startVertex, String finishVertex) {
        int start  = indexOf(startVertex);
        int finish = indexOf(finishVertex);
        Queue<Vertex> queue = new ArrayDeque<>();

        if (start == -1) {
            throw new IllegalArgumentException("Неверный пункт отправления: " + startVertex);
        }
        else if (finish == -1) {
            throw new IllegalArgumentException("Неверный пункт назначения: " + finishVertex);
        }


        Vertex vertex = vertexList.get(start);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex == null) {
                queue.remove();
            } else {
                visitVertex(queue, vertex);
                vertex.setPreviousVertex(queue.peek());
                if (vertex.getName().equals(finishVertex)) {
                    //System.out.println("name " + vertex.getName());
                    return buildRoad(vertex);
                }
            }
        }

        resetVertexState();
        return null;
    }

    private Stack<String> buildRoad(Vertex vertex) {
        Stack<String> vertexStack = new Stack<>();
        Vertex currentVertex = vertex;
        while (currentVertex != null) {
            vertexStack.push(currentVertex.getName());
            //System.out.println(" "+ currentVertex.getName());
            currentVertex = currentVertex.getPreviousVertex();
        }

        return vertexStack;
    }


}
