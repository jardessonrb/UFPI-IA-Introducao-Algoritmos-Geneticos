package core.run;

import java.util.Arrays;

import core.organism.Chromosome;
import core.path.Edge;
import core.path.Graph;

public class Environment {
    private Graph graph = null;
    private boolean edgesExists[][] = new boolean[100][100];
    private int edgesDistance[][] = new int[100][100];

    public Chromosome[] selectionTheBestAdapted(Chromosome[] population, Graph graph){
        this.graph = graph;
        Chromosome[] chromosomes = new Chromosome[population.length];
        int j = 0;
        for (int i = 0; i < population.length; i++) {
            Chromosome chromosomeValid =  isCompletChromosome(population[i]);
            if(chromosomeValid !=  null){
                chromosomes[j++] = chromosomeValid;
            }
        }

        return Arrays.copyOf(chromosomes, j);
    }

    public Chromosome isCompletChromosome(Chromosome chromosome){
        for (int i = 0; i < chromosome.getSizeChromosome(); i++) {
            int verticeInit = chromosome.getChromosome().charAt(i) - '0';
            if(i + 1 < chromosome.getSizeChromosome()){
                int verticeEnd = chromosome.getChromosome().charAt(i + 1) - '0';
                if(edgesExists[verticeInit][verticeEnd]){
                    chromosome.setDistance(chromosome.getDistance() + edgesDistance[verticeInit][verticeEnd]);
                }else{
                    int distance = existEdge(verticeInit, verticeEnd);
                    if(distance < 0){
                        return null;
                    }

                    chromosome.setDistance(chromosome.getDistance() + distance);
                }

            }else if(i + 1 >= chromosome.getSizeChromosome()) break;

        }

        return chromosome;
    }

    public int existEdge(int verticeInit, int verticeEnd){
        int distance = -1;
        for(Edge edge : this.graph.getGraph().get(verticeInit)) {
            edgesExists[verticeInit][edge.vertex] = true;
            edgesExists[edge.vertex][verticeInit] = true;

            edgesDistance[edge.vertex][verticeInit] = edge.value;
            edgesDistance[verticeInit][edge.vertex] = edge.value;

            if(edge.vertex == verticeEnd){
                distance = edge.value;
            }
        }

        return distance;
    }
}
