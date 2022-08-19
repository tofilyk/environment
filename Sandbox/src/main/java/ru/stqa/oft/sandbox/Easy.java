package ru.stqa.oft.sandbox;


public class Easy {

    public double x, y, j, w;

    public Easy() {

    }

    public double method1(double x, double y) {
        this.x = x;
        this.y = y;
        return x + y;

    }

    public double method2(double j) {
        this.j = j;
        return j * (x + y);

    }

    public double method3() {
        return w;
    }

    public static void main(String[] args) {
        Easy easy = new Easy();
        System.out.println(easy.method1(4, 7));
        System.out.println(easy.method2(8));
    }
}

