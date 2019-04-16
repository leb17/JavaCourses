package ru.java.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lesson10_CollectionsLists {

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем список чисел
     * 2. Удаляем все дубли
     * 3. Преобразуем числа в строки
     * 4. Возращаем полученный список строк отсортированный по возрастанию
     * <p>
     * Подсказки:
     * Collections.sort() - сортировка
     * Удалять элементы из итерируемого списка нельзя - выпадет исключение
     */
    public static List<String> task1(List<Integer> source) {
        Collections.sort(source);
        List<String> strings = new ArrayList<>();
        for (Integer integer : source) {
            String t = integer.toString();
            if (!strings.contains(t)) {
                strings.add(t);
            }
        }
        /*for (int i=0;i < source.size();i++) {
            int count = Collections.frequency(source, source.get(i));
            if (count == 1) {
                strings.add(source.get(i).toString());
            }
        }*/
        //Collections.sort(strings);
        return strings;
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. Получаем на входе массив чисел
     * 2. Преобразовываем его к списку
     * 4. Все четные числа увеличиваем на единицу
     * 5. Возвращаем кусок списка с 3-го по 7-й элемент
     * <p>
     * Подсказка: на входе может быть любое количество чисел
     */
    public static List<Integer> task2(Integer... array) {
        List<Integer> integers = Arrays.asList(array);
        for (Integer i : integers) {
            if (i % 2 == 0) {
                integers.set(integers.indexOf(i),++i);
            }
        }
        int i = integers.size();
        if (i > 7) {
            return integers.subList(3, 8);
        } else if (i > 3) {
            return integers.subList(3, i);
        } else
            throw new IllegalArgumentException("Недостаточно элементов");
    }
}
