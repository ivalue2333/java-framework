package com.iota.core.design_pattern._06_adapter_pattern.v2;

public class SDAdapterTF implements SDCard {
    private TFCard tfCard;
    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }
    @Override
    public String readSD() {
        System.out.println("adapter read tf card ");
        return tfCard.readTF();
    }
    @Override
    public int writeSD(String msg) {
        System.out.println("adapter write tf card");
        return tfCard.writeTF(msg);
    }
}
