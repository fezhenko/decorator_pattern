package fezhanka.decorator.service.client;

import fezhanka.decorator.dependency.DependencyAzure;

public class AzureClient {

    public static final String CONTAINER = "local";

    private final DependencyAzure dependencyAzure;

    public AzureClient(DependencyAzure dependencyAzure) {

        this.dependencyAzure = dependencyAzure;
    }

    public String save(String fileName) {
        return dependencyAzure.saveToAzure(CONTAINER, fileName);
    }
}
