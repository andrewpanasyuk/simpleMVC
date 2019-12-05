package com.example.simpleApp.controller;

import com.example.simpleApp.domain.Group;
import com.example.simpleApp.domain.Student;
import com.example.simpleApp.repos.GroupRepository;
import com.example.simpleApp.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Student> getAllStudents() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewStudent (@RequestParam String name, @RequestParam String email, @RequestParam String groupName) {
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        Group group = groupRepository.findByName(groupName);
        student.setGroup(group);
        studentRepository.save(student);
        return "Saved";
    }

    @PostMapping(path="/addGroup") // Map ONLY POST Requests
    public @ResponseBody String addNewGroup (@RequestParam String name) {
        Group group = new Group();
        group.setName(name);
        groupRepository.save(group);
        return "Group was Saved";
    }

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        return "main";
    }
}
