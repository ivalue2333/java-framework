package com.iota.core.design_pattern._01_factory_pattern;

public class Square implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}