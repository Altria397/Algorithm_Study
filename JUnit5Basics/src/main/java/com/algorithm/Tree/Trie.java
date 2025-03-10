package com.algorithm.Tree;

/**
 * @program: Algorithm_Study
 * @description: 字典树
 * @author: Altria397
 * @create: 2024-02-19 09:27
 */
// TrieNode 节点类
class TrieNode {
    private final int ALPHABET_SIZE = 26; // 假设我们处理的是小写字母构成的字符串
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord;

    public TrieNode() {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            children[i] = null;
        }
        isEndOfWord = false;
    }
}

// Trie 类
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 插入一个单词到字典树中
    public void insert(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // 将字符转换为数组索引
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true; // 标记当前节点为单词结束节点
    }

    // 检查给定单词是否存在于字典树中
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode != null && currentNode.isEndOfWord;
    }

    // 判断字典树中是否存在以某个前缀开始的单词
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode != null;
    }
}
