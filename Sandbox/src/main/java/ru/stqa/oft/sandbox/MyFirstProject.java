package ru.stqa.oft.sandbox;

public class MyFirstProject {


    public static void main(String[] args) {
        hellow("Test");
   double l=5;
     System.out.println("Площадь квадрата со стороной "+l+"="+area(l));

    double a=4;
    double b =6;
System.out.println("Площадь прямоугольник со сторонами  "+a+" и "+b+"="+ area(a,b)); }

        public static void hellow(String samebode){
                   System.out.println("Hello "+samebode);
        }

        public static double area(double len){return len*len;}

    public static double area(double a,double b){return a*b;}
    }
