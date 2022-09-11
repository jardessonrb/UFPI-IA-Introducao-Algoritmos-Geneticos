package core;

import core.organism.Chromosome;
import core.organism.Organism;
import core.path.Graph;
import core.run.Environment;

public class App 
{
    public static void main( String[] args )
    {
        Organism organism = new Organism();
        Environment environment = new Environment();

        Chromosome[] population = organism.getPopulation(8, 5, 5);

        Graph graph = new Graph(5);
        graph.add(1, 2, 2);
        graph.add(1, 5, 6);
        graph.add(1, 4, 3);
        graph.add(2, 4, 3);
        graph.add(2, 3, 4);
        graph.add(3, 4, 7);
        graph.add(3, 5, 3);
        graph.add(5, 4, 3);

        System.out.println("População gerada");
        for (Chromosome chromosome : population) {
            System.out.println("Individuo: "+chromosome.getChromosome()+" -> "+chromosome.getDistance());
        }

        System.out.println("População com caminhos completos");
        Chromosome[] populationBestAdapted = environment.selectionTheBestAdapted(population, graph);
        for (Chromosome chromosome : populationBestAdapted) {
            System.out.println("Individuo: "+chromosome.getChromosome() +" -> "+chromosome.getDistance());
        }
    }
}
