package ru.java.courses;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Lesson13to14_Stream {

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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (name != null ? !name.equals(user.name) : user.name != null) return false;
            if (age != null ? !age.equals(user.age) : user.age != null) return false;
            return phone != null ? phone.equals(user.phone) : user.phone == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (age != null ? age.hashCode() : 0);
            result = 31 * result + (phone != null ? phone.hashCode() : 0);
            return result;
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

    }

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем коллекцию пользователей
     * 2. Удаляем все дубли (одинаковое имя и возраст)
     * 3. Сортируем по имени и возрасту
     * 4. Возвращаем последнего пользователя
     */
    public static User task1(Collection<User> source) {

        /*TreeSet<User> set = new TreeSet<>(source); // без дубликатов и отсортировано по алфавиту через Comparable
        return set.last();*/

        User last = source.stream()
                .distinct()                           //убираем дубли
                //.sorted(Comparator.naturalOrder())  //сортировка по алфавиту
                //.filter((source) -> source != null) //убрать null
                //.filter(Objects::nonNull)           //убрать null
                //.peek(System.out::println)          //взять каждый объект и вывести в консоль
                //.skip(source.size() - 1)            //пропустить [размер списка - 1] первых элементов
                .max(Comparator.naturalOrder())       //сортировка по алфавиту и взять последний (min - первый)
                //.limit(n)                           //взять n элементов
                //.count                              //вернуть кол-во элементов
                .get();
        return last;
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем коллекцию пользователей
     * 2. Преобразовываем его в справочник [номер телефона -> пользователь]
     * 3. Один номер телефона на одного пользователя
     * 4. Вернуть количество записей в справочнике
     */
    public static int task2(Collection<User> source) {

        /*Map<String, String> map = new HashMap<>();
        for (User user : source) {
            map.put(user.phone, user.toString());
        }
        return map.size();*/

        Map<String, String> map = source.stream()
                .distinct()
                //.filter((user) -> user.getPhone().)
                .collect(Collectors.toMap(p -> p.getPhone(), user -> user.toString()));
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

        /*int each = source.size() / 5;

        ArrayList<String> list = new ArrayList<>(source);
        Collections.sort(list);

        HashMap<Integer, List<String>> map = new HashMap<>();

        int j = 0;
        for (int i = 1; i < 6; i++) {
            map.put(i, list.subList(j, Math.min(j + each, list.size())));
            j += each;
        }

        return map;*/

        int each = source.size() / 5;
        HashMap<Integer, List<String>> map = source.stream()
                .sorted(Comparator.naturalOrder())
                //.map((source) -> source.length())     //преобразует stream в другой stream
                .collect(Collectors.toMap());

        return map;
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем книги, распределенные по полкам
     * 5. Вернуть справочник [название книги -> номер полки]
     */
    public static Map task4(Map<Integer, String> source) {
        /*Map<String, Integer> map = new HashMap<>();
        for (Entry<Integer, String> entry : source.entrySet()) {
            map.put(entry.getValue(),entry.getKey());
        }
        return map;*/


    }
}
