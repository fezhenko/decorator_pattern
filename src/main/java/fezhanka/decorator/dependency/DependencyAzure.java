package fezhanka.decorator.dependency;

public class DependencyAzure {

    public String saveToAzure(String containerName, String fileName) {
        return "saved to Azure container: %s with name %s".formatted(containerName, fileName);
    }
}
