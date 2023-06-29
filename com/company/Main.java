package com.company;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int i=1;
        int i2=2;
        int i3=3;
        System.out.println("Введите орифметическоеpoiuhtgfdfghyjuiop[ выражение с пробелом между символами, используя только арабские или только римские числа: ");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String[] symbolsArray = expression.split(" ");
        if (symbolsArray.length > 3) {
            System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
            return;
        }
        String A = symbolsArray[0];
        try {
            String sign = symbolsArray[1];
            String B = symbolsArray[2];
            int yazikA = romanOrArabic(A);
            int yaziB = romanOrArabic(B);
            if ((yazikA == 2) && (yaziB == 2)) {
                int AInt = Integer.parseInt(A);
                int BInt = Integer.parseInt(B);
                int result = vichislit(AInt, sign, BInt);
                System.out.println(result);
            } else if ((yazikA == 1) && (yaziB == 1)) {
                int A2 = fromRomanToArab(A);
                int B2 = fromRomanToArab(B);
                int result = vichislit(A2, sign, B2);
                if (result < 0) {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("В римской системе счисления нет отрицательных чисел");
                    }
                }
                if (result == 0) {
                    System.out.println("0");
                } else {
                    System.out.println(fromArabToRoman(result));
                }
                ;
            } else {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Используются одновременно разные системы счисления");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Строка не является математической операцией");
        }
    }

    static int vichislit(int A, String znakStr, int B) {
        int result = 0;
        switch (znakStr) {
            case "+" -> {
                result = A + B;
                break;
            }
            case "-" -> {
                result = A - B;
                break;
            }
            case "*" -> {
                result = A * B;
                break;
            }
            case "/" -> {
                result = A / B;
                break;
            }
        }
        return result;
    }

    static int fromRomanToArab(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else {
            return 0;
        }

    }

    public static int romanOrArabic(String chek) {   //метод определения содержится в String римское число или арабское,
        int index = 0;                                    //возвращает 2, если арабское, здесь же проверка на диапазон [0-10]
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        for (int i = 0; i < romanNumbers.length; i++) {
            if (romanNumbers[i].equalsIgnoreCase(chek)) index += 1;
            else if (arabNumbers[i].equals(chek)) index += 2;
        }
        if (index == 2) return 2;
        else if (index == 1) return 1;
        return 0;
    }

    public static String fromArabToRoman(int Int) {
        //как работает этот метод пока не до конца понимаю, т.к. эту тему еще не изучала
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();   //просто нашла и применила
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for (Map.Entry<String, Integer> entry : roman_numerals.entrySet()) {
            int matches = Int / entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }

    public static String repeat(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

}
