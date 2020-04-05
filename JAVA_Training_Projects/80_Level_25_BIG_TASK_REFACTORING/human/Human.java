package com.company.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {

    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    protected Size size;

    private BloodGroup bloodGroup;

    private List<Human> children = new ArrayList<>();

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }
    public void addChild(Human human) {
        children.add(human);
    }
    public void removeChild(Human human) {
        children.remove(human);
    }
    public String getPosition() {
        return "Человек";
    }
    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    public BloodGroup getBloodGroup() {
        return this.bloodGroup;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Human(String name, int age) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.age = age;
    }
    public void live() {
    }
    public int getId() {
        return id;
    }
    public void printSize() {
        System.out.println("Рост: " + Size.height + " Вес: " + Size.weight);
    }
    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }
    public static class Size {
        public static int height;
        public static int weight;
    }


}
/*
Рефакторинг (9)
REMOVED
protected int[] size;
public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
REMOVED
public static class Size {
        public static int height;
        public static int weight;
    }
public void printSize() {
        System.out.println("Рост: " + Size.height + " Вес: " + Size.weight);
    }
*/

/*
Рефакторинг (5)
REMOVED
public void setId(int id) {
        this.id = id;
    }
REMOVED
private static int nextId = 0;

 */


/*
Рефакторинг (5)
public String getPosition() {
        return "Человек";
    }


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
public Human(String name, int age) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.age = age;
    }

    public void live() {

    }
 */


/*
Рефакторинг (1)
public class Human {

    public static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    protected int course;

    protected int[] size;

    protected boolean isSoldier;

    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    private int bloodGroup;

    private List<Human> children = new ArrayList<>();

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }
    public void addChild(Human human) {
        children.add(human);
    }
    public void removeChild(Human human) {
        children.remove(human);
    }

 */

/*
ORIGINAL (INITIAL) CODE
public class Human {
    public static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    protected int course;

    protected int[] size;

    protected boolean isSoldier;

    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    private int bloodGroup;

    public void setBloodGroup(int code) {
        bloodGroup = code;
    }

    public int getBloodGroup() {
        return bloodGroup;
    }

    public Human(boolean isSoldier) {
        this.isSoldier = isSoldier;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void live() {
        if (isSoldier)
            fight();
    }

    public void fight() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printSize() {
        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }
}
 */