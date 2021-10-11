package africa.semicolon.hostelmanagementSystem.data.repositories;

import africa.semicolon.hostelmanagementSystem.data.models.Student;

import java.util.*;

public class StudentRepository implements Repository{
    private Map<String, Student> studentDatabase = new HashMap<>();
    @Override
    public Object findById(String id) {
        return  studentDatabase.get(id);
    }
    @Override
    public Object save(Object o) {
  Student studentToSave = (Student) o;
  studentDatabase.put(studentToSave.getMatricNumber(),studentToSave);
  return studentToSave;
    }

    @Override
    public Object findByName(String name) {
        return studentDatabase.get(name);
    }



    @Override
    public void delete(Object o) {
        delete(((Student)o ).getMatricNumber());

    }

    @Override
    public void delete(String id) {
        studentDatabase.remove(id);


    }

    @Override
    public List<Object> findAll() {
        List<Object>allStudents = new ArrayList<>();
        Set<String> matricNumbers = studentDatabase.keySet();

        for(String matricNumber : matricNumbers){
            allStudents.add(studentDatabase.get(matricNumber));
        }
        return allStudents;
    }
}
