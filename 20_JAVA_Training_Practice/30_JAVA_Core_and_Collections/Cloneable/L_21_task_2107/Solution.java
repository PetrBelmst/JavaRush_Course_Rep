package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/*
Глубокое клонирование карты
Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.

Требования:
•	Класс Solution должен поддерживать интерфейс Cloneable.
•	Класс User должен поддерживать интерфейс Cloneable.
•	В классе User должен быть корректно реализован метод clone.
•	В классе Solution должен быть корректно реализован метод clone.
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        clone = solution.clone();
        System.out.println(solution);
        System.out.println(clone);

        System.out.println(solution.users);
        System.out.println(clone.users);

    }

    protected Map<String, User> users = new LinkedHashMap();

    public Solution clone() {
        Solution solution = new Solution();
        solution.users = new LinkedHashMap();
        solution.users.putAll(users);
        return solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return Objects.equals(users, solution.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }
    }
}
