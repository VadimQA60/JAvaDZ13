package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void testTrueAndFalseMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");
        Assertions.assertTrue(meeting.matches("приложения")); // поиск topic
        Assertions.assertFalse(meeting.matches("прилажения"));//проверка на правильность ввода данных в topic
        Assertions.assertFalse(meeting.matches("приложений"));// проверка поиска на окончание в topic
        Assertions.assertTrue(meeting.matches("НетоБанка"));//проверка поиска в project
        Assertions.assertFalse(meeting.matches("НетаБанка"));// проверка правильности написания слова
        Assertions.assertFalse(meeting.matches("НетоБанкинг"));// проверка на окончание
        Assertions.assertFalse(meeting.matches("новое"));//проверка в поиске project на отсутствующие слова
        Assertions.assertFalse(meeting.matches("обеда"));// проверка в поиске start
    }

    @Test
    public void testTrueAndFalseEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Epic epicOne = new Epic(55, new String[]{});

        Assertions.assertTrue(epic.matches("Молоко"));//проверка поиска
        Assertions.assertFalse(epic.matches("малоко"));// проверка правильности написания
        Assertions.assertFalse(epic.matches("Мёд"));// проверка на отсутствующие слова
        Assertions.assertFalse(epic.matches("Яйцок"));//проверка на правильность
        Assertions.assertFalse(epic.matches("хлеб"));// проверка на написание с заглавной
        Assertions.assertFalse(epicOne.matches("Хлеб"));//проверка массива


    }


}
