package com.example.Student_Library_System.Repository;

import com.example.Student_Library_System.Entity.Student;
import com.example.Student_Library_System.Enum.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByDepartment(Department department);

}

