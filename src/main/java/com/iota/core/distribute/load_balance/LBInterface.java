package com.iota.core.distribute.load_balance;

public interface LBInterface {
    public Balanceable choice(Balanceable[] servers);
}
