package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        studentRepository.addStudentTeacherPair(student, teacher);
    }

    public Student findStudent(String studentName){
        return studentRepository.findStudent(studentName);
    }

    public Teacher findTeacher(String teacherName){
        return studentRepository.findTeacher(teacherName);
    }

    public List<String> listOfStudents(String teacher){
        return studentRepository.listOfStudents(teacher);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacher(String teacher){
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}