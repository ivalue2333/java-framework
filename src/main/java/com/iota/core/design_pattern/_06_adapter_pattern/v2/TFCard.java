package com.iota.core.design_pattern._06_adapter_pattern.v2;

public interface TFCard {
    String readTF();
    int writeTF(String msg);
}
