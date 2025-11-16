package edu.icet.form.service;

import edu.icet.form.model.dto.StudentDTO;
import edu.icet.form.model.enitity.Student;
import edu.icet.form.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    private Student mapToEntity(StudentDTO dto) {
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
    // save student
    public StudentDTO saveStudent(StudentDTO dto) {
        Student student = repository.save(mapToEntity(dto));
        return mapToDTO(student);
    }
    // get all students
    public List<StudentDTO> getAllStudents() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    // get student by id
    public StudentDTO getStudentById(String id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }
    // update student
    public StudentDTO updateStudent(String id, StudentDTO dto) {
        return repository.findById(id).map(existing -> {
            dto.setStudentId(id);
            Student updated = repository.save(mapToEntity(dto));
            return mapToDTO(updated);
        }).orElse(null);
    }
    // delete student
    public boolean deleteStudent(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

