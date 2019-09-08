public class Vertex {
    private final String name;
    private boolean visited;
    private Vertex previousVertex;

    public Vertex(String name){
        this.name = name;
        this.visited = false;
    }


    public String getName() {
        return name;
    }

    public boolean getVisited(){
        return visited;
    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }

    public Vertex getPreviousVertex(){
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex){
        this.previousVertex = previousVertex;
    }
}
