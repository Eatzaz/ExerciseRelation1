package com.example.exerciserelation.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "the name cannot name")
    @Column(columnDefinition = "varchar(15) not null")
    private String name;
    @NotNull(message = "the age cannot name")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty(message = "the email cannot name")
    @Email
    private String email;
    @NotNull(message = "the salary cannot br null")
    @Column(columnDefinition = "int not null")
    private Integer Salary;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
private Address address;
}
