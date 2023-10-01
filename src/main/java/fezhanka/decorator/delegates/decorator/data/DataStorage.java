package fezhanka.decorator.delegates.decorator.data;

import fezhanka.decorator.delegates.AbstractJavaDelegate;
import fezhanka.decorator.delegates.decorator.BaseDecorator;
import fezhanka.decorator.service.BlobStorageService;
import fezhanka.decorator.service.S3Service;

import java.util.Optional;

public class DataStorage extends BaseDecorator {

    private final BlobStorageService blobStorageService;
    private final S3Service s3Service;

    public DataStorage(
            AbstractJavaDelegate abstractJavaDelegate,
            BlobStorageService blobStorageService,
            S3Service s3Service) {
        super(abstractJavaDelegate);
        this.blobStorageService = blobStorageService;
        this.s3Service = s3Service;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T executeInternal(Object input) {
        return (T) save(input);
    }

    private Optional<String> save(Object input) {

        Optional<String> logicExecutionResult = executeDecorator(input);
        if (getStorage() == Storage.BLOB_STORAGE) {
            return Optional.of(blobStorageService.save("azure storage"));

        } else if (getStorage() == Storage.NONE) {
            return Optional.empty();
        }

        return Optional.of(s3Service.save("s3 storage"));
    }
}
