package com.company;
/*
Определяем порядок захвата монитора
Реализуй логику метода isLockOrderNormal, который должен определять:
соответствует ли порядок synchronized блоков в методе someMethodWithSynchronizedBlocks -
порядку передаваемых в него аргументов.
В случае, если сначала происходит синхронизация по o1, а потом по o2, метод должен вернуть true.
Если наоборот - false.

Требования:
•	Метод isLockOrderNormal должен возвращать true в случае, если синхронизация в методе
someMethodWithSynchronizedBlocks происходит сначала по объекту o1, а потом по o2.
•	Метод isLockOrderNormal должен возвращать false в случае, если синхронизация в методе
someMethodWithSynchronizedBlocks происходит сначала по объекту o2, а потом по o1.
•	Метод isLockOrderNormal НЕ должен быть приватным.
•	Класс Solution НЕ должен быть объявлен с модификатором final.
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2)
            throws Exception {
        Thread thread1 = new Thread(() -> {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                synchronized (o2) {
                }
            }
        });

        Thread thread2 = new Thread(() -> solution.someMethodWithSynchronizedBlocks(o1, o2));
        thread1.start();
        thread2.start();
        Thread.sleep(1000);

        if (thread2.getState() == Thread.State.BLOCKED) {
            return false;
        } else {
            return true;
        }
        //do something here - первая нить thread1 блокирует объект №1 и засыпает (блокировка не снимается пока нить спит)
        // на 500 млс, засыпает для того чтобы не успеть заблокировать объект №2, пока первая нить спит вторая нить
        // запускает метод someMethodWithSynchronizedBlocks (метод так же блокирует оба объекта), если порядок
        // блокировки не соответствует порядку в котором объекты передаются в метод (см условия задачи) вторая
        // нить первым делом заблокирует объект №2 затем пойдет далее по блоку синхронизации и попытается заблокировать о1,
        // но не сможет этого сделать так как о1 уже заблокирован первой нитью, в этом случе и возникает
        // ситуация дэдлока, тоесть первая нить блокирует о1 изасыпает с блокировкой а вторая нить (через запуск метода)
        // блокирует объект 2 (в случае если порядок передачи и порядок блокировки несоблюдены), вторая нить не может
        // заблокировать о1 так как он занят первой нитью, затем первая нить просыпается и идет дальше по блоку
        // синхронизации и пытается заблокировать о2 но не может этого сделать так как метод (если нарушен порядок передачи и блокировки объектов)
        // уже заблокировал о2, проверочный метод вернет false если порядок передачи/блокировки нарушен при котором
        // возникает дэд лок, если порядок не нарушен то дэд лок не возникнет, нить не будет заблокирована, и метод вернет true
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}