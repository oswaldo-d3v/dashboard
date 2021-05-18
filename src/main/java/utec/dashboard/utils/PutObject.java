package utec.dashboard.utils;

public class PutObject<T> {
    private T obj;

    public PutObject(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
