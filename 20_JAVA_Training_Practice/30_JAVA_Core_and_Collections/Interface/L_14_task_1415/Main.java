package com.company;
import java.util.ArrayList;
import java.util.List;

/*
Клининговый центр
1. Реализовать метод cleanAllApartments.
Для каждого объекта из apartments:
2. Для однокомнатных квартир (OneRoomApt) вызвать метод clean1Room.
т.е. если объект типа OneRoomApt, то вызвать у него метод clean1Room.
3. Для двухкомнатных квартир (TwoRoomApt) вызвать метод clean2Rooms
т.е. если объект типа TwoRoomApt, то вызвать у него метод clean2Rooms.
4. Для трехкомнатных квартир (ThreeRoomApt) вызвать метод clean3Rooms
т.е. если объект типа ThreeRoomApt, то вызвать у него метод clean3Rooms.

Требования:
•	Метод cleanAllApartments должен принимать список аппартаметов в качестве параметра.
•	В методе cleanAllApartments для всех однокомнатных аппартаментов(OneRoomApt) содержащихся
в списке необходимо вызвать метод clean1Room.
•	В методе cleanAllApartments для всех двухкомнатных аппартаментов(TwoRoomApt) содержащихся
в списке необходимо вызвать метод clean2Rooms.
•	В методе cleanAllApartments для всех трехкомнатных аппартаментов(ThreeRoomApt) содержащихся
в списке необходимо вызвать метод clean3Rooms.
•	Классы OneRoomApt, TwoRoomApt, ThreeRoomApt должны поддерживать(реализовывать) интерфейс Apartment.
*/

public class Main {

    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<Apartment>();
        apartments.add(new OneRoomApt());
        apartments.add(new TwoRoomApt());
        apartments.add(new ThreeRoomApt());

        cleanAllApartments(apartments);
    }

    public static void cleanAllApartments(List<Apartment> apartments) {
        //написать тут вашу реализацию пунктов 1-4
        for (Apartment o : apartments) {
           if (o instanceof OneRoomApt) {
               ((OneRoomApt) o).clean1Room();
           } else if (o instanceof TwoRoomApt) {
               ((TwoRoomApt) o).clean2Rooms();
           } else if (o instanceof ThreeRoomApt) {
               ((ThreeRoomApt) o).clean3Rooms();
           }
        }
    }

    static interface Apartment {
    }

    static class OneRoomApt implements Apartment {
        void clean1Room() {
            System.out.println("1 room is cleaned");
        }
    }

    static class TwoRoomApt implements Apartment {
        void clean2Rooms() {
            System.out.println("2 rooms are cleaned");
        }
    }

    static class ThreeRoomApt implements Apartment {
        void clean3Rooms() {
            System.out.println("3 rooms are cleaned");
        }
    }
}




























