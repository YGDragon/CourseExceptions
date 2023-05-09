package Lesson2;

public class Task2 {
    public static void main(String[] args) {
        task2();
    }

    public static void task2() {
        // исходя из названия переменной intArray[8] добавил массив целых чисел
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // объявление переменной d = 0 вынес из конструкции try - catch
        int d = 0;

        // 1й вариант - т.к. производится деление int на int,
        //              то нужно изменить тип данных переменной catchedRes1 на int.
        /*
        try {
            int catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
        */

        // 2й вариант - привести к типу данных double числитель (double) intArray[8]
        //              тогда в результате деления на ноль плучим бесконечность Infinity
        //              следовательно конструкция try - catch можно убрать (программа отработает без ошибок).
        double catchedRes1 = (double) intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
    }
}
