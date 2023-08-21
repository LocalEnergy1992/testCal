import java.util.Calendar;
import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в калькулятор!");
        System.out.println("Введите выражение!");
        Scanner console = new Scanner(System.in); //объявил переменную типа scanner-назвали console, создали новый объект scanner и присвоили к переменной
        String result = calc(console.nextLine());// вызываем метод(nextLine), который считывает данные с консоли(именно одну строку) и кладем результат в переменную value
        System.out.println(result);
    }

    private static String calc(String input) {

        String[] parts = input.split("[+\\-*/]");//метод сплит разбивает строку на массив строк по паттерну, например символ +,- и т.д/[+-*] - любой из символов подойдет для разделения
        if (parts.length != 2) {//говорим что нужно проверить длину массива, если она именно не равна 2 то вызываем исключение
            throw new RuntimeException("Неверное количество операнд");//ключевое слово throw, в данном случает сами объявляем что будет ошибкой, new - ключевое слово RuntimeException это класс
        }
        String left = parts[0].trim();//метод у строки, обрезает все "пробелы"
        String right = parts[1].trim();//метод у строки, обрезает все "пробелы"
//*
        boolean isLeftRoman = isRoman(left);// объявил переменную, которая берёт и проверяет left на наличие римских цифр
        boolean isRightRoman = isRoman(right);// объявил переменную, которая берёт и проверяет right на наличие римских цифр
        if(isLeftRoman != isRightRoman) {
            throw new RuntimeException("Оба числа должны быть Арабские или Римские");// проверил, что бы left, right были одного типа, если нет то падаем в исключение
        }
        int oneX = parseNumber(left);//записали left в переменную left
        int twoY = parseNumber(right);//записали left в переменную right
        // в итоге получили два значения

        //проверка переменных на диапазон
        if (oneX < 1 || oneX > 10 || twoY < 1 || twoY > 10) {
            throw new RuntimeException("Числа не попадают в диапазон");//выполнили проверку чисел на диапазон условия
        }
        int result;
        if (input.contains("+")) {//contains это метод который возвращает true/false
            result = oneX + twoY;
        } else if (input.contains("-")) {
            result = oneX - twoY;
        } else if (input.contains("*")) {
            result = oneX * twoY;
            ;
        } else {
            result = oneX / twoY;
        }
        if (isLeftRoman) {
           if (result < 1){
               throw new RuntimeException("Результат вычисления выражения с римскими числами не должен быть меньше I");
           }
            return arabicToRoman(result);
        } else {
            return String.valueOf(result);
        }


    }

    private static boolean isRoman(String number) { //метод сравнивающий полученную строку на римские цифры и возвращает true||false
        return number.equals("I")
                || number.equals("II")
                || number.equals("III")
                || number.equals("IV")
                || number.equals("V")
                || number.equals("VI")
                || number.equals("VII")
                || number.equals("VIII")
                || number.equals("IX")
                || number.equals("X");
    }

    private static int parseNumber(String number) { //метод сравнивает полученную строку и присваивает значение
        if (number.equals("I")) {
            return 1;
        } else if (number.equals("II")) {
            return 2;
        } else if (number.equals("III")) {
            return 3;
        } else if (number.equals("IV")) {
            return 4;
        } else if (number.equals("V")) {
            return 5;
        } else if (number.equals("VI")) {
            return 6;
        } else if (number.equals("VII")) {
            return 7;
        } else if (number.equals("VIII")) {
            return 8;
        } else if (number.equals("IX")) {
            return 9;
        } else if (number.equals("X")) {
            return 10;
        } else {
            return Integer.parseInt(number);
        }
    }

    private static String arabicToRoman(int numberArabic) {// Результат больше 100 невозможен, так как самое "большое" выражение может быть "10*10" или "X*X"

        int tens = numberArabic / 10;// Считаем сколько "десяток" в получившемся числе.
        int units = numberArabic % 10; // И сколько единиц.


        String t; // Переводим десятки в римские.
        if (tens == 1) {
            t = "X";
        } else if (tens == 2) {
            t = "XX";
        } else if (tens == 3) {
            t = "XXX";
        } else if (tens == 4) {
            t = "XL";
        } else if (tens == 5) {
            t = "L";
        } else if (tens == 6) {
            t = "LX";
        } else if (tens == 7) {
            t = "LXX";
        } else if (tens == 8) {
            t = "LXXX";
        } else if (tens == 9) {
            t = "XC";
        } else if (tens == 10) {
            t = "C";
        } else {
            t = "";
        }


        String u;// Переводим единицы в римские.
        if (units == 1) {
            u = "I";
        } else if (units == 2) {
            u = "II";
        } else if (units == 3) {
            u = "III";
        } else if (units == 4) {
            u = "IV";
        } else if (units == 5) {
            u = "V";
        } else if (units == 6) {
            u = "VI";
        } else if (units == 7) {
            u = "VII";
        } else if (units == 8) {
            u = "VIII";
        } else if (units == 9) {
            u = "IX";
        } else {
            u = "";
        }

        // Конкатенируем две строки.
        return t + u;
    }
}



