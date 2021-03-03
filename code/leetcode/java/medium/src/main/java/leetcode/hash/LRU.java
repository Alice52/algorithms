package leetcode.hash;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zack <br>
 * @create 2021-03-03 14:40 <br>
 * @project leetcode <br>
 */
@Slf4j
public class LRU<K, V> extends LinkedHashMap<K, V> {

  private int initialCapacity;

  public LRU(int initialCapacity) {
    super(initialCapacity, 0.75f, true);
    this.initialCapacity = initialCapacity;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return super.size() > initialCapacity;
  }

  public static void main(String[] args) {

    LRU<Integer, Integer> lru = new LRU<Integer, Integer>(3);

    lru.put(1, 1);
    lru.put(2, 2);
    lru.put(3, 3);

    lru.get(2);
    lru.put(6, 6);
    log.info("keys: {}", lru.keySet());
  }
}
