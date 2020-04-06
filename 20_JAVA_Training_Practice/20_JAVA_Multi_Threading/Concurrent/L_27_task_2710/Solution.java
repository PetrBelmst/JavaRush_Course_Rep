package com.company;
/*
Расставьте wait-notify
Расставь wait-notify.
Пример вывода:
Thread-0 MailServer received: [Person [Thread-1] wrote an email 'AAA'] in 1001 ms after start
Требования:
•	Объекты класса MailServer должны работать корректно в многопоточном окружении.
•	Объекты класса Person должны работать корректно в многопоточном окружении.
•	В методе run класса MailServer должен присутствовать synchronized блок, монитор - mail.
•	В методе run класса Person должен присутствовать synchronized блок, монитор - mail.
*/
public class Solution {
    public static void main(String[] args) {
        Mail mail = new Mail();
        Thread server = new Thread(new MailServer(mail));
        Thread amigo = new Thread(new Person(mail));

        server.start();
        amigo.start();
    }
}

