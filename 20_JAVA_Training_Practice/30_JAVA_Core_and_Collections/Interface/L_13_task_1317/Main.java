package com.company;
/*
The weather is fine
1. В классе Today реализовать интерфейс Weather.
2. Подумай, как связан параметр type с методом getWeatherType().
3. Интерфейсы Weather и WeatherType уже реализованы в отдельных файлах.
Требования:
•	Интерфейс Weather должен быть реализован в классе Today.
•	В классе Today должен быть реализован метод getWeatherType объявленный в интерфейсе Weather.
•	Тип возвращаемого значения метода getWeatherType должен быть String.
•	Метод getWeatherType должен возвращать значение переменной type.
*/

public class Main {

    public static void main(String[] args) {
        System.out.println(new Today(WeatherType.CLOUDY));
        System.out.println(new Today(WeatherType.FOGGY));
        System.out.println(new Today(WeatherType.FREEZING));
    }

    static class Today implements Weather {
        private String type;

        Today(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("Today it will be %s", this.getWeatherType());
        }

        @Override
        public String getWeatherType() {
            return this.type;
        }
    }

    public interface Weather {
        String getWeatherType();
    }

    public interface WeatherType {
        String CLOUDY = "Cloudy";
        String FOGGY = "Foggy";
        String FREEZING = "Freezing";
    }
}
