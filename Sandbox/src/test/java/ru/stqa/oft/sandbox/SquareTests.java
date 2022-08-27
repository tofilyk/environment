package ru.stqa.oft.sandbox;

import org.junit.Test;
import org.testng.Assert;



public class SquareTests {

    @Test
    public  void testArea1(){
        Square s=new Square(5);
               Assert.assertEquals(s.area(),25);

};

}









