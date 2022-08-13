package ru.stqa.oft.sandbox;

public class MyFirstProject {


    public static void main(String[] args) {
        hellow("Test");
        Square s = new Square(5);

        System.out.println("Площадь квадрата со стороной " + s.l + "=" + area(s));
        Rectangle r = new Rectangle(4,6);
        
        System.out.println("Площадь прямоугольник со сторонами  " + r.a + " и " + r.b + "=" + area(r));
    }

    public static void hellow(String samebode) {
        System.out.println("Hello " + samebode);
    }

    public static double area(Square s) {
        return s.l * s.l;
    }

    public static double area(Rectangle r) {
        return r.a * r.b;
    }
}
