package fezhanka.decorator.service.client;

import fezhanka.decorator.dependency.DependencyLocal;

public class LocalClient {

    private final DependencyLocal local;

    public LocalClient(DependencyLocal local) {
        this.local = local;
    }

    public void saveToLocal(String path, Object obj) {
        local.saveToLocal(path, obj);
    }
}
