package fezhanka.decorator.delegates.decorator;

import fezhanka.decorator.delegates.AbstractJavaDelegate;
import fezhanka.decorator.delegates.decorator.data.Storage;

public abstract class BaseDecorator extends AbstractJavaDelegate {

    private final AbstractJavaDelegate wrappee;

    protected BaseDecorator(AbstractJavaDelegate abstractJavaDelegate) {
        this.wrappee = abstractJavaDelegate;
    }

    public Storage getStorage() {
        return wrappee.getStorage();
    }

    public <T>T getInput() {
        return wrappee.getInput();
    }

    public boolean isTraced() {
        return wrappee.isTraced();
    }

    public <T> T executeDecorator(Object input) {
        return wrappee.executeInternal(input);
    }
}
