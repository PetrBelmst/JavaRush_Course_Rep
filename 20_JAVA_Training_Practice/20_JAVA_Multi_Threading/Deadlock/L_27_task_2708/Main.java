package com.company;
/*
Убираем deadLock используя открытые вызовы
Синхронизированные методы, которые вызывают внутри себя синхронизированные методы других классов,
приводят к dead-lock-у.
1. Перенесите синхронизацию с метода в синхронизированный блок, куда поместите лишь необходимые части
кода.
2. Уберите избыточную синхронизацию методов.
3. В стеке вызова методов не должно быть перекрестной синхронизации, т.е. такого
synchronizedMethodAClass().synchronizedMethodBClass().synchronizedMethodAClass()
Этот способ избавления от дэдлока называется "открытые вызовы", о нем читайте в дополнительном
материале к лекции.
Метод main не участвует в тестировании.
Требования:
•	Должна быть обеспечена возможность корректного взаимодействия объектов типа Apartment и RealEstate
без возникновения взаимных блокировок.
•	Метод up класса RealEstate должен быть объявлен без модификатора synchronized.
•	Метод revalidate класса RealEstate должен быть объявлен без модификатора synchronized.
•	Метод revalidate класса Apartment должен быть объявлен без модификатора synchronized.
•	Метод revalidate класса RealEstate должен содержать один synchronized блок.
•	В synchronized блоке метода revalidate класса RealEstate должен содержаться вызов метода revalidate
на объекте apartment с параметром randomValue.
*/

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        final long deadline = System.currentTimeMillis() + 5000; //waiting for 5 sec

        final RealEstate realEstate = new RealEstate();
        Set<Apartment> allApartments = realEstate.getAllApartments();

        final Apartment[] apartments = allApartments.toArray(new Apartment[allApartments.size()]);

        for (int i = 0; i < 20; i++) {

            new Thread(() -> {
                for (int i1 = 0; i1 < 10; i1++) {
                    realEstate.revalidate();
                }
            }, "RealEstateThread" + i).start();

            new Thread(() -> {
                for (int i12 = 0; i12 < apartments.length; i12++) {
                    apartments[i12].revalidate(true);
                }
            }, "ApartmentThread" + i).start();
        }

        Thread deamonThread = new Thread(() -> {
            while (System.currentTimeMillis() < deadline)
                try {
                    Thread.sleep(2);
                } catch (InterruptedException ignored) {
                }
            System.out.println("Deadlock occurred");
        });
        deamonThread.setDaemon(true);
        deamonThread.start();
    }
}