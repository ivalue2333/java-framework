package com.iota.core.design_pattern._06_adapter_pattern.v2;

public class ThinkpadComputer implements Computer {
    @Override
    public String readSD(SDCard sdCard) {
        if(sdCard == null)throw new NullPointerException("sd card null");
        return sdCard.readSD();
    }
}