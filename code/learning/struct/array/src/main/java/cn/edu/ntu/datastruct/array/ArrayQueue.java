package cn.edu.ntu.datastruct.array;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Use array to implement queue. <br>
 *
 * @author zack <br>
 * @create 2020-02-27 20:25 <br>
 */
public class ArrayQueue {
  private static final Logger LOG = LoggerFactory.getLogger(ArrayQueue.class);

  private int front = -1;
  private int rear = -1;
  private int array[];
  private int size;

  public ArrayQueue() {}

  public ArrayQueue(int[] array, int size) {
    this.array = array;
    this.size = size;
  }

  public ArrayQueue(int size) {
    this.size = size;
    this.array = new int[size];
  }

  public boolean isEmpty() {
    return this.front == this.rear;
  }

  public boolean isFull() {
    return this.size == (this.rear - this.front);
  }

  public int getHead() {
    return array[front + 1];
  }

  public int size() {
    return this.size;
  }

  public int get() {
    if (isEmpty()) {
      LOG.info("ArrayQueue is empty!");
      throw new RuntimeException();
    } else {
      return array[++front];
    }
  }

  public void add(int v) {
    if (isFull()) {
      LOG.info("ArrayQueue is full!");
    } else {
      array[++rear] = v;
    }
  }
}
