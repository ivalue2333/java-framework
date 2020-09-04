package com.iota.core.algorithm.leetcode;

import java.util.Stack;

/*

要求一、要去重。
要求二、去重字符串中的字符顺序不能打乱s中字符出现的相对顺序。
要求三、在所有符合上一条要求的去重字符串中，字典序最小的作为最终结果。


https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247486946&idx=1&sn=94804eb15be33428582544a1cd90da4d&chksm=9bd7f3eaaca07afc6fdfa94d05fa3007d9ecc54914a238e6deabeafd5032a299155505b40f2d&scene=126&sessionid=1599186895&key=694ad12351d974dc2513fbb06813d558a28d85dd399110acf537d9093a33023e4a45042e9a6d38338e8e81af2dfacc282fe6e58a2dfe40d4749135aece5fc7aec437b1571e305ec25620f99fd31d9464ad0845ed6d385dd6954a53bc7bd8033e54429c50da33d2bef36bff3b4350f1dda9be09e8d52cb3812f1e423b2868d578&ascene=1&uin=MjQ3MzQ1MDUyNQ%3D%3D&devicetype=Windows+10+x64&version=62090529&lang=zh_CN&exportkey=A9acH58xhNx7E9ggLClql9o%3D&pass_ticket=W37LZJj35wtgefD7LjgGM9gP1KY0TU1%2B6M4x0gG1h%2BHc5beiytDTWprI7S%2BS4dUf&wx_header=0

 */

public class RemoveDuplicateLetters {
    String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();

        // 维护一个计数器记录字符串中字符的数量
        // 因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            // 每遍历过一个字符，都将对应的计数减一
            count[c]--;

            if (inStack[c]) continue;

            while (!stk.isEmpty() && stk.peek() > c) {
                // 若之后不存在栈顶元素了，则停止 pop
                if (count[stk.peek()] == 0) {
                    break;
                }
                // 若之后还有，则可以 pop
                inStack[stk.pop()] = false;
            }
            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();

        String input = "bcabc";
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(input).equals("abc"));
        input = "abcdefabcdef";
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(input).equals("abcdef"));
        input = "bcac";
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(input).equals("bac"));
    }
}
