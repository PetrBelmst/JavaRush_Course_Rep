package com.company.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {

    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta) {
        setAverageGrade(getAverageGrade() + delta);
    }

    public void setCourse (int value) {
        this.course = value;
    }

    public void setAverageGrade (double value) {
        this.averageGrade = value;
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}

/*
Рефакторинг (9)
public void incAverageGrade(double delta) {
        setAverageGrade(getAverageGrade() + delta);
    }

 */


/*
Рефакторинг (7)
public void incAverageGrade(double delta) {
        averageGrade += delta;
    }
REMOVED
public void incAverageGradeBy01() {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02() {
        averageGrade += 0.2;
    }
REMOVED
public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }
 */

/*
Рефакторинг (6)
public void setCourse (double value) {
            course = (int) value;
    }

    public void setAverageGrade (double value) {
        averageGrade = value;
    }
    REMOVED
    public void setValue(String name, double value) {
        if (name.equals("averageGrade")) {
            averageGrade = value;
            return;
        }
        if (name.equals("course")) {
            course = (int) value;
            return;
        }
    }
    REMOVED
*/

/*
Рефакторинг (5)
 @Override
    public String getPosition() {
        return "Студент";
    }
*/

/*
Рефакторинг (4)
public class Student extends UniversityPerson {
*/


/*
Рефакторинг (3)
private int course;
public int getCourse() {
        return course;
    }
 */


/*
Рефакторинг (2)
public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }
 */


/*
Рефакторинг (1)
public class Student extends Human {

    private double averageGrade;
    private String university;
    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade) {
        super(false);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

 */

/*
ORIGINAL (INITIAL) CODE
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Human {
    private List<Human> children = new ArrayList<>();
    private double averageGrade;
    private String university;
    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade) {
        super(false);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void printData() {
        System.out.println("Студент: " + name);
    }

    public void incAverageGradeBy01() {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02() {
        averageGrade += 0.2;
    }

    public void setValue(String name, double value) {
        if (name.equals("averageGrade")) {
            averageGrade = value;
            return;
        }
        if (name.equals("course")) {
            course = (int) value;
            return;
        }
    }

    public void setBeginningOfSession(int day, int month, int year) {
        beginningOfSession = new Date(year, month, day);
    }

    public void setEndOfSession(int day, int month, int year) {
        endOfSession = new Date(year, month, day);
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}
 */
