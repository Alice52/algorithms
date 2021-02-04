package cn.edu.ntu.linkedlist;

import common.models.HeroNode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;

/**
 * @author zack <br>
 * @create 2020-03-06 21:51 <br>
 */
public class SingleLinkedList {
  private static final Logger LOG = LoggerFactory.getLogger(SingleLinkedList.class);

  private HeroNode head = new HeroNode(0, StringUtils.EMPTY, StringUtils.EMPTY);

  /**
   * Concat two ordered linked list, and still ordered. <br>
   * Select one of them as based list, extract the elements of another linked list, and insert them
   * in turn. <br>
   * <br>
   * Notice: two linked list next node and serial of both list. <br>
   * Disadvantage: this will change source linked list, do not recommend. <br>
   *
   * @param head1 Linked List
   * @param head2 Linked List
   */
  @Deprecated
  public static void concat(HeroNode head1, HeroNode head2) {

    HeroNode current1 = head1.next;
    HeroNode next1;

    // base list, head1 element will insert into this list.
    HeroNode temp = head2;

    while (current1 != null) {
      next1 = current1.next;

      // insert into base list
      while (temp.next != null) {
        if (current1.no > temp.next.no) {
          temp = temp.next;
        } else {
          break;
        }
      }

      current1.next = temp.next;
      temp.next = current1;

      current1 = next1;
    }
  }

  /**
   * Extract two linked list node and store in deque, then create new linked list; <br>
   * Get node from deque and insert into new linked list in turn. <br>
   *
   * @param head1 Linked List
   * @param head2 Linked List
   * @return List<HeroNode> combine result
   */
  public static SingleLinkedList concat2(HeroNode head1, HeroNode head2) {

    HeroNode newHead = new HeroNode();

    ArrayDeque<HeroNode> queue = new ArrayDeque<>();

    HeroNode temp1 = head1;
    HeroNode temp2 = head2;

    while (temp1.next != null) {
      temp1 = temp1.next;
      queue.addFirst(temp1);
    }

    while (temp2.next != null) {
      temp2 = temp2.next;
      queue.addFirst(temp2);
    }

    SingleLinkedList orderedLinkedList = new SingleLinkedList();

    queue.stream().forEach(x -> orderedLinkedList.addOrdine(x));

    return orderedLinkedList;
  }

  /**
   * add hero node to linked list as operation order, need find rear element. <br>
   *
   * @param heroNode
   */
  public void add(HeroNode heroNode) {
    // 1. find last element
    HeroNode temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }

    temp.next = heroNode;
  }

  /**
   * This method is add element by specify order, need find the front node of removed element. <br>
   *
   * @param heroNode
   */
  public void addOrdine(HeroNode heroNode) {
    // get temp location by foreach
    HeroNode temp = head;
    while (temp.next != null) {
      if (temp.next.no < heroNode.no) {
        temp = temp.next;
      } else {
        break;
      }
    }

    heroNode.next = temp.next;
    temp.next = heroNode;
  }

  /**
   * This method is add element by specify order. <br>
   *
   * @param heroNode
   */
  public void addOrdine2(HeroNode heroNode) {
    // get temp location by foreach
    boolean flag = false;
    HeroNode temp = head;
    while (temp.next != null) {
      if (temp.next.no > heroNode.no) {
        break;
      } else if (temp.next.equals(heroNode)) {
        flag = true;
        LOG.info("this hero: {} is in linked list, cannot add again.", heroNode);
      }
      temp = temp.next;
    }

    if (!flag) {
      heroNode.next = temp.next;
      temp.next = heroNode;
    }
  }

  /**
   * update hero info according to no.
   *
   * @param heroNode
   */
  public void update(HeroNode heroNode) {
    HeroNode temp = head;
    boolean flag = false;

    while (temp.next != null) {
      temp = temp.next;
      if (temp.no == heroNode.no) {
        temp.name = heroNode.name;
        temp.nickName = heroNode.nickName;
        flag = true;
        break;
      }
    }

    if (flag == false) {
      LOG.info("Cannot find {}.", heroNode);
    }
  }

  /**
   * Delete specify Node, need find the front node of removed element. <br>
   * Then recommend GC this node.<br>
   *
   * @param no delete element no
   * @return boolean whether delete success
   */
  public boolean delete(int no) {
    HeroNode temp = head;
    boolean flag = false;

    while (temp.next != null) {
      if (temp.next.no == no) {
        temp.next = temp.next.next;
        flag = true;
        break;
      }
      temp = temp.next;
    }

    return flag;
  }

  /**
   * Get the count of node in linked list. <br>
   *
   * @return the number of node in linked list
   */
  public int count() {
    HeroNode temp = head;
    int count = 0;

    while (temp.next != null) {
      temp = temp.next;
      count++;
    }

    return count;
  }

  /** show all element in linked list. <br> */
  public void list() {
    HeroNode temp = head;
    if (temp.next == null) {
      LOG.info("Linked List is null!");
    }
    while (temp.next != null) {
      LOG.info("Hero Info: {}", temp);
      temp = temp.next;
    }
    LOG.info("Hero Info: {}", temp);
  }

  /** show all node by desc order. */
  public void listReverse() {

    ArrayDeque<HeroNode> queue = new ArrayDeque<>();
    HeroNode temp = head;

    while (temp.next != null) {
      temp = temp.next;
      queue.addFirst(temp);
    }

    queue.stream().forEach(x -> LOG.info(x + ""));
  }

  /**
   * Get the value of the k-th last element. <br>
   * Get the total number of elements and subtract k, to get the positive element position. <br>
   *
   * @param k k-th last
   * @return
   */
  public HeroNode getLastKthNode(int k) {

    // get count, the get (count - k) asc
    int order = count() - k + 1;

    if (order <= 0) {
      LOG.info("Cannot get k element due to linked list does not have k elements.");
      return null;
    }

    HeroNode temp = head;
    while (order > 0) {
      temp = temp.next;
      order--;
    }

    return temp;
  }

  /**
   * Reverse node, create new linked list, add to front of new list one by one, which get from old
   * linked list. <br>
   * Make current alone, and should maintain next and followed node. <br>
   */
  public void reverse() {
    // point to old list
    // point to next node in old list
    HeroNode current = head;
    HeroNode next = current.next;
    HeroNode newHead = new HeroNode();

    while (next != null) {
      current = next;
      next = current.next;

      current.next = newHead.next;
      newHead.next = current;
    }

    head.next = newHead.next;
    newHead = null;
  }

  public void reverse2() {
    HeroNode current = head.next;
    HeroNode next = null;
    HeroNode newHead = new HeroNode();

    while (current != null) {
      next = current.next;

      current.next = newHead.next;
      newHead.next = current;

      current = next;
    }

    head.next = newHead.next;
  }

  /**
   * Get linked list head node. <br>
   *
   * @return
   */
  public HeroNode getHead() {
    return head;
  }
}
