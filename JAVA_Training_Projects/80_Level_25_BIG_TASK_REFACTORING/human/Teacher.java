package com.company.human;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends UniversityPerson {

    private int numberOfStudents;

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
        this.numberOfStudents = numberOfStudents;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

    @Override
    public String getPosition() {
        return "Преподаватель";
    }
}

/*
Рефакторинг (5)
@Override
    public String getPosition() {
        return "Преподаватель";
    }
*/

/*
Рефакторинг (4)
public class Teacher extends UniversityPerson {
*/

/*
Рефакторинг (2)
public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
        this.numberOfStudents = numberOfStudents;
    }
 */


/*
Рефакторинг (1)
public class Teacher extends Human {

    private int numberOfStudents;
    private String university;

    public Teacher(String name, int age, int numberOfStudents) {
        super(false);
        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void printData() {
        System.out.println("Преподаватель: " + name);
    }
}
 */

/*
ORIGINAL (INITIAL) CODE
public class Teacher extends Human {
    private List<Human> children = new ArrayList<>();
    private int numberOfStudents;
    private String university;

    public Teacher(String name, int age, int numberOfStudents) {
        super(false);
        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void printData() {
        System.out.println("Преподаватель: " + name);
    }
}
 */