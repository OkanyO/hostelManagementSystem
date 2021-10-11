package africa.semicolon.hostelmanagementSystem.services;

import africa.semicolon.hostelmanagementSystem.data.models.Student;
import africa.semicolon.hostelmanagementSystem.data.repositories.Repository;
import africa.semicolon.hostelmanagementSystem.dto.RegisterStudentRequest;


public class StudentServiceImpl implements StudentService{
    private Repository studentRepository;
    public StudentServiceImpl(Repository repository){
        this.studentRepository = repository;
    }

    @Override
    public Student registerStudent(RegisterStudentRequest studentDto){
        Student optionalStudent =(Student) studentRepository.findById(studentDto.getMatricNumber());
  if(optionalStudent != null){
      throw new IllegalArgumentException("Matric Number Not Unique");
  }
  optionalStudent= (Student)  studentRepository.findByName(studentDto.getUserName());
  if(optionalStudent!= null){
      throw new IllegalArgumentException("Matric Number Not Unique");
  }
        Student newStudent = new Student();
        newStudent.setFirstName(studentDto.getFirstName());
        newStudent.setLastName(studentDto.getLastName());
        newStudent.setPassword(studentDto.getPassword());
        newStudent.setUserName(studentDto.getUserName());
        newStudent.setMatricNumber(studentDto.getMatricNumber());
        studentRepository.findById(studentDto.getMatricNumber());
        return (Student) studentRepository.save(newStudent);

    }
}
