package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
Сериализация даты в JSON
Используя аннотацию JsonFormat сделай так, чтобы поле содержащее дату в классе Event сериализировалось
в формате (dd-MM-yyyy hh:mm:ss).

Требования:
•	Поле eventDate в классе Event должно быть отмечено аннотацией @JsonFormat.
•	Объекты типа Event должны корректно сериализовываться в JSON в соответствии с условием задачи.
•	В конструкторе класса Event должен быть создан новый объект типа Date без аргументов.
•	Поле eventDate должно быть публичным.
*/
public class Solution {
    public static void main(String[] args) throws JsonProcessingException {
        Event event = new Event("event#1");

        String result = new ObjectMapper().writeValueAsString(event);

        System.out.println(result);
    }
}
