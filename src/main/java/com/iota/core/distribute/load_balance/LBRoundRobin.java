package com.iota.core.distribute.load_balance;

public class LBRoundRobin {
    Integer pos = 0;

    public Balanceable choice(Balanceable[] servers) {
        Balanceable result = null;
        synchronized (pos) {
            if (pos >= servers.length) {
                pos = 0;
            }
            result = servers[pos];
            pos++;
        }
        return result;
    }
}
