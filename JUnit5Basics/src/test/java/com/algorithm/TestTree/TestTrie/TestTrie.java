package com.algorithm.TestTree.TestTrie;

import com.algorithm.Tree.Trie;

/**
 * @program: Algorithm_Study
 * @description: 测试字典树
 * @author: Altria397
 * @create: 2024-02-19 09:30
 */

public class TestTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");

        System.out.println(trie.search("apple")); // 输出: true
        System.out.println(trie.startsWith("app")); // 输出: true
        System.out.println(trie.search("applications")); // 输出: false
    }
}
