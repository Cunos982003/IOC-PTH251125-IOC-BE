public interface Manage <T>{
    void add(T item);
    void update(String code, T item);
    void delete(String code);
    void display();
}
