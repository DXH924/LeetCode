package problem.problem706;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    private List<HashNode> hashNodeList = new ArrayList<HashNode>();
    private int hashSize = 100;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hashSize = 100;
        hashNodeList = new ArrayList<>(hashSize);
        for (int i = 0; i < hashSize; i++) {
            HashNode hashNode = new HashNode();
            hashNode.key = i;
            hashNodeList.add(hashNode);
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        // 计算key值
        int hashKey = key % hashSize;
        HashNode node = hashNodeList.get(hashKey);
        // 判断对应的hash节点是否有链表
        if (node.valueList == null) { // 暂无链表，新建，并插入值
            node.valueList = new LinkNode();
            node.valueList.key = key;
            node.valueList.value = value;
        } else { // 已有链表，遍历链表，若已有key则更新value，若无则插入表尾
            LinkNode ln = node.valueList;
            LinkNode pre = ln;
            while (ln != null) {
                if (ln.key == key) {
                    ln.value = value;
                    return;
                }
                pre = ln;
                ln = ln.next;
            }
            pre.next = new LinkNode();
            pre.next.key = key;
            pre.next.value = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        // 计算key值
        int hashKey = key % hashSize;
        HashNode node = hashNodeList.get(hashKey);
        // 判断对应的hash节点是否有链表
        // 无链表，返回false
        if (node.valueList == null) {
            return -1;
        }
        // 有链表，遍历，遇到key返回true，否则返回false
        LinkNode ln = node.valueList;
        while (ln != null) {
            if (ln.key == key) {
                return ln.value;
            }
            ln = ln.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        // 计算key值
        int hashKey = key % hashSize;
        HashNode node = hashNodeList.get(hashKey);
        // 判断对应的hash节点是否有链表
        // 若无链表，返回
        if (node.valueList == null) {
            return;
        }
        // 有链表，寻找节点位置，用pre记录前驱节点
        LinkNode head = new LinkNode();
        head.next = node.valueList;
        LinkNode pre = head, current = pre.next;
        while (current != null) {
            if (current.key == key) {
                pre.next = pre.next.next;
                node.valueList = head.next;
                return;
            }
            pre = current;
            current = current.next;
        }
    }

    // 哈希节点
    class HashNode {
        int key;
        LinkNode valueList;
    }

    // 哈希节点内部链表
    class LinkNode {
        int key;
        int value;
        LinkNode next;
    }
}

class Test {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 45);
        hashMap.put(101, 46);
        hashMap.put(101, 9);
        hashMap.put(201, 1);
        hashMap.put(301, 6);
        hashMap.put(401, 7);
        hashMap.remove(1);
        System.out.println();
    }
}
