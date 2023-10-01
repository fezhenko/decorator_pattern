package fezhanka.decorator.service;

import fezhanka.decorator.service.client.S3Client;

public class S3Service {

    private final S3Client s3Client;


    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public String save(String fileName) {
        return s3Client.save(fileName);
    }
}
