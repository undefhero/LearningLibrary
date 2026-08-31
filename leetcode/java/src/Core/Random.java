package Core;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.random.RandomGenerator.SplittableGenerator;

public class Random {
    RandomGenerator random;
    RandomGeneratorFactory<RandomGenerator> factory;
    SplittableGenerator splittableGenerator;

    public Random() {
        this.random = RandomGenerator.of("Random");
        this.factory = RandomGeneratorFactory.of("SecureRandom");
        RandomGeneratorFactory<SplittableGenerator> splitableFactory =
                RandomGeneratorFactory.of("L128X1024MixRandom");
        this.splittableGenerator = splitableFactory.create();
    }

    public RandomGenerator getRandom() {
        return this.random;
    }

    public RandomGeneratorFactory getFactory() {
        return this.factory;
    }

    public SplittableGenerator getSplittableGenerator() {
        return this.splittableGenerator;
    }

}
