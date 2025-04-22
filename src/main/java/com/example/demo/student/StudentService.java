package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository =  studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
             throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id: " + studentId + " does not exists!");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent (Long studentId, Student student){
        String name = student.getName();
        String email = student.getEmail();
        student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exists!"));
        System.out.println(studentId);
        System.out.println(name);
        System.out.println(email);

        if(name != null && !name.isEmpty() && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken!");
            }
            student.setEmail(email);
        }

    }
}
