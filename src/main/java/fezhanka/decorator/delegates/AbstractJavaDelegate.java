package fezhanka.decorator.delegates;

import fezhanka.decorator.delegates.decorator.data.Storage;
import fezhanka.decorator.dependency.JavaDelegate;

import java.util.Map;

public abstract class AbstractJavaDelegate implements JavaDelegate {

    public abstract <T> T executeInternal(Object input);

    public abstract boolean isTraced();

    public abstract Storage getStorage();

    public abstract <T> T getInput();

    @Override
    public void execute() {
        try {
            executeInternal(Map.of("key", "value"));
        } catch (RuntimeException e) {
            System.out.println("error");
        }
    }
}
