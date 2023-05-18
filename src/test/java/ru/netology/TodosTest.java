package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка установить родителям",
            "Во вторник после обеда"
    );
    Todos todos = new Todos();

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryOne() {
        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryTwo() {
        Task[] expected = {};
        Task[] actual = todos.search("Обеда");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryThree() {
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryFor() {
        Task[] expected = {meeting};
        Task[] actual = todos.search("3й");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchQueryFive() {
        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQuerySix() {
        Task[] expected = {};
        Task[] actual = todos.search("колбаса");// когда не находится ни одна задача
        Assertions.assertArrayEquals(expected, actual);
    }


}