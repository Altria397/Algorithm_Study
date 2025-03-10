package com.algorithm.LeetCode;

/*
   Description: 2296. 设计一个文本编辑器
   Author: 叁玖柒
   Date: 2025/2/27
   Time: 15:32
*/
public class TextEditor {
    private final StringBuilder text;
    private int cursor = 0;
    public TextEditor() {
        text = new StringBuilder();
        cursor = 0;
    }

    public void addText(String text) {
        this.text.insert(cursor, text);
        cursor += text.length();
    }

    public int deleteText(int k) {
        int charsToDelete = Math.min(k, cursor); // 最多删除 cursor 个字符
        if (charsToDelete > 0) {
            text.delete(cursor - charsToDelete, cursor);
            cursor -= charsToDelete;
        }
        return charsToDelete;
    }

    public String cursorLeft(int k) {
        cursor = Math.max(0, cursor - k); // 光标不能移到 0 左边
        int len = Math.min(10, cursor);   // 取光标左边最多 10 个字符
        return text.substring(Math.max(0, cursor - len), cursor);
    }

    public String cursorRight(int k) {
        cursor = Math.min(text.length(), cursor + k); // 光标不能超过文本长度
        int len = Math.min(10, cursor);               // 取光标左边最多 10 个字符
        return text.substring(Math.max(0, cursor - len), cursor);
    }
}
