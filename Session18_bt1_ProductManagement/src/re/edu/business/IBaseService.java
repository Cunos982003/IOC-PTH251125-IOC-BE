package re.edu.business;

import java.util.List;

public interface IBaseService<T,ID> {
    void save(T t);
    void update(T t);
    void delete(ID id);
    T findById(ID id);
    List<T> findAll();
}

