package com.company;
/*
Убираем deadlock
Используя стратегию избегания deadlock-а сделай так, чтобы он не возник.
Метод main не участвует в тестировании.
Действуй аналогично примеру из лекций.
Изменения вноси только в safeMethod.

Требования:
•	Метод safeMethod не должен вызывать deadlock при использовании из разных потоков.
•	В методе safeMethod должен содержаться вызов метода unsafeMethod, с теми же аргументами.
•	В методе safeMethod должен содержаться вызов метода longTimeMethod.
•	В методе safeMethod должно содержаться два блока synchronized.
*/

public class Solution {
    public void safeMethod(Object obj1, Object obj2) {

        Object lockMax = obj1.hashCode() > obj2.hashCode() ? obj1 : obj2;
        Object lockMin = obj1.hashCode() > obj2.hashCode() ? obj2 : obj1;

        synchronized (lockMax) {
            longTimeMethod();
            synchronized (lockMin) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread(() -> solution.safeMethod(o1, o2)).start();

        new Thread(() -> solution.safeMethod(o2, o1)).start();
    }
}