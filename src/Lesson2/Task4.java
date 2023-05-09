package Lesson2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        task4();
    }

    public static void task4() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введи текст: ");
        String lineText;
        lineText = in.nextLine();
        if (lineText.isEmpty()) {
            throw new RuntimeException("Пустые строки вводить нельзя!");
        } else {
            System.out.println(lineText);
        }
    }
}