package com.sms.StudentManagementSystem.Repository;

import com.sms.StudentManagementSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<Student, Integer> {
}
