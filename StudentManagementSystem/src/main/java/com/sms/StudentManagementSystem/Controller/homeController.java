package com.sms.StudentManagementSystem.Controller;

import com.sms.StudentManagementSystem.Entity.Student;
import com.sms.StudentManagementSystem.Service.StudentServ;
import com.sms.StudentManagementSystem.ServiceImple.serImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class homeController {

    private serImpl serv;

    @Autowired
    public homeController(serImpl serv){
        this.serv = serv;
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/students")
    public String getStudentsPage(Model model) {
        model.addAttribute("Student", serv.getAllStudent());
        return "Student";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        var student= new Student();
        model.addAttribute("Student",student);
        return "create-student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("Student") Student student){
        serv.saveStudent(student);
        return"redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable int id, Model model){
       // var student = model.addAttribute("Student", serv.getAllStudent());
        model.addAttribute("Student", serv.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable int id,@ModelAttribute("Student") Student student){
        Student existingStudent = serv.getStudentById(id);

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        serv.saveStudent(existingStudent);
        return "redirect:/students";

    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        serv.deleteStudentById(id);
        return "redirect:/students";
    }
}
