package fezhanka.decorator.service.client;

import fezhanka.decorator.dependency.DependencyS3;

public class S3Client {

    public static final String CONTAINER = "local";

    private final DependencyS3 dependencyS3;

    public S3Client(DependencyS3 dependencyS3) {

        this.dependencyS3 = dependencyS3;
    }

    public String save(String fileName) {
        return dependencyS3.saveToS3(CONTAINER, fileName);
    }
}
