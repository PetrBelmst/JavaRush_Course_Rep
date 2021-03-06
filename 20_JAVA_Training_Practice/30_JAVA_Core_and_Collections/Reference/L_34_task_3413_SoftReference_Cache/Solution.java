package com.company;
/*
Кеш на основании SoftReference
Реализуй логику методов get, put, remove класса SoftCache:

Метод AnyObject get(Long key) должен возвращать объект типа AnyObject из мапы cacheMap по ключу key.
Если такого ключа в cacheMap нет - верни null.

Метод AnyObject put(Long key, AnyObject value) должен добавлять в мапу пару key : value. Метод должен
вернуть null, если в cacheMap по такому ключу ранее не было значения. Иначе - верни предыдущее значение
value по этому ключу. Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.

Метод AnyObject remove(Long key) должен удалить из мапы cacheMap пару key : value по ключу key. Метод
должен вернуть null, если в cacheMap по такому ключу ранее не было значения. Иначе - верни предыдущее
значение value по этому ключу. Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.

Не изменяй класс AnyObject.
Метод main не принимает участия в тестировании.

Требования:
•	Класс AnyObject не должен быть изменен.
•	В классе SoftCache должно существовать приватное поле Map<Long, SoftReference<AnyObject>> cacheMap.
•	Реализуй метод get согласно условию.
•	Реализуй метод put согласно условию.
•	Реализуй метод remove согласно условию.
*/

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        for (long i = 0; i < 2_500_000; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }
    }
}

/*
попробуйте проверить размер cachemap после цикла, попробуйте удалить или добавить новый объект.
А теперь создайте в main обычный hashmap и попытайтесь его заполнить в аналогичном цикле, не выйдет,
потому что выкинет исключение.... угадайте какое.
В случае с нашим cachemap все в порядке, сколько бы памяти под JVM мы не выставляли- программа
завершается корректно, все из за того, что GC во время успевает подчистить память по мягким ссылкам.
Чтобы это проверить попробуйте поставить память для программы поменьше:
-Xms256m -Xmx512m
В итоге цикл завершился корректно и размер cachemap, как и положено 2_500_000 элементов. Однако если
просмотреть по ключу нужный Anyobject, то получим null. Так как объекты были удалены GC,
чтобы выделить память.
 */