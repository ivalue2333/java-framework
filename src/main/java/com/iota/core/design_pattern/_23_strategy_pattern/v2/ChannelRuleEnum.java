package com.iota.core.design_pattern._23_strategy_pattern.v2;

public enum ChannelRuleEnum {

    /**
     * 头条
     */
    TOUTIAO("TOUTIAO",new TouTiaoChannelRule()),
    /**
     * 腾讯
     */
    TENCENT("TENCENT",new TencentChannelRule()),
    ;

    public String name;

    public GeneralChannelRule channel;

    ChannelRuleEnum(String name, GeneralChannelRule channel) {
        this.name = name;
        this.channel = channel;
    }

    //匹配
    public static ChannelRuleEnum match(String name){
        ChannelRuleEnum[] values = ChannelRuleEnum.values();
        for (ChannelRuleEnum value : values) {
            if(value.name.equals(name)){
                return value;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }

    public GeneralChannelRule getChannel() {
        return channel;
    }
}
