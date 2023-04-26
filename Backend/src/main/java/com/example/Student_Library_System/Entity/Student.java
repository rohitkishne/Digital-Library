package com.example.Student_Library_System.Entity;

import com.example.Student_Library_System.Enum.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Department department;
    private String mobNo;

    private String Email;

    @OneToOne(mappedBy="student", cascade = CascadeType.ALL)
    private Card card;
}
