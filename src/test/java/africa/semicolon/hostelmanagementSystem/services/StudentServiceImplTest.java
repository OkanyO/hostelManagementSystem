package africa.semicolon.hostelmanagementSystem.services;

import africa.semicolon.hostelmanagementSystem.data.models.Student;
import africa.semicolon.hostelmanagementSystem.data.repositories.StudentRepository;
import africa.semicolon.hostelmanagementSystem.dto.RegisterStudentRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {
   private StudentService  studentService;
   @Mock
   private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
     studentService = null;
    }

    @Test
    void registerUniqueStudentTest(){
     studentService  = new StudentServiceImpl(new MockUniqueStudentRegisterRepo());
        RegisterStudentRequest registerStudentRequest = new RegisterStudentRequest();
     registerStudentRequest.setFirstName("Okany");
     registerStudentRequest.setLastName("Emmanuel");
     registerStudentRequest.setMatricNumber("num990");
     registerStudentRequest.setPassword("nuel");
     registerStudentRequest.setUserName("okanynuel");
     //when
        Student savedStudent =  studentService.registerStudent(registerStudentRequest);
     assertThat(savedStudent.getMatricNumber(),is("num990"));
    }
    @Test
  void registerNonUniqueUserNameThrowException(){

     studentService  = new StudentServiceImpl(studentRepository);
        Mockito.when(studentRepository.save(any(Student.class))).thenReturn(new Student());

     RegisterStudentRequest registerStudentRequest = new RegisterStudentRequest();
     registerStudentRequest.setFirstName("Okany");
     registerStudentRequest.setLastName("Emmanuel");
     registerStudentRequest.setMatricNumber("num990");
     registerStudentRequest.setPassword("nuel");
     registerStudentRequest.setUserName("okanynuel");

        studentService.registerStudent(registerStudentRequest);



        //when



 Mockito.when(studentRepository.findByName("okanynuel")).thenReturn(new Student());
        assertThrows(IllegalArgumentException.class,()->studentService.registerStudent(registerStudentRequest),"Matric number is not unique");
    }
}