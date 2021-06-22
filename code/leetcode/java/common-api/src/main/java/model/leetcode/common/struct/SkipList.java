package model.leetcode.common.struct;

import lombok.NoArgsConstructor;

import java.util.Random;

/**
 * @author zack <br>
 * @create 2021-06-12<br>
 * @project leetcode <br>
 */
public class SkipList {

    private static final byte HEAD_NODE = (byte) -1;
    private static final byte DATA_NODE = (byte) 0;
    private static final byte TAIL_NODE = (byte) 1;

    private Node head;
    private Node tail;
    private int size;
    private int height;
    private Random random;

    public SkipList() {
        this.head = new Node(null, HEAD_NODE);
        this.tail = new Node(null, TAIL_NODE);

        this.head.right = this.tail;
        this.head.left = this.head;
        this.random = new Random(System.currentTimeMillis());
    }

    /**
     * 这个方法非常重要: 得到的是值的节点或者介于其中的左边Node
     *
     * @param element
     * @return
     */
    private Node find(Integer element) {
        Node current = head;
        for (; ; ) {
            while (current.right.type != TAIL_NODE && current.right.value <= element) {
                current = current.right;
            }

            if (current.down != null) {

                current = current.down;
            } else {
                break;
            }
        }

        // current < the element < current.right (if exist)
        return current;
    }

    public boolean contains(Integer element) {
        Node node = find(element);
        return node.value.equals(element);
    }

    public Integer get(Integer element) {
        Node node = find(element);
        return node.value.equals(element) ? node.value : null;
    }

    public void add(Integer element) {
        Node closestNode = find(element);
        Node newNode = new Node(element);

        newNode.left = closestNode;
        newNode.right = closestNode.right;
        closestNode.right.left = newNode;
        closestNode.right = newNode;

        int currentLevel = 0;
        // add height
        while (random.nextDouble() > 0.5d) {

            // add new layer
            if (currentLevel >= height) {
                height++;
                Node dummyHead = new Node(null, HEAD_NODE);
                Node dummyTail = new Node(null, TAIL_NODE);

                dummyHead.right = dummyTail;
                dummyHead.down = head;
                head.up = dummyHead;

                dummyTail.right = dummyHead;
                dummyTail.down = tail;
                tail.up = dummyHead;

                head = dummyHead;
                tail = dummyHead;
            }

            // 找up节点的left
            while (closestNode != null && closestNode.up == null) {
                closestNode = closestNode.left;
            }
            closestNode = closestNode.up;

            Node upNode = new Node(element);

            upNode.left = closestNode;
            upNode.right = closestNode.right;
            upNode.down = newNode;
            closestNode.right.left = upNode;
            closestNode.right = upNode;

            newNode.up = closestNode;
            currentLevel++;
            newNode = upNode;
        }

        size++;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return this.size;
    }

    @NoArgsConstructor
    private static class Node {
        private Integer value;
        private Node left, right, up, down;
        private byte type;

        public Node(Integer value, byte type) {
            this.value = value;
            this.type = type;
        }

        public Node(Integer value) {
            this(value, DATA_NODE);
        }
    }
}
