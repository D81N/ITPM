package com.lab1;

import java.util.Scanner;

public class Main {

    public static final double EPSILON = 1e-6;


    public static void main(String[] args) {
        System.out.println("Мінімум функції знаходиться у точці: " + findMinimum(-1, -0.5));
        new Scanner(System.in).nextInt();
    }

    public static double findMinimum(double a, double b) {

        int iteration = 0;

        while (Math.abs(b - a) > EPSILON) {
            double L = b - a;
            double xm = (a + b) / 2;
            double fXm = f(xm);

            double x1 = a + L / 4;
            double x2 = b - L / 4;
            double fX1 = f(x1);
            double fX2 = f(x2);

            if (fX1 < fXm) {
                b = xm;
                xm = x1;
            } else if (fX2 < fXm) {
                a = xm;
                xm = x2;
            } else {
                a = x1;
                b = x2;
            }

            iteration++;

            System.out.println("ITERATION " + iteration);
            System.out.println("\ta = " + a + " | b = " + b);
            System.out.println("\tx1 = " + x1 + " | x2 = " + x2);
            System.out.println("\tf(x1) = " + fX1 + " | f(x2) = " + fX2);
            System.out.println("\tf(Xm) = " + fXm);
        }

        return (a + b) / 2;
    }

    public static double f(double x) {
        return 2 * x + Math.pow(x, 2) - Math.pow(x, 3) / 5;
    }
}
