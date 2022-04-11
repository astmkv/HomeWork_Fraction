package com.company;

import java.util.Scanner;

public class Fraction {

    Scanner in = new Scanner(System.in);

    // поля класса Fraction

    private String name;
    private int numer;
    private int denom;


    // getters

    public String getName() {
        return name;
    }

    public int getN() {
        return numer;
    }

    public int getD() {
        return denom;
    }


    // setters

    public void setName(String str) {
        name = str;
    }

    public void setN(int value) {

        numer = value;
    }

    public void setD(int value) {

        if (value <= 0) {
            System.out.println("Укажите знаменатель больше 0!");                // если будет установлен знаменатель меньше 0,
            System.exit(0);                                               // то программа завершится и в консоли появится подсказка
        }
        denom = value;
    }

    // конструкторы

    // 1. конструктор без параметров (конструктор по-умолчанию)

    public Fraction() {
        //инициализация полей по-умолчанию
        numer = 122;
        denom = 57;
        name = "fr1";
//        System.out.println("Constructor is worked!");
    }

    // 2. конструктор с параметрами
    public Fraction(String _name, int _N, int _D) {
        name = _name;
        numer = _N;
        denom = _D;
    }

    // МЕТОДЫ КЛАССА Fraction

    // метод вывода в консоль
    public void display() {
        System.out.println(toString());
    }

    // метод представления класса в виде строки
    // перегрузка метода toString()
    @Override
    public String toString() {

        return name + ": " + numer + "/" + denom;
    }

    // метод ввода данных с клавиатуры
    public void input(Scanner in) {

        System.out.println("\nВведите данные для дроби: ");

        System.out.print("Название: ");
        name = in.nextLine();

        for (int i = 0; i < 2; i++) {
            System.out.print("Числитель: ");
            numer = in.nextInt();
            if (numer == 0) {
                if (i == 0) {
                    System.out.print("Такая дробь будет равна нулю! ");
                    System.out.println("Укажите другое число, либо снова укажите 0, если хотите продолжить");
                }
            } else break;
        }

        for (; ; ) {
            System.out.print("Знаменатель: ");
            denom = in.nextInt();
            if (denom <= 0) {
                System.out.println("Некорректное значение, введите число большее, чем 0!");
            } else break;
        }


    }

    // метод сокращения дроби

    // находим НОД числителя и знаменателя
    public static int runNod(int nod) {
        int num = 0;
        for (int j = nod; j > 0; j--) {
            int n = 0;

            for (int i = 1; i <= j; i++) {
                if (j % i == 0) {
                    n++;
                    if (n > 2) {
                        break;
                    }
                }
            }
            if (n == 2) {
                num = j;
                break;
            }
        }
        return num;
    }

    // само сокращение дроби
    public void delFraction() {

        if (denom < 0) {
            denom *= -1;
            numer *= -1;
        }
        if (denom == 0) {
            System.out.println("");
        } else {
            if (numer != 0) {
                int key = 0;
                if (numer < 0) {
                    numer *= -1;
                    key = -1;
                }

                int gcd = recGCD(numer, denom);

                int a = gcd;

                for (; ; ) {

                    if (recGCD(numer, denom) == 1) {
                        break;
                    }
                    numer /= a;
                    denom /= a;
                    if (numer % runNod(gcd) != 0 || denom % runNod(gcd) != 0) {
                        runNod(recGCD(numer, denom));
                    }
                }
                if (key == -1) numer *= -1;
                System.out.print(numer + "/" + denom);

            } else System.out.print("0");
        }
    }
    // метод выделения целой части дроби

    public void fullPart() {
        if (denom == 0) {
            System.out.println("");
        } else {
            int key = 1;
            if (numer < 0)
                key = -1;
            numer = Math.abs(numer);
            if (numer > denom && numer % denom != 0) {
                int full = numer / denom;
                numer %= denom;
                System.out.println(" = " + key * full + "(" + numer + "/" + denom + ")");
            } else if (numer % denom == 0) {
                int full = numer / denom;
                System.out.println(" = " + key * full);
            } else System.out.println(" = " + key * +numer + "/" + denom);
        }
    }
    // метод сложения 2-х дробей
    // при разных знаменателях необходимо найти НОК их значений,
    // для этого созданы методы нахожедния НОД (recGCD) и НОК (searchLCD);

    public Fraction Sum(Fraction result) {
        Fraction res = new Fraction();
        if (denom == result.denom) {
            numer += result.numer;
            name = "";
        } else if (denom != result.denom) {
            int lcd = searchLCD(denom, result.denom);
            int newNumer = (lcd / denom * numer + lcd / result.denom * result.numer);
            numer = newNumer;
            denom = lcd;
            name = "";
        }
        return res = new Fraction(name, numer, denom);
    }

    // нахождение НОД
    public static int recGCD(int d1, int d2) {
        if (d2 == 0) {
            return d1;
        }
        return recGCD(d2, d1 % d2);
    }

    // нахождение НОК
    public int searchLCD(int d1, int d2) {
        return d1 / recGCD(d1, d2) * d2;
    }

    // метод вычитания 2-х дробей
    public Fraction Diff(Fraction result) {
        Fraction res;
        if (denom == result.denom) {
            name = "";
            numer -= result.numer;

        } else if (denom != result.denom) {
            int lcd = searchLCD(denom, result.denom);
            int newNumer = (lcd / denom * numer - lcd / result.denom * result.numer);

            numer = newNumer;
            denom = lcd;
            name = "";

        }
        return res = new Fraction(name, numer, denom);
    }

    // метод умножения 2-х дробей
    public Fraction Mult(Fraction result) {
        Fraction res = new Fraction("", numer *= result.numer, denom *= result.denom);
        return res;
    }

    // метод деления 2-х дробей
    public Fraction Div(Fraction result) {
        Fraction res;
        if (result.numer == 0) {
            System.out.println("В общем случае делить на 0 не стоит, но также можно утверждать, что ответ стремится к бесконечности");
            res = new Fraction("", 1, 0);
        } else if (numer < 0 && result.numer < 0) {
            numer *= -1;
            result.numer *= -1;
            res = new Fraction("", numer *= result.denom, denom *= result.numer);
        } else
            res = new Fraction("", numer *= result.denom, denom *= result.numer);
        return res;
    }

}