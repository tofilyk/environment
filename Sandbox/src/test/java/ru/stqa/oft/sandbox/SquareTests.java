package ru.stqa.oft.sandbox;

import org.junit.Test;
import org.testng.Assert;



public class SquareTests {

    @Test
    public  void testArea1(){
        Square s=new Square(5);
               Assert.assertEquals(s.area(),25);

};
@Test
public  void test1(){

    Point p1 = new Point(7, 6);
    Point p2 = new Point(13, 14);
    double test1 =p1.distance(p2);
    Assert.assertEquals( test1,10.0);


};
    @Test
    public  void test2(){

        Point p1 = new Point(7, 6);
        Point p2 = new Point(13, 14);
        double test2 = (p2.x -p1.x)*(p2.x -p1.x);
        Assert.assertEquals( test2,36);


    };
    @Test
    public  void test3(){

        Point p1 = new Point(7, 6);
        Point p2 = new Point(13, 14);
        double test3 = (p2.y -p1.y)*(p2.y -p1.y);
        Assert.assertEquals( test3,64);


    };
    @Test
    public  void test4(){

        Point p1 = new Point(78, 15);
        Point p2 = new Point(28, 11);
        double test4 = p1.distance(p2);
        Assert.assertEquals( test4,50.15974481593781);


    };


}









