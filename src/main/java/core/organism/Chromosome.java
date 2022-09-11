package core.organism;

public class Chromosome {
    
    private String chromosome = "";
    private int distance = 0;

    public Chromosome(String chromosome){
        this.chromosome = chromosome;
    }

    public Chromosome(){}

    public int getSizeChromosome(){
        return this.chromosome.length();
    }

    public String getChromosome(){
        return this.chromosome;
    }

    public void setSizeChromosome(char genes){
        this.chromosome = this.chromosome + genes;
    }
    
    public int getDistance(){
        return this.distance;
    }

    public void setDistance(int distance){
        this.distance =  distance;
    }

    public Chromosome[] begetChildren(Chromosome parent, CrossoverType type){
        int positionCuttingInitial = Math.round(this.chromosome.length() / 2);
        Chromosome chromossomes[] = new Chromosome[2];

        //Pega os N / 2 primeiros genes do cromossomo atual
        StringBuilder builderFirstChildren = new StringBuilder();
        boolean visitedFirst[] = new boolean[parent.chromosome.length() + 1];
        for (int i = 0; i < positionCuttingInitial; i++) {
            int index = this.chromosome.charAt(i) - '0';
            builderFirstChildren.append(this.chromosome.charAt(i));
            visitedFirst[index] = true;
        }

        //Completa com os genes do parent que não estejam na solução
        for (int i = 0; i < parent.chromosome.length(); i++) {
            int index = parent.chromosome.charAt(i) - '0';
            if(!visitedFirst[index]){
                builderFirstChildren.append(parent.chromosome.charAt(i));
                visitedFirst[index] = true;
            }
        }
        chromossomes[0] = new Chromosome(builderFirstChildren.toString());

        //Pega os N / 2 primeiros genes do parent
        boolean visitedSecond[] = new boolean[parent.chromosome.length() + 1];
        StringBuilder builderSecondChildren = new StringBuilder();
        for (int i = 0; i < positionCuttingInitial; i++) {
            builderSecondChildren.append(parent.chromosome.charAt(i));
            visitedSecond[parent.chromosome.charAt(i) - '0'] = true;
        }

        //Completa com os genes do cromossomo atual que não estejam na solução
        for (int i = 0; i < this.chromosome.length(); i++) {
            int index = this.chromosome.charAt(i) - '0';
            if(!visitedSecond[index]){
                builderSecondChildren.append(this.chromosome.charAt(i));
                visitedSecond[index] = true;
            }
        }

        chromossomes[1] = new Chromosome(builderSecondChildren.toString());

        System.out.println("==============================================================");
        System.out.println("======================= Pais ===============================");
        System.out.println(this.chromosome +"  ====  "+ parent.chromosome);
        System.out.println("======================= Filhos ===============================");
        System.out.println(chromossomes[0].getChromosome() +"  ====  "+ chromossomes[1].getChromosome());
        System.out.println("==============================================================");
        return chromossomes;
    }
}
