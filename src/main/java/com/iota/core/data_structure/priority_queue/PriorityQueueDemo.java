package com.iota.core.data_structure.priority_queue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(5);
        pq.add(2);
        pq.add(1);
        pq.add(10);
        pq.add(3);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll() + ", ");
        }
        System.out.println();
        System.out.println("————————————————————————");

        // 使用Lambda表达式传入自己的比较器转换成最大堆
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);
        pq2.add(5);
        pq2.add(2);
        pq2.add(1);
        pq2.add(10);
        pq2.add(3);

        while (!pq2.isEmpty()) {
            System.out.println(pq2.poll() + ", ");
        }
    }
}
