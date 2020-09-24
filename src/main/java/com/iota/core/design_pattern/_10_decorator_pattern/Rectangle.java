package com.iota.core.design_pattern._10_decorator_pattern;

public class Rectangle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Shape: Rectangle");
   }
}