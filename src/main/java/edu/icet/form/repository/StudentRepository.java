package edu.icet.form.repository;

import edu.icet.form.model.enitity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String>{
}
