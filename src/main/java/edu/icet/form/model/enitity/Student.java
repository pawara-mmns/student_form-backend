package edu.icet.form.model.enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private String studentId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String gender;

    private LocalDate dob;

    private String address;

    private String course;

    private LocalDate registrationDate;

    private String status;

    private String notes;
}
