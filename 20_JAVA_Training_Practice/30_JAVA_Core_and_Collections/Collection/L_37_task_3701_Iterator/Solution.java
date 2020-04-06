package com.company;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.function.Consumer;

/*
Круговой итератор
Класс Solution наследуется от ArrayList.
Перегрузи правильным образом метод iterator в классе Solution.
Напишите свой класс RoundIterator внутри Solution, который будет итератором для списка Solution.
Итератор должен ходить по кругу по всем элементам.
В остальном поведение должно быть идентичным текущему итератору.

Требования:
•	Круговой итератор должен после последнего элемента переходить на первый и так далее.
•	Метод remove без параметров должен удалять текущий элемент.
•	При некорректной модификации списка из разных потоков должно возникать исключение ConcurrentModificationException.
•	Класс Solution должен быть потомком класса ArrayList.
•	Метод iterator() в классе Solution должен возвращать объект типа RoundIterator.
*/
public class Solution<T> extends ArrayList<T> {

    public static void main(String[] args) {

        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public class RoundIterator implements Iterator<T> {

        Iterator<T> iterator = Solution.super.iterator();
        int cursorPosition = 0;

        @Override
        public boolean hasNext() {
            if (size() == 0)
                return false;

            if (cursorPosition >= size()) {
                iterator = Solution.super.iterator();
                cursorPosition = 0;
            }

            return true;
        }

        @Override
        public T next() {
            cursorPosition++;
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            iterator.forEachRemaining(action);
        }
    }
}
