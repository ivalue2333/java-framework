package com.iota.core.algorithm.data_structure;

public class QuickUnion {
    private int[] roots;

    private QuickUnion(int size) {
        this.roots = new int[size];

        for (int i = 0; i < size; ++i) {
            roots[i] = i;
        }
    }

    private int find(int element) {
        if (roots[element] == element) {
            return element;
        }

        return roots[element] = find(roots[element]);
    }

    private void union(int element1, int element2) {
        int root1 = find(element1);
        int root2 = find(element2);

        if (root1 != root2) {
            roots[root1] = root2;
        }
    }
}
