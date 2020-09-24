package com.iota.core.design_pattern._06_adapter_pattern.v2;

public interface SDCard {
    //读取SD卡方法
    String readSD();
    //写入SD卡功能
    int writeSD(String msg);
}