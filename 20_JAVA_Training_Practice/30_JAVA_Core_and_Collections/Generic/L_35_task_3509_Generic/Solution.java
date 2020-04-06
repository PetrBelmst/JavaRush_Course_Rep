package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
Collections & Generics
Реализуй вспомогательныe методы в классе Solution, которые должны создавать соответствующую коллекцию и
помещать туда переданные объекты.
Методы newArrayList, newHashSet параметризируй типом T.
Метод newHashMap параметризируй типами К(ключ) и V(значение). Аргументы метода newHashMap должны принимать
списки, в которых содержатся наследники типов K и V.
Возвращаемые коллекции должны быть такого же типа, что и переданные в метод объекты.
Подсказка: в методе newHashMap нужно проверить чтобы списки ключей и значений совпадали по размерам, в противном
случае кинь IllegalArgumentException.
Требования:
•	Метод newArrayList должен быть параметризован типом Т.
•	Метод newArrayList должен возвращать ArrayList, который содержит переданные в метод объекты.
•	Метод newHashSet должен быть параметризован типом Т.
•	Метод newHashSet должен возвращать HashSet, который содержит переданные в метод объекты.
•	Метод newHashMap должен быть параметризован типом K и V.
•	Метод newHashMap должен возвращать HashMap, который содержит переданные в метод ключи и значения.
•	Метод newHashMap должен кидать IllegalArgumentException, если списки ключей и значений не совпадают по размеру.
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList <T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> newList = new ArrayList<>();
        for (T item : elements) {
            newList.add(item);
        }
        return newList;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> newSet = new HashSet<>();
        for (T item : elements) {
            newSet.add(item);
        }
        return newSet;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException();
        }
        HashMap<K, V> newMap = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            newMap.put(keys.get(i), values.get(i));
        }
        return newMap;
    }
}
