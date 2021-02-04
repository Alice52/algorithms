package cn.edu.ntu.datastruct.array;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-02-27 20:41 <br>
 */
public class ArrayQueueTest {
  private static final Logger LOG = LoggerFactory.getLogger(ArrayQueueTest.class);

  @Test
  public void testArrayQueue() {
    ArrayQueue arrayQueue = new ArrayQueue(3);
    arrayQueue.add(12);
    LOG.info(arrayQueue.get() + "");
    arrayQueue.add(22);
    arrayQueue.add(32);
  }
}
