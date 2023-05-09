package Lesson2;

public class Task3 {
    // в методе main нужно убрать конструкцию throws Exception
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
            // блок catch (Throwable ex) нужно переместить в конец констукции try - catch
            // блок catch (NullPointerException ex) не нужен, т.к. у переменных a и b не ссылочный тип данных
            // примитив int не может хратить null
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    // в методе printSum нужно убрать конструкцию throws FileNotFoundException
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}