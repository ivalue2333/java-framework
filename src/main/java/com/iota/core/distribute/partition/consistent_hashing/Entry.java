package com.iota.core.distribute.partition.consistent_hashing;

public class Entry {
    private String key;

    Entry(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }
}
