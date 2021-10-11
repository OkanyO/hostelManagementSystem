package africa.semicolon.hostelmanagementSystem.data.repositories;

import africa.semicolon.hostelmanagementSystem.data.models.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
class StudentRepositoryTest {
 private Repository repository;
    @BeforeEach
    void setUp() {
        repository = new StudentRepository();
    }

    @AfterEach
    void tearDown() {
        repository = null;
    }

    @Test
    void findById() {
        Student student = new Student();
        student.setFirstName("onyeka");
        student.setFirstName("emmanuel");
        student.setMatricNumber("num990");
        student.setUserName("NUEL");
        student.setPassword("NUEL909");
        repository.save(student);
        Student returnedStudent = (Student)repository.findById("num990");
        assertThat(returnedStudent, is(student));
    }

    @Test
    void save() {
        Student student = new Student();
        student.setFirstName("onyeka");
        student.setFirstName("emmanuel");
        student.setMatricNumber("num990");
        student.setUserName("NUEL");
        student.setPassword("NUEL909");
        Student savedStudent = (Student)repository.save(student);
        assertThat(savedStudent, is(student));

    }

    @Test
    void findByName() {
        Student student = new Student();
        student.setFirstName("onyeka");
        student.setFirstName("emmanuel");
        student.setMatricNumber("num990");
        student.setUserName("NUEL");
        student.setPassword("NUEL909");
        repository.save(student);
        Student findStudent = (Student)repository.findByName("NUEL");



    }

    @Test
    void delete() {
        Student student = new Student();
        student.setFirstName("onyeka");
        student.setLastName("emmanuel");
        student.setMatricNumber("num990");
        student.setUserName("NUEL");
        student.setPassword("NUEL909");
        repository.save(student);
        repository.delete("num990");
        Student deletedStudent = (Student)repository.findById("num990");
        assertThat(deletedStudent, is(nullValue()));
    }

    @Test
    void testDelete() {
        Student student = new Student();
        student.setFirstName("onyeka");
        student.setLastName("emmanuel");
        student.setMatricNumber("num990");
        student.setUserName("NUEL");
        student.setPassword("NUEL909");
        repository.save(student);
        repository.delete("num990");
        Student deletedStudent = (Student)repository.findById("num990");
        assertThat(deletedStudent, is(nullValue()));
    }

    @Test
    void findAll() {
        Student student = new Student();
        student.setFirstName("onyeka");
        student.setFirstName("emmanuel");
        student.setMatricNumber("num990");
        student.setUserName("NUEL");
        student.setPassword("NUEL909");
        repository.save(student);

        Student student2 = new Student();
        student.setFirstName("onyeka");
        student.setFirstName("emmanuel");
        student.setMatricNumber("num990");
        student.setUserName("NUEL");
        student.setPassword("NUEL909");
        repository.save(student2);
        List<Object> allStudents = repository.findAll();
        assertThat(allStudents.size(), is(2));
        assertThat(allStudents, contains(student,student2));
    }
}