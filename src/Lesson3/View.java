package Lesson3;

public class View {

    //процедура вывода запроса на ввод персональных данных
    public static void dataMessage(String[] dataTitle) {
        System.out.println("введите через пробел свои персональные данные в следующем виде:".toUpperCase());
        for (String title : dataTitle
        ) {
            System.out.print(title + " ");
        }
        System.out.println();
        System.out.println("*".repeat(108));
    }

    //процедура вывода сообщения о записи персональными данными
    public static void writeMessage() {
        System.out.println("персональные данные записаны".toUpperCase());
    }

    //процедура вывода сообщения о запрете записи персональными данными
    public static void writeNotMessage() {
        System.out.println("-> запись персональных данных невозможна".toUpperCase());
    }
}