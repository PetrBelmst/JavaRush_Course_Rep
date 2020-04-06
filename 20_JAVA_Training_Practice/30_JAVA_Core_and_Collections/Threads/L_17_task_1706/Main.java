package com.company;
/*
Синхронизированный президент
И снова Singleton паттерн - синхронизация в статическом блоке.
Внутри класса OurPresident в статическом блоке создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте president.
Требования:
•	Класс OurPresident должен содержать приватную статическое поле OurPresident president.
•	Класс OurPresident должен содержать публичный статический метод OurPresident getOurPresident().
•	Класс OurPresident должен содержать приватный конструктор.
•	Класс OurPresident должен содержать статический блок.
•	Внутри статического блока класса OurPresident должен быть синхронизированный блок.
•	Внутри синхронизированного блока должно быть проинициализировано поле president.
*/
public class Main {

    public static void main(String[] args) {
        OurPresident expectedPresident = OurPresident.getOurPresident();
        OurPresident ourPresident = OurPresident.getOurPresident();
        System.out.println(expectedPresident == ourPresident );
    }
}

