package core.path;

import java.util.Vector;

public class Graph {
    public Vector<Vector<Edge>> edges;

    public Graph(int size){
        this.edges = new Vector<Vector<Edge>>();
        for (int i = 0; i <= size; i++) {
            this.edges.add(new Vector<Edge>());
        }
    }

    public void add(int vertexInit, int vertexEnd, int value){
        this.edges.get(vertexInit).add(new Edge(vertexEnd, value));
        this.edges.get(vertexEnd).add(new Edge(vertexInit, value));
    }

    public Vector<Vector<Edge>> getGraph(){
        return this.edges;
    }
}
