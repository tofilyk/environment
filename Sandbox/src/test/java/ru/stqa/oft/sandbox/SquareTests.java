package ru.stqa.oft.sandbox;

import org.junit.Test;
import org.testng.Assert;

public class SquareTests {

    @Test
    public  void testArea(){
        Square s=new Square(5);
               Assert.assertEquals(s.area(),25);;
    };
    @Test
    public  void Distance1(){
        PointClass ps= new PointClass(10,19,9,25);
        Assert.assertEquals(ps.Distance(),18.35755975068582);
    };
    @Test
    public  void Distance2(){
        PointClass ps= new PointClass(14,26,3,25);
        Assert.assertEquals(ps.x2-ps.x1,12);
    };
    @Test
    public  void Distance3(){
        PointClass ps= new PointClass(18,19,11,33);
        Assert.assertEquals(ps.y2-ps.y1,22);
    };
    @Test
    public  void Distance4(){
        PointClass ps= new PointClass(15,19,11,18);
        Assert.assertEquals((ps.x2-ps.x1)*(ps.x2-ps.x1),16);
    };
    @Test
    public  void Distance5(){
        PointClass ps= new PointClass(15,19,12,18);
        Assert.assertEquals((ps.y2-ps.y1)*(ps.y2-ps.y1),36);
    };
}






