package com.company;
/*
Рефакторинг, вложенные классы
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.

Требования:
•	В классе Solution должен быть создан класс Constants содержащий строковые константы.
•	Класс Constants должен быть публичным.
•	Класс Constants должен быть объявлен с модификатором, запрещающим наследование от этого класса.
•	В классе Constants должна существовать константа SERVER_IS_CURRENTLY_NOT_ACCESSIBLE со
значением "The server is not currently accessible.".
•	В классе Constants должна существовать константа USER_IS_NOT_AUTHORIZED со значением
"The user is not authorized.".
•	В классе Constants должна существовать константа USER_IS_BANNED со значением
"The user is banned.".
•	В классе Constants должна существовать константа ACCESS_IS_DENIED со значением
"Access is denied.".
*/
public class Solution {

    public final class Constants {
        public static final String SERVER_IS_CURRENTLY_NOT_ACCESSIBLE = "The server is not currently accessible.";
        public static final String USER_IS_NOT_AUTHORIZED = "The user is not authorized.";
        public static final String USER_IS_BANNED = "The user is banned.";
        public static final String ACCESS_IS_DENIED = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super("The server is currently not accessible.");
        }

        public ServerNotAccessibleException(Throwable cause) {
            super("The server is currently not accessible.", cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super("The user is not authorized.");
        }

        public UnauthorizedUserException(Throwable cause) {
            super("The user is not authorized.", cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super("The user is banned.");
        }

        public BannedUserException(Throwable cause) {
            super("The user is banned.", cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super("Access is denied.");
        }

        public RestrictionException(Throwable cause) {
            super("Access is denied.", cause);
        }
    }

    public static void main(String[] args) {

    }
}
