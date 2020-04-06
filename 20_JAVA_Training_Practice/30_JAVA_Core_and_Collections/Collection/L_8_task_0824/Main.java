package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //напишите тут ваш код

        Human child_1 = new Human("Rick", true, 3);
        Human child_2 = new Human("Rock", true, 5);
        Human child_3 = new Human("Mila", false, 10);
        ArrayList<Human> childAll = new ArrayList<Human>();
        childAll.add(child_1);
        childAll.add(child_2);
        childAll.add(child_3);

        Human farther = new Human("far", true, 40, childAll);
        Human mother = new Human("mot", false, 40, childAll);
        ArrayList<Human> far = new ArrayList<Human>();
        far.add(farther);
        ArrayList<Human> mom = new ArrayList<Human>();
        mom.add(mother);

        Human grandPa_1 = new Human("Bob", true, 90, far);
        Human grandMa_1 = new Human("Jane", false, 90, far);
        Human grandPa_2 = new Human("Don", true, 91, mom);
        Human grandMa_2 = new Human("Shu", false, 91, mom);
        ArrayList<Human> grands = new ArrayList<Human>();
        grands.add(grandPa_1);
        grands.add(grandMa_1);
        grands.add(grandPa_2);
        grands.add(grandMa_2);

        ArrayList<Human> allFamily = new ArrayList<Human>();
        allFamily.addAll(childAll);
        allFamily.addAll(far);
        allFamily.addAll(mom);
        allFamily.addAll(grands);

        for (Human element : allFamily) {
            System.out.println(element);
        }

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human (String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
        public Human (String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<Human>();
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}

