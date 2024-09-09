package com.sms.StudentManagementSystem.ServiceImple;

import com.sms.StudentManagementSystem.Entity.Student;
import com.sms.StudentManagementSystem.Repository.studentRepo;
import com.sms.StudentManagementSystem.Service.StudentServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serImpl implements StudentServ {
    @Autowired
    private studentRepo stud;
    @Override
    public List<Student> getAllStudent() {
        List<Student> list = stud.findAll();
        return list;
    }

    @Override
    public Student saveStudent(Student student) {
        var student1 = stud.save(student);
        return student1;
    }

    @Override
    public Student getStudentById(int id) {
        return stud.findById(id).get();
    }

    @Override
    public void deleteStudentById(int id) {
       /* Optional<Student> student = stud.findById(id);
        if (student.isPresent()) {
            stud.deleteById(id);
            return student.get();
        }
        return null;*/
        stud.deleteById(id);
    }


}
