package com.iota.core.design_pattern._10_decorator_pattern;

public class Circle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Shape: Circle");
   }
}