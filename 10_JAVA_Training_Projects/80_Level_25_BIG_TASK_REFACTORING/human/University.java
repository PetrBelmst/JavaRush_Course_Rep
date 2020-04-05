package com.company.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student student = null;
        for (Student element : students) {
            if (element.getAverageGrade() == averageGrade) {
                student = element;
            }
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student student = null;
        double maxAveGrade = 0;
        for (Student element : students) {
            if (element.getAverageGrade() >= maxAveGrade) {
                maxAveGrade = element.getAverageGrade();
                student = element;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        Student student = null;
        double minAveGrade = students.get(0).getAverageGrade();
        for (Student element : students) {
            if (element.getAverageGrade() < minAveGrade) {
                minAveGrade = element.getAverageGrade();
                student = element;
            }
        }
        return student;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}

/*
Рефакторинг (6)
public Student getStudentWithAverageGrade(double averageGrade) {
        Student student = null;
        for (Student element : students) {
            if (element.getAverageGrade() == averageGrade) {
                student = element;
            }
        }
        return student;
    }

public Student getStudentWithMaxAverageGrade() {
        Student student = null;
        double maxAveGrade = 0;
        for (Student element : students) {
            if (element.getAverageGrade() >= maxAveGrade) {
                maxAveGrade = element.getAverageGrade();
                student = element;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        Student student = null;
        double minAveGrade = students.get(0).getAverageGrade();
        for (Student element : students) {
            if (element.getAverageGrade() < minAveGrade) {
                minAveGrade = element.getAverageGrade();
                student = element;
            }
        }
        return student;
    }

    public void expel(Student student) {
        students.remove(student);
    }

 */

/*
Рефакторинг (4)
private List<Student> students = new ArrayList<>();
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }
 */

/*
public class University extends Student {

    public University(String name, int age) {
        super(name, age, 0);
    }

    public Student getStudentWithAverageGrade() {
        //TODO:
        return null;
    }

    public Student getStudentWithMaxAverageGrade(double averageGrade) {
        //TODO:
        return null;
    }

    public void getStudentWithMinAverageGradeAndExpel() {
        //TODO:
    }
}
 */