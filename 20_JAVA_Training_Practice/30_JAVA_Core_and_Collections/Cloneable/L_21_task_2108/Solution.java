package com.company;
/*
Клонирование растений
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуй механизм глубокого клонирования для Tree.
Требования:
•	Класс Plant не должен поддерживать интерфейс Cloneable.
•	Класс Tree должен поддерживать интерфейс Cloneable.
•	Класс Tree должен быть потомком класса Plant.
•	В классе Tree должен быть корректно реализован метод clone.
*/
public class Solution {
    public static void main(String[] args) throws CloneNotSupportedException {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        clone = tree.clone();

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public Plant clone() throws CloneNotSupportedException {
            return (Plant) super.clone();
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        public Tree clone () throws CloneNotSupportedException {
            return new Tree(this.getName(),this.branches.clone());
        }
    }
}