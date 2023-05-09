package Lesson2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Получено дробное число -> " +
                requestFloatNumber()
        );
    }

    public static float requestFloatNumber() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введи дробное число: ");
        float number;
        try {
            number = in.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Был введен текст!");
            number = requestFloatNumber();
        } finally {
            in.close();
        }
        return number;
    }
}