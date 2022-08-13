package ru.stqa.oft.sandbox;

// S = √(x2 - x1)*2 + (y2 - y1)*2

public class Point {

    public static void main(String[] args) {
        PointClass ps= new PointClass(10,19,9,25);
        System.out.println("Расстояние на двумерной плоскости ="+ " " +ps.Distance());
    }
}
