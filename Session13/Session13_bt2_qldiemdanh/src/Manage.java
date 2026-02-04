public interface Manage<T> {
    void add(T item);
    void update(int id, String newName);
    void delete(int id);
    void display();
}
