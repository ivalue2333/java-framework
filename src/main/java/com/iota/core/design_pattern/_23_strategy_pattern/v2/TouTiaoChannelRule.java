package com.iota.core.design_pattern._23_strategy_pattern.v2;

public class TouTiaoChannelRule extends GeneralChannelRule {
    @Override
    public void process() {
        // TouTiao 处理逻辑
        System.out.println("TouTiao process");
    }
}
