import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в кальклятор!");
        System.out.println("Введите выражение!");


        Scanner console = new Scanner(System.in); //объевили переменную типа scanner-назвали cinsole, создали новый  объект scanner и присвоили к переменной
        String value = console.nextLine();// вызываем метод(nextLine), который считывает данные с консоли(именно одну строку) и кладем результат в переменную value
        String[] parts = value.split("[+\\-*/]");//метод сплит разбивает строку на массив строк по паттерну? навпример символ +,- и т.д/[+-*] - для регулярки это значит, что люой из символов подойдет для разделения
        if (parts.length != 2) {//говорим что нужно проверить длмнну массива, если она именно не равна 2 то вызываем исключение
            throw new RuntimeException("Неверное колличество операнд");//ключевое слово throw, в данном случает сами объяявлем что будет ошибкой, new - ключевое слово RuntimeException - типчиное исключение, это класс
        }
        String left = parts[0].trim();//метод у сторки, обрезает все "пробелы"
        String right = parts[1].trim();//метод у сторки, обрезает все "пробелы"
        int oneX = Integer.parseInt(left);// объявляем переменную и приводим переменную left к числу
        int twoY = Integer.parseInt(right);//-/-


        if(oneX  <1 || oneX >10 || twoY <1 || twoY >10){
            throw new RuntimeException("Числа не попадают в диапозон");//выполнили проверку чисел на диапазон условия
        }
        System.out.print("Результат: ");
        if (value.contains("+")) {//contains это метод который возвращает true/false
            System.out.println(oneX + twoY);
        } else if (value.contains("-")) {
            System.out.println(oneX - twoY);
        } else if (value.contains("*")) {
            System.out.println(oneX * twoY);
        } else {
            System.out.println(oneX / twoY);
        }


    }
}


