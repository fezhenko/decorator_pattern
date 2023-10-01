package fezhanka.decorator.service;

import fezhanka.decorator.service.client.AzureClient;

public class BlobStorageService {

    private final AzureClient azureClient;

    public BlobStorageService(AzureClient azureClient) {
        this.azureClient = azureClient;
    }

    public String save(String filename) {
        return azureClient.save(filename);
    }
}
