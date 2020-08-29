package com.iota.core.distribute.partition.consistent_hashing;


import java.util.SortedMap;
import java.util.TreeMap;

// 数据分区， 一致性哈希算法的 Java 实现
public class Cluster {
    private static final int SERVER_SIZE_MAX = 1024;

    private SortedMap<Integer, Server> servers = new TreeMap<Integer, Server>();
    private int size = 0;

    public void put(Entry e) {
        routeServer(e.hashCode()).put(e);
    }

    public Entry get(Entry e) {
        return routeServer(e.hashCode()).get(e);
    }

    public Server routeServer(int hash) {
        if (servers.isEmpty())
            return null;

        if (!servers.containsKey(hash)) {
            SortedMap<Integer, Server> tailMap = servers.tailMap(hash);
            hash = tailMap.isEmpty() ? servers.firstKey() : tailMap.firstKey();
        }

        // 找出大于对象的 hash 值的最小的哈希值， 并获取到这个服务节点
        return servers.get(hash);
    }

    public boolean addServer(Server s) {
        if (size >= SERVER_SIZE_MAX)
            return false;

        System.out.println(String.format("server hashCode:%s", s.hashCode()));
        servers.put(s.hashCode(), s);

        size++;
        return true;
    }
}
