package com.sms.StudentManagementSystem.Service;

import com.sms.StudentManagementSystem.Entity.Student;

import java.util.List;
public interface StudentServ {
    public List<Student> getAllStudent();

    public Student saveStudent(Student student);

    public Student getStudentById(int id);

    public void deleteStudentById(int id);

}
