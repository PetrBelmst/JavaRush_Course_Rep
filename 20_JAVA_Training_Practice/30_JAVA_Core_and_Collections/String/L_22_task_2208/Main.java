package com.company;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'

Требования:
•	Метод getQuery должен принимать один параметр типа Map.
•	Метод getQuery должен иметь тип возвращаемого значения String.
•	Метод getQuery должен быть статическим.
•	Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
*/
public class Main {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        map.put("name1", "Ivanov");
        map.put("name2", "Ivanov");

        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        if (params == null || params.isEmpty()) {
            return result.toString();
        }

        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getKey() == null || pair.getValue() == null)
                continue;

            result.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' and ");
        }

        if (result.length() > 5) {
            result.delete(result.length() - 5, result.length());
        }

        return result.toString();
    }
}
