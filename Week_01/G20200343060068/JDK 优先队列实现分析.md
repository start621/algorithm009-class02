### JDK 1.8 Queue和PriorityQueue源码分析
只看了部分源码，关于二叉堆的细节，待继续分析
#### Queue
Queue在JDK中定义为接口，直接继承于Collection接口。Queue根据FIFO的特性，
定义了相关函数，具体函数参考下节


##### 关键函数

```java
public interface Queue<E> extends Collection<E> {

    // 入队操作，如果容量不足返回IllegalStateException
    boolean add(E e);

    // 入队操作，如果容量不足返回false
    boolean offer(E e);

    // 出队操作，如果元素不存在返回NoSuchElementException
    E remove();

    // 出队操作，如果元素不存在返回null
    E poll();

    // 获取对首元素，如果元素不存在返回NoSuchElementException
    E element();
    
    // 获取对首元素，如果元素不存在返回null
    E peek();
}

```

##### 队列实现


##### 总结

#### PriorityQueue
PriorityQueue虽然是一种队列，但是，优先队列每次出队的元素都是优先级最高的元素。jdk使用堆使得每次出队的元素总是队列里面最小的，元素的大小比较方法可以由用户指定，因此，相当于指定优先级。

#####关键参数
```java
// 默认初始化大小
private static final int DEFAULT_INITIAL_CAPACITY = 11;

// 用数组实现的二叉堆 
/**
 * Priority queue represented as a balanced **binary heap**: the two
 * children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
 * priority queue is ordered by comparator, or by the elements'
 * natural ordering, if comparator is null: For each node n in the
 * heap and each descendant d of n, n <= d.  The element with the
 * lowest value is in queue[0], assuming the queue is nonempty.
 */
private transient Object[] queue;
// 队列的元素数量 
private int size = 0;
// 比较器,用于指定优先级
private final Comparator<? super E> comparator;
// 修改次数
private transient int modCount = 0;
```
##### 构造函数

```java
/**
 * 默认构造方法，使用默认的初始大小来构造一个优先队列，比较器comparator为空，这里要求入队的元素必须实现Comparator接口
 */
public PriorityQueue() {
    this(DEFAULT_INITIAL_CAPACITY, null);
}

/**
 * 使用指定的初始大小来构造一个优先队列，比较器comparator为空，这里要求入队的元素必须实现Comparator接口
 */
public PriorityQueue( int initialCapacity) {
    this(initialCapacity, null);
}

/**
 * 使用指定的初始大小和比较器来构造一个优先队列
 */
public PriorityQueue( int initialCapacity,
                     Comparator<? super E> comparator) {
    // Note: This restriction of at least one is not actually needed,
    // but continues for 1.5 compatibility
    // 初始大小不允许小于1
    if (initialCapacity < 1)
        throw new IllegalArgumentException();
    // 使用指定初始大小创建数组
    this.queue = new Object[initialCapacity];
    // 初始化比较器
    this.comparator = comparator;
}

/**
 * 构造一个指定Collection集合参数的优先队列
 */
public PriorityQueue(Collection<? extends E> c) {
    // 从集合c中初始化数据到队列
    initFromCollection(c);
    // 如果集合c是包含比较器Comparator的(SortedSet/PriorityQueue)，则使用集合c的比较器来初始化队列的Comparator
    if (c instanceof SortedSet)
        comparator = (Comparator<? super E>)
            ((SortedSet<? extends E>)c).comparator();
    else if (c instanceof PriorityQueue)
        comparator = (Comparator<? super E>)
            ((PriorityQueue<? extends E>)c).comparator();
    //  如果集合c没有包含比较器，则默认比较器Comparator为空
    else {
        comparator = null;
        // 调用heapify方法重新将数据调整为一个二叉堆
        heapify();
    }
}

/**
 * 构造一个指定PriorityQueue参数的优先队列
 */
public PriorityQueue(PriorityQueue<? extends E> c) {
    comparator = (Comparator<? super E>)c.comparator();
    initFromCollection(c);
}

/**
 * 构造一个指定SortedSet参数的优先队列
 */
public PriorityQueue(SortedSet<? extends E> c) {
    comparator = (Comparator<? super E>)c.comparator();
    initFromCollection(c);
}

/**
 * 从集合中初始化数据到队列
 */
private void initFromCollection(Collection<? extends E> c) {
    // 将集合Collection转换为数组a
    Object[] a = c.toArray();
    // If c.toArray incorrectly doesn't return Object[], copy it.
    // 如果转换后的数组a类型不是Object数组，则转换为Object数组
    if (a.getClass() != Object[].class)
        a = Arrays. copyOf(a, a.length, Object[]. class);
    // 将数组a赋值给队列的底层数组queue
    queue = a;
    // 将队列的元素个数设置为数组a的长度
    size = a.length ;
}
```

##### 关键函数

###### 入队
```java
public boolean offer(E e){
    if(e == null){
        throw new NullPointerException();
    }
    modCount++;
    int i = size;
    if(i >= queue.length){
        grow(i+1);
    }
    size = i+1;
    if(i == 0){
        queue[0] = e;
    } else {
        **siftUp(i,e);** //判断优先级的核心
    }
    return true;
}
```
###### 扩容
```java
private void grow(int minCapacity) {
    // 如果最小需要的容量大小minCapacity小于0，则说明此时已经超出int的范围，则抛出OutOfMemoryError异常
    if (minCapacity < 0) // overflow
        throw new OutOfMemoryError();
    // 记录当前队列的长度
    int oldCapacity = queue .length;
    // Double size if small; else grow by 50%
    // 如果当前队列长度小于64则扩容2倍，否则扩容1.5倍
    int newCapacity = ((oldCapacity < 64)?
                       ((oldCapacity + 1) * 2):
                       ((oldCapacity / 2) * 3));
    // 如果扩容后newCapacity超出int的范围，则将newCapacity赋值为Integer.Max_VALUE
    if (newCapacity < 0) // overflow
        newCapacity = Integer. MAX_VALUE;
    // 如果扩容后，newCapacity小于最小需要的容量大小minCapacity，则按找minCapacity长度进行扩容
    if (newCapacity < minCapacity)
        newCapacity = minCapacity;
    // 数组copy，进行扩容
    queue = Arrays.copyOf(queue, newCapacity);
}
```
###### 出队
```java
public E poll() {
    // 队列为空，返回null
    if (size == 0)
        return null;
    // 队列元素个数-1
    int s = --size ;
    // 修改版本+1
    modCount++;
    // 队头的元素
    E result = (E) queue[0];
    // 队尾的元素
    E x = (E) queue[s];
    // 先将队尾赋值为null
    queue[s] = null;
    // 如果队列中不止队尾一个元素，则调用siftDown方法进行"下移"操作
    if (s != 0)
        **siftDown(0, x);** //判断优先级的核心
    return result;
}

```
##### 总结
