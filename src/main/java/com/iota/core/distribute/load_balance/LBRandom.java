package com.iota.core.distribute.load_balance;

public class LBRandom implements LBInterface {
    public Balanceable choice(Balanceable[] servers) {
        int index = (int) (Math.random() * servers.length);
        return servers[index];
    }
}
