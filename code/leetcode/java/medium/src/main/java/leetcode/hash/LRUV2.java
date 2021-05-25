package leetcode.hash;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路: 维护一个 Map 用以查找, 维护一个双向链表用于顺序
 *
 * @author zack <br>
 * @create 2021-03-03 14:40 <br>
 * @project leetcode <br>
 */
@Slf4j
public class LRUV2<K, V> {

    Map<Integer, Node<Integer, Integer>> map;
    private int capacity;
    private DLinedList<Integer, Integer> linkedList;
    public LRUV2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.linkedList = new DLinedList<>();
    }

    public static void main(String[] args) {

        LRUV2<Integer, Integer> lru = new LRUV2<>(3);

        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);

        lru.get(2);
        //    lru.put(6, 6);
        log.info("keys: {}", lru.linkedList.head.next.v);
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node<Integer, Integer> node = map.get(key);
        linkedList.removeNode(node);
        linkedList.addHead(node);

        return node.v;
    }

    public void put(int k, int v) {

        if (map.containsKey(k)) {
            Node<Integer, Integer> node = map.get(k);
            node.v = v;
            linkedList.removeNode(node);
            linkedList.addHead(node);
        } else {
            if (map.size() == capacity) {
                Node<Integer, Integer> node = linkedList.last();
                map.remove(node.k);
                linkedList.removeNode(node);
            }

            Node<Integer, Integer> node = new Node<>(k, v);
            map.put(k, node);
            linkedList.addHead(node);
        }
    }

    // 创建 Node 作为数据载体
    class Node<K, V> {
        K k;
        V v;
        Node<K, V> pre = null;
        Node<K, V> next = null;

        public Node() {}

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    // 2.构建一个虚拟的双向链表: 里面放置Node
    class DLinedList<K, V> {

        // dummy node
        Node<K, V> tail = new Node<>();
        // dummy node
        Node<K, V> head = new Node<>();

        public DLinedList() {
            head.next = tail;
            tail.pre = head;
        }

        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        public void removeNode(Node<K, V> node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;

            node.pre = null;
            node.next = null;
        }

        public Node<K, V> last() {
            return tail.pre;
        }
    }
}
