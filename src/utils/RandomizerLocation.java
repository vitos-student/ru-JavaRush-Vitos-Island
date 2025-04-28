package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizerLocation {

    public int nextInt(int stepAnimal) {
        return ThreadLocalRandom.current().nextInt(3);
    }
}
