package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static Map<String, Date> createMap() {

        DateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();

        try {
            map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
            map.put("e", dateFormat.parse("JUNE 1 2012"));
            map.put("c", dateFormat.parse("JUNE 1 2012"));
            map.put("s", dateFormat.parse("JUNE 1 2012"));
            map.put("w", dateFormat.parse("JULY 1 2012"));
            map.put("Стне", dateFormat.parse("JUNE 1 2012"));
            map.put("Сталл", dateFormat.parse("JUNE 1 2012"));
            map.put("Сталлон", dateFormat.parse("AUGUST 1 2012"));
            map.put("Ста", dateFormat.parse("JUNE 1 2012"));
            map.put("Ст", dateFormat.parse("JUNE 1 2012"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<String, Date> pair = iterator.next();
            Date tmp = pair.getValue();

            if (tmp.getMonth() == 5 | tmp.getMonth() == 6 | tmp.getMonth() == 7) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        Main test = new Main();
        test.removeAllSummerPeople(createMap());
    }
}
