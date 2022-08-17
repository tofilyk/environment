package ru.stqa.oft.sandbox;

public class PointClass {
    public double x1 ;
    public double x2;
    public double y1 ;
    public double y2 ;
    double p1 = (x2 - x1) * (x2 - x1);
    double p2 = (y2 - y1) * (y2 - y1);

    public PointClass(double x1, double x2, double y1, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    };


    public double Distance() {
        return Math.sqrt(((x2 - x1) * (x2 - x1)+(y2 - y1) * (y2 - y1)));
    }
    public static void main(String[] args) {
        PointClass ps= new PointClass(10,19,9,25);
        System.out.println("Расстояние на двумерной плоскости ="+ " " +ps.Distance());
    }
}