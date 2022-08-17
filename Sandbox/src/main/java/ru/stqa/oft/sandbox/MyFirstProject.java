package ru.stqa.oft.sandbox;

public class MyFirstProject {


    public static void main(String[] args) {


        hellow("Test");
        Square s = new Square(5);

        System.out.println("Площадь квадрата со стороной " + s.l + "=" + s.area());
        Rectangle r = new Rectangle(4,6);


        System.out.println("Площадь прямоугольник со сторонами  " + r.a + " и " + r.b + "=" + r.area());



    }

    public static void hellow(String samebode) {
        System.out.println("Hello " + samebode);
    }




}
