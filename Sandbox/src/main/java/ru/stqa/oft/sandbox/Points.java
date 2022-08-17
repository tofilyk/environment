package ru.stqa.oft.sandbox;

public class Points {

    public double Point1x1;
    public double Point1x2;
    public double Point2y1;
    public double Point2y2;

    public Points(double Point1x1, double Point1x2) {
        this.Point1x1 = Point1x1;
        this.Point1x2 = Point1x2;

    }
    public double distance(double Point2y1, double Point2y2) {
        this.Point2y1 = Point2y1;
        this.Point2y2 = Point2y2;
        double AllPoint2 = (this.Point2y2 - this.Point2y1) * (this.Point2y2 - this.Point2y1);
        return Math.sqrt(AllPoint2 + (this.Point1x2 - this.Point1x1) * (this.Point1x2 - this.Point1x1));
    }

    public static void main(String[] args) {
        double ResultConsole = new Points(7, 17).distance(5, 27);
        System.out.println("Дистанция между двумя точками  " + ResultConsole);

    }
}


