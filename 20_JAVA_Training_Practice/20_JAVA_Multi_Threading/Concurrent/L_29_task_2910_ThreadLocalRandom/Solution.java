package com.company;
/*
Это архаичное слово "Биатлон"
Амиго, представляешь, в 21 веке существовал такой вид спорта - биатлон. Люди ездили на лыжах
и стреляли на подготовленных площадках по мишеням. За одну серию стрельбы нужно было закрыть
5 мишеней. Стрельбы происходили как стоя, так и лежа, но не будем вдаваться в подробности.
У лучших представителей рода человеческого средняя точность стрельбы достигала 90%, у крепких
середнячков - 81,5%.
Я написал программу, которая создает соревнование, добавляет в него 30 спортсменов-биатлонистов.
Каждому из них случайным образом выставляется точность (в диапазоне от 0,815 до 0,900).
Штраф за каждый промах - плюс 20 секунд к результату. Еще у соревнования задается количество
огневых рубежей - 4 и дистанция, которую биатлонисты должны преодолеть - 20 км.

Так же я создал контрольного спортсмена, у которого захардкожены показатели:
Скорость: 20 км/час;
Вероятность попадания: 0,900 (90%);
Количество промахов: 2 (Всего нужно попасть 20 раз. При точности 90 процентов ожидается
2 промаха);
Нужно проехать 20 км со скоростью 20 км/час. Необходимое время - 1 час, то есть 3600 секунд.
Время гонки (с учетом штрафных секунд): 3600 + 2 * 20 = 3640 секунд.
Я хочу определить, с какой скоростью должен ехать каждый спортсмен, при его случайном
количестве промахов, чтобы результат в секундах был такой же, как и у контрольного спортсмена.
В начале я вывожу результат контрольного спортсмена, потом все результаты. В конце я вывожу
всех спортсменов, у которых время такое же, как и у контрольного спортсмена. У некоторых
спортсменов за счет округления итоговое время отличается на доли секунды. Такие нам не нужны.
У остальных время гонки ровно 3640 секунд, как и у контрольного спортсмена, но они не выводятся
в секции "СПОРТСМЕНЫ С ТАКИМ ЖЕ ИТОГОВЫМ ВРЕМЕНЕМ, КАК У КОНТРОЛЬНОГО СПОРТСМЕНА:".
controlSportsman.setResultTime(new BigDecimal("3640.0" -> "3640.00"));

Твоя задача: сделать одно изменение в коде (добавить, удалить, или изменить один символ),
чтобы исправить найденный баг.
Обрати внимание: все округления правильные, и новых добавлять не нужно!

Требования:
•	Запрещено изменять типы данных констант.
•	Вывод на экран в секции "СПОРТСМЕНЫ С ТАКИМ ЖЕ ИТОГОВЫМ ВРЕМЕНЕМ, КАК У КОНТРОЛЬНОГО
СПОРТСМЕНА:" должен содержать всех спортсменов, у которых такое же время, как и у контрольного
спортсмена.
•	Сделай одно изменение в классе Game.
•	Класс Constants не изменяй.
•	Класс Solution не изменяй.
•	Класс Sportsman не изменяй.
*/
public class Solution {

    public static void main(String[] args) {
        Game game = new Game();
        printDelimiter();
        game.startCompetition();
        System.out.println("\n\nВСЕ РЕЗУЛЬТАТЫ:");
        game.printAllResults();
        printDelimiter();
        System.out.println("\n\nСПОРТСМЕНЫ С ТАКИМ ЖЕ ИТОГОВЫМ ВРЕМЕНЕМ, КАК У КОНТРОЛЬНОГО СПОРТСМЕНА:");
        game.printSportsmanWithEqualTime();
        printDelimiter();
    }

    private static void printDelimiter() {
        System.out.println("======================================================================" +
                "===========================");
    }
}