package com.iota.core.design_pattern._10_decorator_pattern;

public class DecoratorPatternDemo {
   public static void main(String[] args) {
 
      Shape circle = new Circle();
 
//    核心代码，给原来的circle包裹一层装饰器，而RedShapeDecorator继承自Shape
      Shape redCircle = new RedShapeDecorator(new Circle());
 
      Shape redRectangle = new RedShapeDecorator(new Rectangle());
      System.out.println("Circle with normal border");
      circle.draw();
 
      System.out.println("\nCircle of red border");
      redCircle.draw();
 
      System.out.println("\nRectangle of red border");
      redRectangle.draw();
   }
}