//Genetics
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GeneticAlgorithm {
    private static final int POPULATION_SIZE = 100;
    private static final String GENES = 
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890, .;:_!\"#%&/()=?@${[]}";
    private static final String TARGET = "I love Managoes";

    private static int randomNum(int start, int end) {
        Random rand = new Random();
        return rand.nextInt(end - start + 1) + start;
    }

    private static char mutatedGenes() {
        int len = GENES.length();
        int r = randomNum(0, len - 1);
        return GENES.charAt(r);
    }

    private static String createGnome() {
        int len = TARGET.length();
        StringBuilder gnome = new StringBuilder();
        for (int i = 0; i < len; i++)
            gnome.append(mutatedGenes());
        return gnome.toString();
    }

    private static class Individual implements Comparable<Individual> {
        String chromosome;
        int fitness;

        Individual(String chromosome) {
            this.chromosome = chromosome;
            fitness = calFitness();
        }

        Individual mate(Individual par2) {
            StringBuilder childChromosome = new StringBuilder();
            int len = chromosome.length();
            for (int i = 0; i < len; i++) {
                float p = randomNum(0, 100) / 100f;
                if (p < 0.45)
                    childChromosome.append(chromosome.charAt(i));
                else if (p < 0.90)
                    childChromosome.append(par2.chromosome.charAt(i));
                else
                    childChromosome.append(mutatedGenes());
            }
            return new Individual(childChromosome.toString());
        }

        private int calFitness() {
            int len = TARGET.length();
            int fitness = 0;
            for (int i = 0; i < len; i++) {
                if (chromosome.charAt(i) != TARGET.charAt(i))
                    fitness++;
            }
            return fitness;
        }

        @Override
        public int compareTo(Individual o) {
            return Integer.compare(this.fitness, o.fitness);
        }
    }

    public static void main(String[] args) {
        int generation = 0;
        List<Individual> population = new ArrayList<>();
        boolean found = false;

        for (int i = 0; i < POPULATION_SIZE; i++) {
            String gnome = createGnome();
            population.add(new Individual(gnome));
        }

        while (!found) {
            Collections.sort(population);

            if (population.get(0).fitness <= 0) {
                found = true;
                break;
            }

            List<Individual> newGeneration = new ArrayList<>();

            int s = (10 * POPULATION_SIZE) / 100;
            for (int i = 0; i < s; i++)
                newGeneration.add(population.get(i));

            s = (90 * POPULATION_SIZE) / 100;
            for (int i = 0; i < s; i++) {
                int r = randomNum(0, 50);
                Individual parent1 = population.get(r);
                r = randomNum(0, 50);
                Individual parent2 = population.get(r);
                Individual offspring = parent1.mate(parent2);
                newGeneration.add(offspring);
            }

            population = newGeneration;
            System.out.print("Generation: " + generation + "\t");
            System.out.print("String: " + population.get(0).chromosome + "\t");
            System.out.println("Fitness: " + population.get(0).fitness);
            generation++;
        }
    }
}

  System.out.print("Generation: " + generation + "\t");  
  System.out.print("String: " + population.get(0).chromosome + "\t");  
  System.out.println("Fitness: " + population.get(0).fitness);  
 }  
} 
