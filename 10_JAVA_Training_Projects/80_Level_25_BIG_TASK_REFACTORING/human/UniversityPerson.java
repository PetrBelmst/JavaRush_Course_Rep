package com.company.human;

public class UniversityPerson extends Human {

    private University university;


    public UniversityPerson(String name, int age) {
        super(name, age);
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
/*
Рефакторинг (4)
public class UniversityPerson extends Human {

    private String university;

    public UniversityPerson(String name, int age) {
        super(name, age);

    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
*/