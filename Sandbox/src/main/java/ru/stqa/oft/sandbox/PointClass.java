package ru.stqa.oft.sandbox;

public class PointClass {
    public double x1 = 10;
    public double x2 = 19;
    public double y1 = 9;
    public double y2 = 25;
    double p1 = (x2 - x1) * (x2 - x1);
    double p2 = (y2 - y1) * (y2 - y1);

    public PointClass(double x1, double x2, double y1, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double Distance() {
        return Math.sqrt(p1 + p2);

    }
}