package cn.edu.ntu.datastruct.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-03-03 23:31 <br>
 */
public class CircleArrayQueue {
  private static final Logger LOG = LoggerFactory.getLogger(CircleArrayQueue.class);

  /** the queue size */
  private int size;
  /** front is address of first element */
  private int front = 0;
  /** rear is next element of last element */
  private int rear = 0;
  /** the real array to implement queue */
  private int[] arr;

  public CircleArrayQueue(int size) {
    this.size = size;
    this.arr = new int[size];
  }

  /**
   * this is not real full, will reserve one address to Promise.
   *
   * @return boolean isFull
   */
  public boolean isFull() {
    return (this.rear + 1) % this.size == this.front;
  }

  public boolean isEmpty() {
    return this.rear == this.front;
  }

  public int count() {
    return (rear + this.size - this.front) % this.size;
  }

  public void addQueue(int n) {
    // judge no full, so cannot add element
    if (this.isFull()) {
      LOG.info("This queue is full, cannot add element: {}", n);
      return;
    } else {
      this.arr[rear] = n;
      this.rear = (this.rear + 1) % this.size;
    }
  }

  public int getQueue() {
    // judge is empty, otherwise cannot get from queue
    if (this.isEmpty()) {
      LOG.info("This queue is empty, cannot get element");
      throw new RuntimeException("Queue is empty");
    } else {
      int firstElement = this.arr[this.front];
      this.front = (this.front + 1) % this.size;
      return firstElement;
    }
  }

  public void showQueue() {
    if (this.isEmpty()) {
      LOG.info("Queue is empty!");
    } else {
      for (int i = front; i < front + this.count(); i++) {
        LOG.info(arr[i % this.size] + "");
      }
    }
  }

  public int headQueue() {
    if (this.isEmpty()) {
      LOG.info("Queue is empty, so no head element!");
    }
    return this.arr[this.front];
  }
}
