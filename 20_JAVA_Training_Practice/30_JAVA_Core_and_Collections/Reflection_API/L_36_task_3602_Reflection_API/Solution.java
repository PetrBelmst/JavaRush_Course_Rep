package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию
Описание класса:
1. Реализует интерфейс List;
2. Является приватным статическим классом внутри популярного утилитного класса;
3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException.
Используя рефлекшн (метод getDeclaredClasses), верни подходящий тип в методе getExpectedClass.

Требования:
•	Метод getExpectedClass должен использовать метод getDeclaredClasses подходящего утилитного класса.
•	Метод getExpectedClass должен вернуть правильный тип.
•	Метод main должен вызывать метод getExpectedClass.
•	Метод main должен вывести полученный класс на экран.
*/
public class Solution {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class[] classesList = Collections.class.getDeclaredClasses();
        for (Class element : classesList){

            if(Modifier.isPrivate(element.getModifiers()))
                if(Modifier.isStatic(element.getModifiers()))
                {
                    if(List.class.isAssignableFrom(element))
                    {
                        try{
                            Constructor constructor = element.getDeclaredConstructor();
                            constructor.setAccessible(true);
                            List list = (List) constructor.newInstance();
                            list.get(0);
                        }catch (IndexOutOfBoundsException e){
                            return element;
                        } catch (NoSuchMethodException e) {
                        } catch (InvocationTargetException e) {
                        }
                    }

                }
        }
        return null;
    }
}
