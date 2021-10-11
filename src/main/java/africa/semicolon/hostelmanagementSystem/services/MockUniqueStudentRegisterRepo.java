package africa.semicolon.hostelmanagementSystem.services;

import africa.semicolon.hostelmanagementSystem.data.models.Student;
import africa.semicolon.hostelmanagementSystem.data.repositories.Repository;

import java.util.List;

public class MockUniqueStudentRegisterRepo implements Repository {
    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public Object findByName(String name) {
        return null;
    }

    @Override
    public Object save(Object o) {
        return o;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Object> findAll() {
        return null;
    }
}
