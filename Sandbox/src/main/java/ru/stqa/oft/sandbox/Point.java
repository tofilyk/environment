package ru.stqa.oft.sandbox;

public class Point {
    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p2) {
        double var1 = (p2.x - x) * (p2.x - x);
        double var2 = (p2.y - y) * (p2.y - y);
        return Math.sqrt(var1 + var2);

    }

    public static void main(String[] args) {
        Point p1 = new Point(7, 6);
        Point p2 = new Point(13, 14);

        System.out.println("Расстояние между точками " + p1.distance(p2));


    }
}

