package ru.stqa.oft.sandbox;

public class PointTest {
    public double x1;
    public double x2;
    public double y1;
    public double y2;

    public double p1(double x1, double x2) { // Точка №1( имеет две координаты)
        this.x1 = x1;
        this.x2 = x2;
        double p1 = (x2 - x1) * (x2 - x1);
        return p1;
    }
    ;
    public double p2(double y1, double y2) { // Точка №2( имеет две координаты)
        this.y1 = y1;
        this.y2 = y2;
        double p2 = (y2 - y1) * (y2 - y1);
        return p2;
    }
    ;
    public double distance(double p1, double p2) { // Фунция, которая вычислляет корень из двух точек
        return Math.sqrt(p1 + p2);
    }
    public static void main(String[] args) { // Вывод на консоль где задаем координаты для точки 1 и точки 2
        PointTest tMethod = new PointTest();
        System.out.println("Дистанция между двумя точками  " +tMethod.distance(tMethod.p1(9, 6), tMethod.p2(2, 12)));

    }
};





