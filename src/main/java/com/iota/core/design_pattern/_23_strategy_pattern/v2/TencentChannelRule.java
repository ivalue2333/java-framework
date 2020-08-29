package com.iota.core.design_pattern._23_strategy_pattern.v2;

public class TencentChannelRule extends GeneralChannelRule {
    @Override
    public void process() {
        // Tencent 处理逻辑
        System.out.println("tencent process");
    }
}