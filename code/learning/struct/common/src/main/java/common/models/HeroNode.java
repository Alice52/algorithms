package common.models;

/**
 * @author zack <br>
 * @create 2020-03-06 21:47 <br>
 */
public class HeroNode {

  public int no;
  public String name;
  public String nickName;
  public HeroNode next;

  public HeroNode() {}

  public HeroNode(int no, String name, String nickName) {
    this.no = no;
    this.name = name;
    this.nickName = nickName;
  }

  @Override
  public String toString() {
    return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + ", nickName='" + nickName + '}';
  }
}
