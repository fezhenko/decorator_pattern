package fezhanka.decorator.dependency;

public class DependencyS3 {

    public String saveToS3(String bucketName, String fileName) {
        return "saved to S3 bucket: %s with name %s".formatted(bucketName, fileName);
    }
}
