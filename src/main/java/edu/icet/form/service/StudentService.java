package edu.icet.form.service;

import edu.icet.form.model.dto.StudentDTO;
import edu.icet.form.model.enitity.Student;
import edu.icet.form.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    //Convert DTO to Entity and vice versa methods can be added here

        private StudentDTO mapToDTO(Student student) {
        return new StudentDTO(
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhone(),
                student.getGender(),
                student.getDob(),
                student.getAddress(),
                student.getCourse(),
                student.getRegistrationDate(),
                student.getStatus(),
                student.getNotes()
        );
    }
    private Student mapToEntity(StudentDTO dto){
        return new Student(
                dto.getStudentId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getGender(),
                dto.getDob(),
                dto.getAddress(),
                dto.getCourse(),
                dto.getRegistrationDate(),
                dto.getStatus(),
                dto.getNotes()
        );
    }
}

