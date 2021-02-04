package cn.edu.ntu.datastruct.array;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @author zack <br>
 * @create 2020-03-04 00:04 <br>
 */
public class CircleArrayQueueTest {
  private static final Logger LOG = LoggerFactory.getLogger(CircleArrayQueueTest.class);

  /** This size is 5, but will reserve one to marked; So, real used space is 4. */
  private CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);

  public static void main(String[] args) {
    LOG.info("Test For Circle queue implemented by array:");
    // create circle queue, and set size: in this place 4 is size ,
    // but real used size is 3 due to one space will be used to mark
    CircleArrayQueue queue = new CircleArrayQueue(4);
    char key = ' ';
    Scanner scanner = new Scanner(System.in);
    boolean loop = true;
    while (loop) {
      LOG.info("s(show): show queue");
      LOG.info("e(exit): exit program");
      LOG.info("a(add): add element to queue");
      LOG.info("g(get): get element from queue");
      LOG.info("h(head): look up head element");
      LOG.info("Please enter your choice: ");
      key = scanner.next().charAt(0);
      switch (key) {
        case 's':
          queue.showQueue();
          break;
        case 'a':
          LOG.info("Please enter one number: ");
          int value = scanner.nextInt();
          queue.addQueue(value);
          break;
        case 'g':
          int popElement = queue.getQueue();
          LOG.info("pop from queue element: {}", popElement);
          break;
        case 'h':
          int headElement = queue.headQueue();
          LOG.info("head element: {}", headElement);
          break;
        case 'e':
          scanner.close();
          loop = false;
          break;
        default:
          break;
      }
    }
    LOG.info("Program exiting···");
  }

  @Test
  public void testAdd() {
    circleArrayQueue.addQueue(12);
    circleArrayQueue.addQueue(12);
    circleArrayQueue.addQueue(12);
    circleArrayQueue.addQueue(12);
    // so, this will full
    circleArrayQueue.addQueue(12);
  }
}
