package pl.coderslab.collection;

import java.util.*;

public class GenerateRandom {

    public static void main(String[] args) {
        Map<Integer, Integer> randIntegerMap = checkRand(1000000, 10);

        System.out.println("\nMapa: ");
        Set<Integer> numbers = randIntegerMap.keySet();
        for (Object number : numbers) {
            System.out.print(number + "\t - ");
            System.out.print(randIntegerMap.get(number) + "\n");
        }


    }


    public static Map<Integer, Integer> checkRand(int amount, int interval) {
        Map<Integer, Integer> map = new TreeMap<>();
        Random rand = new Random();
        int randNumber;
        for (int i = 0; i < amount; i++) {
            randNumber = rand.nextInt(interval);
            if (!map.containsKey(randNumber)) {
                map.put(randNumber, 1);
            } else {
                map.put(randNumber, map.get(randNumber) + 1);
            }
        }
        return map;
    }


}
