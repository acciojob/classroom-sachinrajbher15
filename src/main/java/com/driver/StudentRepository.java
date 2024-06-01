package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void addStudent(Student student){
        // your code goes here
        studentMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
        // your code goes here
        teacherMap.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            // your code goes here
            studentMap.put(student,studentMap.get(student));
            teacherMap.put(teacher,teacherMap.get(teacher));
            List<String> students = new ArrayList<String>();
            if(teacherStudentMapping.containsKey(teacher)){
                students = teacherStudentMapping.get(teacher);
            }
            students.add(student);
            teacherStudentMapping.put(teacher,students);
        }
    }

    public Student findStudent(String student){
        // your code goes here
        return studentMap.get(student);
    }

    public Teacher findTeacher(String teacher){
        // your code goes here
        return teacherMap.get(teacher);
    }

    public List<String> listOfStudents(String teacher){
        // your code goes here
        // find student list corresponding to a teacher
        List<String> studentList = new ArrayList<>();
        if(teacherStudentMapping.containsKey(teacher)){
            studentList = teacherStudentMapping.get(teacher);
        }
        return studentList;
    }

    public List<String> getAllStudents(){
        // your code goes here
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher){
        // your code goes here
        List<String> students = new ArrayList<>();
        if(teacherStudentMapping.containsKey(teacher)){
            students = teacherStudentMapping.get(teacher);
            for(String student : students){
                if(studentMap.containsKey(teacher)){
                    studentMap.remove(student);
                }
            }
            teacherStudentMapping.remove(teacher);
        }
        if(teacherMap.containsKey(teacher)){
            teacherMap.remove(teacher);
        }
    }

    public void deleteAllTeachers(){
        // your code goes here
        HashSet<String> studentList = new HashSet<String>();
        for(String teacher : teacherStudentMapping.keySet()){
            for(String student : teacherStudentMapping.get(teacher)){
                studentList.add(student);
            }
        }
        for(String student : studentList){
            if(studentMap.containsKey(student)){
                studentMap.remove(student);
            }
        }
    }
}
