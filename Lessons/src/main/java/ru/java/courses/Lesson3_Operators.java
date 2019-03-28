package ru.java.courses;

public class Lesson3_Operators {

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем целое число и строку
     * 2. Проверяем полученное число:
     * 2.1 если больше нуля, к строке в конец добавляем это число
     * 2.2 если меньше нуля, добавляем число в начало строки
     * 2.3 если равно нулю, заменяет содержимое строки на "0"
     * 3. Проверяем длину полученной строки:
     * 3.1 Если длина строки меньше или равна 10, возвращаем эту строку
     * 3.2 Иначе возвращаем первые 10 символов
     * <p>
     * Подсказки:
     * - получить длину строки можно методом .length()
     * - получить первые n символов из строки можно методом .substring(0, n)
     */
    public static String task1(int i, String str) {
        String str1 = i > 0 ? str + i : (i < 0 ? i + str : "0");
        return str1.length() <= 10 ? str1 : str1.substring(0, 10);
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. Получаем целое число
     * 2. Уменьшаем его на единицу
     * 3. Проверяем полученное число:
     * 3.1 если оно больше 100 или меньше 30, прибавляем к нему 1000
     * 3.2 иначе, если оно больше 0 и делится на 2 без остатка, отнимаем от него 1000
     * 4. Проверяем знак числа:
     * 4.1 если меньше нуля, возвращаем false
     * 4.2 если больше или равно нулю, возвращаем true
     * <p>
     * Подсказка: тут все просто, думайте сами ;)
     */
    public static boolean task2(int i) {
        int k = --i;
        k = k > 100 || k < 30 ? k + 1000 : (k % 2 == 0 ? k - 1000 : k);
        return k >= 0;
    }


}
