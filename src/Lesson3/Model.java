package Lesson3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Model {
    static String[] titleData = {
            "Фамилия",
            "Имя",
            "Отчество",
            "датарождения(в формате dd.mm.yyyy)",
            "номертелефона(только цифры)",
            "пол(m-мужской/f-женский)"};

    static String[] numTitle = {
            "день",
            "месяц",
            "год"};

    //метод ввода данных
    public static String enterData() {
        return new Scanner(System.in).nextLine();
    }

    public static void printArray(String[] array) {
        for (String el : array
        ) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    //метод проверки персональных данных
    public static String[] checkPersonData(String personData) throws NullPointerException {
        String[] uncheckedData = personData.split(" ");
        if (uncheckedData.length > titleData.length) {
            System.out.println("введено больше данных".toUpperCase());
            return null;
        }
        String[] checkedData = new String[uncheckedData.length];
        Arrays.fill(checkedData, "false");
        try {
            int count = -1;
            for (String data : uncheckedData) {
                try {
                    long number = Long.parseLong(data);
                    if (number > Math.pow(10, 6)) {
                        checkedData[4] = String.valueOf(number);
                    }
                } catch (NumberFormatException ex) {
                    if (data.contains(".")) {
                        checkedData[3] = formatDate(data);
                    }
                    if (Character.isUpperCase(data.charAt(0))) {
                        count++;
                        checkedData[count] = data;
                    }
                    if (data.length() == 1 && (data.contains("m") || data.contains("f"))) {
                        checkedData[5] = data;
                    }
                }
            }
            checkFalse(checkedData).isEmpty();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("введено меньше данных".toUpperCase());
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
        return checkedData;
    }

    //метод проверки даты рождения
    public static String formatDate(String date) {
        String[] numbers = date.split("\\.");
        int[][] condition = {{1, 31}, {1, 12}, {1900, 2023}};
        for (int i = 0; i < numbers.length; i++) {
            try {
                int num = Integer.parseInt(numbers[i]);
                if (num < condition[i][0] || num > condition[i][1]) {
                    numbers[i] = "false";
                }
            } catch (NumberFormatException ex) {
                numbers[i] = "false";
            }
        }
        return String.join(".", numbers);
    }

    //процедура выявления пустых данных null
    public static String checkFalse(String[] checkedData) throws ArrayIndexOutOfBoundsException {
        int count = 0;
        StringBuilder errorData = new StringBuilder();
        if (checkedData[0].equals("false") ||
                checkedData[1].equals("false") ||
                checkedData[2].equals("false")) {
            count++;
            errorData.append("<");
            errorData.append(titleData[0]).append(" ");
            errorData.append(titleData[1]).append(" ");
            errorData.append(titleData[2]);
            errorData.append("> ");
        }
        if (checkedData[3].contains("false")) {
            String[] num = checkedData[3].split("\\.");
            for (int j = 0; j < num.length; j++) {
                if (num[j].equals("false")) {
                    count++;
                    errorData.append("<").append(numTitle[j]).append("> ");
                }
            }
        }
        for (int i = 4; i <= 5; i++) {
            if (checkedData[i].contains("false")) {
                count++;
                errorData.append("<").append(titleData[i]).append("> ");
            }
        }
        if (count >= 1) {
            System.out.print("Некорректно введены следующие данные: ".toUpperCase());
            System.out.println(errorData);
            return null;
        }
        return "";
    }

    //процедура записи пользовательских даных в файл
    public static void personDataWrite(String[] checkedData, boolean fileExist) throws IOException {
        String personData = String.join(" ", checkedData);
        String fileName = checkedData[0] + ".txt";
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName, true))) {
            if (fileExist) {
                buffer.newLine();
            }
            buffer.write(personData);
        }
    }

    //метод проверки на наличия файла
    public static boolean isFileExists(String fileName) {
        File file = new File(fileName + ".txt");
        return file.exists() && !file.isDirectory();
    }
}