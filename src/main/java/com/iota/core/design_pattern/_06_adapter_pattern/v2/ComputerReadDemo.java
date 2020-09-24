package com.iota.core.design_pattern._06_adapter_pattern.v2;

public class ComputerReadDemo {
    public static void main(String[] args) {
//        Computer computer = new ThinkpadComputer();
//        SDCard sdCard = new SDCardImpl();
//        System.out.println(computer.readSD(sdCard));

        Computer computer = new ThinkpadComputer();
        SDCard sdCard = new SDCardImpl();
        System.out.println(computer.readSD(sdCard));
        System.out.println("====================================");
        TFCard tfCard = new TFCardImpl();
        SDCard tfCardAdapterSD = new SDAdapterTF(tfCard);
        System.out.println(computer.readSD(tfCardAdapterSD));
    }
}
