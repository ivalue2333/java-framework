package com.iota.core.distribute.load_balance;

public class Balanceable implements Comparable<Balanceable> {

    private int Weight;

    // 获取节点权重
    public int getWeight() {
        return this.Weight;
    }

    // 获取当前连接数
    public int getActive() {
        return 0;
    }

    @Override
    public int compareTo(Balanceable o) {
        return this.Weight > o.Weight ? 1 : 0;
    }
}
