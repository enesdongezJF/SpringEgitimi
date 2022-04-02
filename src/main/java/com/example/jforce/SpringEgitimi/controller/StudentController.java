package com.example.jforce.SpringEgitimi.controller;

import com.example.jforce.SpringEgitimi.modal.Student;
import com.example.jforce.SpringEgitimi.modal.StudentResponse;
import com.example.jforce.SpringEgitimi.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class StudentController {

    @Autowired
    private IStudentService studentDao;

    @RequestMapping(path = "/students" , method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudentListesi(){
        List<Student> students = studentDao.getStudentList();
        return ResponseEntity.ok(students);
    }

    @RequestMapping(path = "/student/{id}" , method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentByID(@PathVariable("id") Integer id){
        Student student = studentDao.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @RequestMapping(path = "/save" , method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody Student student) {
        StudentResponse response = studentDao.save(student);
        return ResponseEntity.ok(response.getMessage());
    }

    @RequestMapping(path = "/updateName", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestParam("id") Integer id,@RequestParam("name") String name){
        StudentResponse response = studentDao.update(id,name);
        return ResponseEntity.ok(response.getMessage());
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        StudentResponse response = studentDao.delete(id);
        return ResponseEntity.ok(response.getMessage());
    }

}
