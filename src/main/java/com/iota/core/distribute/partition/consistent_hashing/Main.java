package com.iota.core.distribute.partition.consistent_hashing;

public class Main {
    public static void main(String[] args) {
        Cluster c = createCluster();

        Entry[] entries = {
                new Entry("i"),
                new Entry("have"),
                new Entry("a"),
                new Entry("pen"),
                new Entry("an"),
                new Entry("apple"),
                new Entry("applepen"),
                new Entry("pineapple"),
                new Entry("pineapplepen"),
                new Entry("PPAP")
        };

        for (Entry e : entries)
            c.put(e);

        c.addServer(new Server("1"));
        findEntries(c, entries);

    }

    private static Cluster createCluster() {
        Cluster c = new Cluster();
        c.addServer(new Server("international"));
        c.addServer(new Server("china"));
        c.addServer(new Server("japan"));
        c.addServer(new Server("Amarica"));
        c.addServer(new Server("samsung"));
        return c;
    }

    private static void findEntries(Cluster c, Entry[] entries) {
        for (Entry e : entries) {
            if (e == c.get(e)) {
                System.out.println("重新找到了entry:" + e);
            } else {
                System.out.println("entry已失效:" + e);
            }
        }
    }
}