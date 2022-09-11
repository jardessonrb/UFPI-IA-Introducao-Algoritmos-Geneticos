package core.organism;

import java.util.Random;

public class Organism {
    
    public Chromosome[] getPopulation(int size, int chromosomeLength, int end){
        Chromosome[] population = new Chromosome[size];
        char[] path = new char[chromosomeLength+1];

        for (int i = 0; i < end; i++) {
            path[i] = (char)((i+1)+'0');
            //System.out.print(path[i]+" ");
        }

        int i = 0;
        while(i < size){
            Chromosome chromosome = createChromosome(chromosomeLength, end, path);
            if(isValidChromossome(chromosome)){
                population[i] = chromosome;
                i++;
            }
        }
        
        return population;
    }

    public boolean isValidChromossome(Chromosome chromosome){
        boolean check[] = new boolean[chromosome.getChromosome().length() + 1];
        for (int i = 0; i < chromosome.getChromosome().length(); i++) {
            int verticeOfChromossome = chromosome.getChromosome().charAt(i) - '0';
            if(check[verticeOfChromossome]){
                return false;
            }
            check[verticeOfChromossome] = true;
        }
        return true;
    }
    
    public Chromosome createChromosome(int chromosomeLength, int end, char[] path){
        Random random = new Random();
        Chromosome chromosome = new Chromosome();

        while(chromosome.getSizeChromosome() < chromosomeLength){
            int positionGenes =  random.nextInt(end);
            chromosome.setSizeChromosome(path[positionGenes]);
        }

        return chromosome;
    }

}
