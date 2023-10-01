package fezhanka.decorator.dependency;

public class DependencyLocal {

    public void saveToLocal(String path, Object obj) {
        System.out.printf("saved to Local directory: %s with name %s%n", path, obj);
    }
}
