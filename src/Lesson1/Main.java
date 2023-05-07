package Lesson1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // первый целочисленный массив
        int[] arrayFirst = randomArray(
                sizeArray()
        );
        // второй целочисленный массив
        int[] arraySecond = randomArray(
                sizeArray()
        );
        System.out.printf("Первый массив -> %s\n",
                Arrays.toString(arrayFirst)
        );
        System.out.printf("Второй массив -> %s\n",
                Arrays.toString(arraySecond));

        // вывод массива, элементы которого - разность элементов двух массивово
        System.out.printf("     Разность -> %s\n",
                Arrays.toString(diffArray(arrayFirst, arraySecond))
        );

        // вывод массива, элементы которого - частное элементов двух массивово
        System.out.printf("      Частное -> %s\n",
                Arrays.toString(divArray(arrayFirst, arraySecond)
                )
        );
    }

    // метод запроса длины массива
    public static int sizeArray() {
        System.out.print("Введи значение длины массива -> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    // метод получения рандомного массива заданной пользователем длины
    public static int[] randomArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size * 3);
        }
        return array;
    }

    // метод получения массива элементы которого - разность элементов двух заданных массивов (в той же ячейке)
    public static int[] diffArray(int[] array1, int[] array2) {
        int size = array1.length;
        if (size != array2.length) {
            throw new RuntimeException("Ошибка! Массивы разной длины.");
        }
        int[] resultArray = new int[size];
        for (int i = 0; i < size; i++) {
            resultArray[i] = array1[i] - array2[i];
        }
        return resultArray;
    }

    // метод получения массива элементы которого - частное элементов двух заданных массивов (в той же ячейке)
    public static double[] divArray(int[] array1, int[] array2) {
        int size = array1.length;
        if (size != array2.length) {
            throw new RuntimeException("Ошибка! Массивы разной длины.");
        }
        double[] resultArray = new double[size];
        for (int i = 0; i < size; i++) {
            if (array2[i] == 0) {
                throw new RuntimeException("Ошибка деления на ноль! Элемент второго массива равен нолю.");
            }
            resultArray[i] = Math.round(1.0 * array1[i] / array2[i] * 1000) / 1000.0;
        }
        return resultArray;
    }
}