package fezhanka.decorator.delegates.decorator.data;

import fezhanka.decorator.delegates.AbstractJavaDelegate;
import fezhanka.decorator.delegates.decorator.BaseDecorator;
import fezhanka.decorator.service.LocalDatabaseService;

public class TraceStorage extends BaseDecorator {
    private final LocalDatabaseService localDatabaseService;

    public TraceStorage(
            AbstractJavaDelegate abstractJavaDelegate,
            LocalDatabaseService localDatabaseService
    ) {
        super(abstractJavaDelegate);
        this.localDatabaseService = localDatabaseService;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object executeInternal(Object input) {
        return save(input);
    }

    private Object save(Object input) {
        Object object = executeDecorator(input);
        if (isTraced() && object != null) {
            localDatabaseService.save("trace", object);
        }
        return object;
    }
}
