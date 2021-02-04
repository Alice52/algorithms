## Outline Conclusion

### sparse array: **`new int [][3]`**

1. first line record row number, line number and valid element count
2. row number, line number, value
3. store: Nested Foreach

   - traversal chess array to get row number, line number and valid element count
   - if value is not invalid, record row number, line number and valid element count

4. purge: Foreach

   - traversal sparse array
   - int[i][0]: row number; int[i][1]: line number; int[i][2]: value.

### queue and circle queue

1. empty, full, count, get , pop, head, rear, list
2. circle queue: `Promoise front is first element, rear is the next of last element`

   - empty: front == rear
   - full: (rear + 1) % size == front
   - count: (rear + size - front) % size
   - pop: sparse[front]; front = (front + 1) % size
   - head: sparse[front]
   - rear: sparse[rear]
   - list: sparse[(i + front) % size]; i < count()

   ```java
   for (int i = front; i < front + this.count(); i++) {
       LOG.info(arr[i % this.size] + "");
   }
   ```
