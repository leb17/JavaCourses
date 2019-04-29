package ru.java.courses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.swing.tree.TreeCellEditor;

public class Lesson11to12_SetMap {

    public static class User implements Comparable<User> {

        private String name;
        private Integer age;
        private String phone;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public User(String phone) {
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public int compareTo(User o) {
            if (this.name.compareTo(o.name) == 0) {
                return this.age.compareTo(o.age);
            }
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", phone='" + phone + '\'' +
                    '}';
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем коллекцию пользователей
     * 2. Удаляем все дубли (одинаковое имя и возраст)
     * 3. Сортируем по имени и возрасту
     * 4. Возвращаем последнего пользователя
     */
    public static User task1(Collection<User> source) {

        TreeSet<User> set = new TreeSet<>(source); // без дубликатов и отсортировано по алфавиту через Comparable
        return set.last();
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем коллекцию пользователей
     * 2. Преобразовываем его в справочник [номер телефона -> пользователь]
     * 3. Один номер телефона на одного пользователя
     * 4. Вернуть количество записей в справочнике
     */
    public static int task2(Collection<User> source) {

        Map<String, String> map = new HashMap<>();
        for (User user : source) {
            map.put(user.phone, user.toString());
        }
        return map.size();
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем список названий книг
     * 2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
     * 3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
     * 4. Количество полок константное - 5 штук
     * 5. Вернуть книги распределенные по полкам
     *
     * 5 полок - ключи, названия книг - значение
     *
     * Нумерация полок начинается с единицы!
     */
    public static Map task3(Collection<String> source) {

        //Set<String> set = new HashSet<>(5);
        //set.addAll(source);

        //TreeSet<String> treeSet = new TreeSet<>(source);
        int each = source.size() / 5;

        ArrayList<String> list = new ArrayList<>(source);
        Collections.sort(list);

        HashMap<Integer, List<String>> map = new HashMap<>();
        //TreeMap<Integer, List<String>> map = new TreeMap<>();
        /*for (String s : source) {
            map.put(s.hashCode() % 5, );
        }*/
        //map.put(0, set);
        int j = 0;
        for (int i = 1; i < 6; i++) {
            map.put(i, list.subList(j, Math.min(j + each, list.size())));
            j += each;
        }
        /*for (String str : source) {
            int i = str.hashCode() % 5;

            map.put(i, str);
        }
        */
        return map;
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем книги, распределенные по полкам
     * 5. Вернуть справочник [название книги -> номер полки]
     */
    public static Map task4(Map<Integer, String> source) {
        Map<String, Integer> map = new HashMap<>();
        for (Entry<Integer, String> entry : source.entrySet()) {
            map.put(entry.getValue(),entry.getKey());
        }
        return map;
    }
}
