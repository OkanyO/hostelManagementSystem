package africa.semicolon.hostelmanagementSystem.data.repositories;

import java.util.List;

public interface Repository {

    Object findById(String id);
    Object findByName(String name);
    Object save(Object o);
    void delete(Object o);
    void delete(String id);
    List<Object> findAll();
}
