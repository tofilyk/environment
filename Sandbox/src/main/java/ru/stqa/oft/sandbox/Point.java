package ru.stqa.oft.sandbox;

public class Point {
    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(ru.stqa.oft.sandbox.Point p1, ru.stqa.oft.sandbox.Point p2) {

        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));

    }

    public static void main(String[] args) {
        Point p1 = new ru.stqa.oft.sandbox.Point(7, 6);
        Point p2 = new ru.stqa.oft.sandbox.Point(13, 12);
        double trash = p1.x + p2.x;

        System.out.println("Расстояние между точками a (" + p1.x + "; " + p1.y +
                ") и b (" + p2.x + "; " + p2.y + ") = " + p1.distance(p1, p2));
        System.out.println(trash);


    }
}

