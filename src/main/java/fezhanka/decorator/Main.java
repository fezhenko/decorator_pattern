package fezhanka.decorator;

import fezhanka.decorator.delegates.AbstractJavaDelegate;
import fezhanka.decorator.delegates.calculation.CalculationDelegate;
import fezhanka.decorator.delegates.decorator.data.TraceStorage;
import fezhanka.decorator.delegates.decorator.input.MapInput;
import fezhanka.decorator.dependency.DependencyAzure;
import fezhanka.decorator.dependency.DependencyLocal;
import fezhanka.decorator.dependency.DependencyS3;
import fezhanka.decorator.service.BlobStorageService;
import fezhanka.decorator.service.LocalDatabaseService;
import fezhanka.decorator.service.S3Service;
import fezhanka.decorator.service.client.AzureClient;
import fezhanka.decorator.service.client.LocalClient;
import fezhanka.decorator.service.client.S3Client;

public class Main {
    public static void main(String[] args) {

        BlobStorageService blobStorageService = new BlobStorageService(new AzureClient(new DependencyAzure()));
        S3Service s3Service = new S3Service(new S3Client(new DependencyS3()));
        LocalDatabaseService localDatabaseService = new LocalDatabaseService(new LocalClient(new DependencyLocal()));

        // get input from calc delegate
        MapInput mapInput = new MapInput(new CalculationDelegate());


        AbstractJavaDelegate wrapped = new TraceStorage(
                mapInput,
                localDatabaseService
        );

        wrapped.execute();
    }
}
