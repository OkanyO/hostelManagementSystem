package africa.semicolon.hostelmanagementSystem.services;

import africa.semicolon.hostelmanagementSystem.data.models.Student;
import africa.semicolon.hostelmanagementSystem.dto.RegisterStudentRequest;

public interface StudentService {
    Student registerStudent(RegisterStudentRequest studentDto);
}
