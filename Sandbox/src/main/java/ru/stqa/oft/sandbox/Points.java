package ru.stqa.oft.sandbox;

public class Points {

    public double Point1;
    public double Point2;

    public Points(double Point1) {
        this.Point1 = Point1;
    }

    public double distance(double Point2) {
        this.Point2 = Point2;
        return this.Point2 - this.Point1;
    }

    public static void main(String[] args) {
        double test = new Points(22).distance(100);
        System.out.println("Дистанция между двумя точками  " + test);
    }
}


