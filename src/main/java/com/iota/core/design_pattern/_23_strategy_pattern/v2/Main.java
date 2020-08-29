package com.iota.core.design_pattern._23_strategy_pattern.v2;

// 通过枚举来巧妙干掉if-else的方案，对于减少 if-else 还有很多有趣的解决方案
public class Main {
    public static void main(String[] args) {
        String sign = "TOUTIAO";
        ChannelRuleEnum channelRule = ChannelRuleEnum.match(sign);
        GeneralChannelRule rule = channelRule.channel;
        rule.process();
    }
}
