package com.mediawave.mediawave.controller;


import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediawave.mediawave.model.Student;
import com.mediawave.mediawave.service.MediawaveService;

@RestController

public class MediawaveController {
    public MediawaveService service;
    public MediawaveController(MediawaveService service){
        this.service = service;
    }
    @PostMapping("/")
    public String createStudent(@RequestBody Student student) throws InterruptedException, ExecutionException{
        return service.createrStudent(student);
    }

    @GetMapping("/")
    public List<Student> getAllStudents() throws InterruptedException, ExecutionException {
        return service.getAllStudents();
    }

    @GetMapping("/student")
    public Student getStudentById(@RequestParam String id) throws InterruptedException, ExecutionException {
        return service.getStudentById(id);
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student) throws InterruptedException, ExecutionException {
        return service.updateStudent(student);
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam String id) throws InterruptedException, ExecutionException {
        return service.deleteStudent(id);
    }
}