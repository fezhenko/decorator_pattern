package fezhanka.decorator.delegates.decorator.input;

import fezhanka.decorator.delegates.AbstractJavaDelegate;
import fezhanka.decorator.delegates.decorator.BaseDecorator;

public class MapInput extends BaseDecorator {

    public MapInput(AbstractJavaDelegate abstractJavaDelegate) {
        super(abstractJavaDelegate);
    }

    @Override
    public <T> T executeInternal(Object input) {
        return getInput();
    }
}
