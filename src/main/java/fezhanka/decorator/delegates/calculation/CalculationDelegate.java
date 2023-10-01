package fezhanka.decorator.delegates.calculation;

import fezhanka.decorator.delegates.AbstractJavaDelegate;
import fezhanka.decorator.delegates.decorator.data.Storage;

import java.util.Map;
import java.util.Optional;

public class CalculationDelegate extends AbstractJavaDelegate {

    public static final double MILK = 0.10;
    public static final double SOY = 0.11;
    public static final double BEER = 1.30;

    @Override
    @SuppressWarnings("unchecked")
    public <T> T executeInternal(Object input) {
        return (T) calculatePrice(input);
    }

    @Override
    public boolean isTraced() {
        return true;
    }

    @Override
    public Storage getStorage() {
        return Storage.S3;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> getInput() {
        System.out.println("get input from delegate");
        return Map.of("key", "value");
    }

    private Optional<String> calculatePrice(Object input) {
        System.out.printf("Calculate %s%n", MILK);
        System.out.printf("Calculate %s%n", BEER);
        System.out.printf("Calculate %s%n", SOY);
        return Optional.empty();
    }
}
