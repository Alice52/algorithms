package cn.edu.ntu.linkedlist;

import common.models.HeroNode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-03-06 22:55 <br>
 */
public class SingleLinkedListTest {

  private static final Logger LOG = LoggerFactory.getLogger(SingleLinkedListTest.class);

  @Test
  public void testAddByOrder() {
    HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
    HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
    HeroNode hero31 = new HeroNode(3, "吴用", "智多星");
    HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

    SingleLinkedList orderedLinkedList = new SingleLinkedList();
    orderedLinkedList.addOrdine2(hero4);
    orderedLinkedList.addOrdine2(hero3);
    orderedLinkedList.addOrdine2(hero1);
    orderedLinkedList.addOrdine2(hero1);
    orderedLinkedList.addOrdine2(hero2);
    orderedLinkedList.addOrdine2(hero31);

    orderedLinkedList.list();
  }

  @Test
  public void testAdd() {
    HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
    HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
    HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

    SingleLinkedList singleLinkedList = new SingleLinkedList();
    singleLinkedList.add(hero4);
    singleLinkedList.add(hero1);
    singleLinkedList.add(hero3);
    singleLinkedList.add(hero2);
    singleLinkedList.list();
  }

  @Test
  public void testUpdate() {
    HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
    HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
    HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

    SingleLinkedList singleLinkedList = new SingleLinkedList();
    singleLinkedList.add(hero4);
    singleLinkedList.add(hero1);
    singleLinkedList.add(hero3);
    singleLinkedList.add(hero2);
    singleLinkedList.update(new HeroNode(2, "卢俊义", "玉麒麟sa"));
    singleLinkedList.list();
  }

  @Test
  public void testUpdate2() {

    HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
    HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
    HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

    SingleLinkedList singleLinkedList = new SingleLinkedList();
    singleLinkedList.addOrdine(hero4);
    singleLinkedList.addOrdine2(hero1);
    singleLinkedList.addOrdine2(hero3);
    singleLinkedList.addOrdine2(hero2);

    singleLinkedList.update(new HeroNode(2, "卢俊义", "玉麒麟sa"));

    singleLinkedList.list();
  }

  @Test
  public void testDelete() {
    HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
    HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
    HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

    SingleLinkedList singleLinkedList = new SingleLinkedList();
    LOG.info(singleLinkedList.count() + "");
    singleLinkedList.addOrdine2(hero4);
    singleLinkedList.addOrdine2(hero1);
    singleLinkedList.addOrdine2(hero3);
    singleLinkedList.addOrdine2(hero2);
    LOG.info(singleLinkedList.count() + "");

    LOG.info(singleLinkedList.delete(1) + "");
    LOG.info(singleLinkedList.delete(10) + "");

    LOG.info(singleLinkedList.count() + "");

    singleLinkedList.list();
  }

  @Test
  public void testGetLastKthNode() {

    HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
    HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
    HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

    SingleLinkedList singleLinkedList = new SingleLinkedList();
    singleLinkedList.addOrdine2(hero4);
    singleLinkedList.addOrdine2(hero1);
    singleLinkedList.addOrdine2(hero3);
    singleLinkedList.addOrdine2(hero2);

    HeroNode result = singleLinkedList.getLastKthNode(5);
    LOG.info(result + "");
  }

  @Test
  public void testReserve() {
    HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
    HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
    HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

    SingleLinkedList singleLinkedList = new SingleLinkedList();
    singleLinkedList.addOrdine2(hero4);
    singleLinkedList.addOrdine2(hero1);
    singleLinkedList.addOrdine2(hero3);
    singleLinkedList.addOrdine2(hero2);
    singleLinkedList.list();

    singleLinkedList.reverse();
    singleLinkedList.list();

    singleLinkedList.reverse2();
    singleLinkedList.list();
  }

  @Test
  public void testListReverse() {

    HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
    HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
    HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

    SingleLinkedList singleLinkedList = new SingleLinkedList();
    singleLinkedList.addOrdine2(hero4);
    singleLinkedList.addOrdine2(hero1);
    singleLinkedList.addOrdine2(hero3);
    singleLinkedList.addOrdine2(hero2);
    singleLinkedList.list();

    singleLinkedList.listReverse();
  }

  @Test
  public void testConcat() {

    HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
    HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
    HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

    SingleLinkedList singleLinkedList = new SingleLinkedList();
    singleLinkedList.addOrdine2(hero1);
    singleLinkedList.addOrdine2(hero4);

    SingleLinkedList singleLinkedList2 = new SingleLinkedList();
    singleLinkedList2.addOrdine2(hero2);
    singleLinkedList2.addOrdine2(hero3);

    SingleLinkedList.concat(singleLinkedList2.getHead(), singleLinkedList.getHead());

    singleLinkedList.list();
  }

  @Test
  public void testConcat2() {

    HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
    HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
    HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

    SingleLinkedList singleLinkedList = new SingleLinkedList();
    singleLinkedList.addOrdine2(hero1);
    singleLinkedList.addOrdine2(hero4);

    SingleLinkedList singleLinkedList2 = new SingleLinkedList();
    singleLinkedList2.addOrdine2(hero2);
    singleLinkedList2.addOrdine2(hero3);

    SingleLinkedList list =
        SingleLinkedList.concat2(singleLinkedList2.getHead(), singleLinkedList.getHead());
    list.list();
    singleLinkedList.list();
    singleLinkedList2.list();

    // this will also show all node, because HeroNode is relative.
    // hero2 .next will be hero3, cannot be avoid unless.
    SingleLinkedList singleLinkedList3 = new SingleLinkedList();
    singleLinkedList3.add(hero1);
    singleLinkedList3.list();
  }
}
