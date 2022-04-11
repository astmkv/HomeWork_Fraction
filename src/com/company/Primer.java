package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Primer {


//    public static int searchNOD(int d1, int d2) {
//        if (d2 == 0) {
//            return d1;
//        }
//        return searchNOD(d2, d1 % d2);
//    }
//    public static int runNod(int nod) {
//        int num = 0;
//        for (int j = nod; j > 0; j--) {
//            int n = 0;
//
//            for (int i = 1; i <= j; i++) {
//                if (j % i == 0) {
//                    n++;
//                    if (n > 2) {
//                        break;
//                    }
//                }
//            }
//            if (n == 2) {
//                num = j;
//                break;
//            }
//        }
//        return num;
//}

    // numer > 0 либо numer < 0
    public static void fullPart(int numer, int denom) {
        int key = 1;
        if (numer < 0)
            key = -1;
            numer = Math.abs(numer);
            if (numer > denom && numer % denom != 0) {
                int full = numer / denom;
                numer %= denom;
                System.out.print(" = " + key * full + "(" + numer + "/" + denom + ")");

            } else if (numer % denom == 0) {
                int full = numer / denom;
                System.out.print(" = " + key * full);

            } else System.out.print(" = " + key * numer + "/" + denom);
        }


//        else if (numer < 0) {
//            numer *= -1;
//            if (numer > denom && numer % denom != 0) {
//                int full = numer / denom;
//                numer %= denom;
//                System.out.println(name + " = " + "-" + full + "(" + numer + "/" + denom + ")");
//            } else if (numer % denom == 0) {
//                int full = numer / denom;
//                System.out.println(name + " = " + "-" + full);
//            } else System.out.println(name + " = " + "-" + numer + "/" + denom);
//        }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

//        int a = in.nextInt();
//        int b = in.nextInt();
//
//        System.out.println(a + "/" + b);
//        System.out.println();

//        for ( ; a % 2 == 0 && b % 2 == 0 || a % 3 == 0 && b % 3 == 0; ) {
//            if (a % 2 == 0 && b % 2 == 0) {
//                a /= 2;
//                b /= 2;
//            } else if (a % 3 == 0 && b % 3 == 0) {
//                a /= 3;
//                b /= 3;
//            }
//
//        }
//        System.out.println(a + "/" + b);


//        System.out.println(searchNOD(a,b));
//
//       int nod = searchNOD(a,b);
//
//        System.out.println(runNod(nod));
//
//        int c = nod;
//        for ( ; ; ) {
//
//            a /= c;
//            b /= c;
//            if (a % runNod(nod) != 0 || b % runNod(nod) != 0) {
//                runNod(searchNOD(a,b));
//            }
//            if (searchNOD(a,b) == 1){
//                break;
//            }
//        }
//        System.out.println(a + "/" + b);

        int numer = in.nextInt();
        int denom = in.nextInt();

        System.out.println(numer + "/" + denom);

        fullPart(numer,denom);


    }
}