package fezhanka.decorator.service;

import fezhanka.decorator.service.client.LocalClient;


public class LocalDatabaseService {

    private final LocalClient localClient;

    public LocalDatabaseService(LocalClient localClient) {
        this.localClient = localClient;
    }

    public void save(String path, Object object) {
        System.out.println("trace service call");
        localClient.saveToLocal(path, object);
    }
}
