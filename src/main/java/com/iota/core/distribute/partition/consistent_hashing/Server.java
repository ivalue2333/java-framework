package com.iota.core.distribute.partition.consistent_hashing;


import java.util.HashMap;
import java.util.Map;

public class Server {
    private String name;
    private Map<Entry, Entry> entries;

    Server(String name) {
        this.name = name;
        entries = new HashMap<Entry, Entry>();
    }

    public void put(Entry e) {
        entries.put(e, e);
    }

    public Entry get(Entry e) {
        return entries.get(e);
    }


    public int hashCode() {
        return name.hashCode();
    }
}
