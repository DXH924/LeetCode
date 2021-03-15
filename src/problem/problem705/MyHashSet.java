package problem.problem705;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang chhi
 * @Title:
 * @Package:
 * @Description: 不使用任何内建的哈希表库设计一个哈希集合（HashSet）
 * @date 2021-03-13 09:49
 */
public class MyHashSet {
    List<HashNode> hashNodeList;
    int hashSize;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSize = 100;
        hashNodeList = new ArrayList<>(hashSize);
        for (int i = 0; i < hashSize; i++) {
            HashNode hashNode = new HashNode();
            hashNode.key = i;
            hashNodeList.add(hashNode);
        }
    }

    /**
     * 向哈希集合中插入值 key
     * @param key
     */

    public void add(int key) {
        // 计算key值
        int hashKey = key % hashSize;
        HashNode node = hashNodeList.get(hashKey);
        // 判断对应的hash节点是否有链表
        if (node.valueList == null) { // 暂无链表，新建，并插入值
            node.valueList = new LinkNode();
            node.valueList.value = key;
        } else { // 已有链表，遍历链表，若已有key则返回，若无则插入表尾
            LinkNode ln = node.valueList;
            LinkNode pre = ln;
            while (ln != null) {
                if (ln.value == key) {
                    return;
                }
                pre = ln;
                ln = ln.next;
            }
            pre.next = new LinkNode();
            pre.next.value = key;
        }
    }

    /**
     * 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做
     * @param key
     */
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
            if (current.value == key) { // 移除节点
                pre.next = pre.next.next;
                node.valueList = head.next;
                return;
            }
            pre = current;
            current = current.next;
        }
    }

    /**
     * 返回哈希集合中是否存在这个值 key
     */
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        // 计算key值
        int hashKey = key % hashSize;
        HashNode node = hashNodeList.get(hashKey);
        // 判断对应的hash节点是否有链表
        // 无链表，返回false
        if (node.valueList == null) {
            return false;
        }
        // 有链表，遍历，遇到key返回true，否则返回false
        LinkNode ln = node.valueList;
        while (ln != null) {
            if (ln.value == key) {
                return true;
            }
            ln = ln.next;
        }
        return false;
    }

    // 哈希节点
    class HashNode {
        int key;
        LinkNode valueList;
    }

    // 哈希节点内部链表
    class LinkNode {
        int value;
        LinkNode next;
    }
}



class Test {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        for (int i = 5; i < 1000; i+= 100) {
            myHashSet.add(i);
        }
        myHashSet.remove(905);
        System.out.println(myHashSet.contains(1005));
    }
}
