package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Fraction fr1 = new Fraction();

        System.out.println("Задано в конструкторе по-умолчанию:");
        fr1.display();  // вывод в консоль

        System.out.println();
        Fraction fr2 = new Fraction();
        fr2.input(in);                  // ввод данных для дробей
        fr2.display();

        System.out.println();
        Fraction fr3 = new Fraction();
        System.out.println("Установлено через сеттеры:");
        fr3.setName("fr3");
        fr3.setN(5);
        fr3.setD(11);
        fr3.display();

        System.out.println();
        System.out.println("Установлено через конструктор с 3-мя параметрами:");
        Fraction fr4 = new Fraction("fr4",4,17);  // конструктор с 3-мя параметрами
        fr4.display();
//
//        System.out.println("\nBefore: ");
//        fr1.display();
//        System.out.println("After: ");
//        fr1.fullPart();                               // выеделение целой части
//
//        System.out.println("\nBefore: ");
//        fr2.display();
//        System.out.println("After: ");
//        fr2.fullPart();
//
//        System.out.println("\nBefore: ");
//        fr3.display();
//        System.out.println("After: ");
//        fr3.fullPart();

        System.out.print("\n" + fr1.getN() + "/" + fr1.getD() + " + " + fr2.getN() + "/" + fr2.getD() + " = " );
        Fraction fr5 = fr1.Sum(fr2);                    // сложили 2 дроби
        fr5.delFraction();                              // сокращение дроби
        fr5.fullPart();                                 // выделили целую часть

        System.out.println();
        fr1 = new Fraction();
        System.out.print("\n" + fr1.getN() + "/" + fr1.getD() + " - " + fr2.getN() + "/" + fr2.getD() + " = " );
        Fraction fr6 = fr1.Diff(fr2);                   // разность 2-х дробей
        fr6.delFraction();                              // сокращение дроби
        fr6.fullPart();                                 // выделили целую часть

        System.out.println();
        fr1 = new Fraction();
        System.out.print("\n" + fr1.getN() + "/" + fr1.getD() + " * " + fr2.getN() + "/" + fr2.getD() + " = " );
        Fraction fr7 = fr1.Mult(fr2);                    // произведение 2-х дробей
        fr7.delFraction();                               // сокращение дроби
        fr7.fullPart();                                  // выделили целую часть

        System.out.println();
        fr1 = new Fraction();
        System.out.print("\n" + fr1.getN() + "/" + fr1.getD() + " / " + fr2.getN() + "/" + fr2.getD() + " = " );
        Fraction fr8 = fr1.Div(fr2);                     // частное 2-х дробей
        fr8.delFraction();                               // сокращение дроби
        fr8.fullPart();                                  // выделили целую часть
    }
}
