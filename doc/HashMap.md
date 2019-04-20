### HashMap 相关知识
本文内容：
* 为什么HashMap申请内存空间都是2的倍数？
* HashMap是如何降低hash冲突的
* 冲突的解决方法
* HashMap序列化与反序列化<br/><br/><br/><br/>
#### 为什么HashMap申请内存空间都是2的倍数？
##### 1. 由操作系统决定，这样能够避免内存碎片的产生
##### 2. 计算机擅长的是移位操作，不擅长加减乘除（移位操作效率更高）
##### 3. 参加到Hash运算中，提高结果的散列度
###### 对于3提到的情况分析
###### 假设 n = 16 即 10000
###### 0000 1111 （用于HashMap的与运算）
###### 0000 0001  -\> 0000 0001
###### 0001 0000  -\> 0000 0000
###### 假设 n = 15 即 1111
###### 0000 1110  （可以看出hash冲突的可能性大大的提高了）
###### 0000 0001  -\> 0000 0000
###### 0001 0000  -\> 0000 0000<br/><br/><br/><br/>

#### HashMap是如何降低hash冲突的
```java
    // put 代码里面的 hash 计算
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
```
###### 异或（相同为0 不同为1）<br/><br/>
###### 例子 ：
###### 原值1 ：&nbsp;&nbsp;&nbsp;&nbsp;10010001 10010101 10110000 11110001
###### 右移16位：00000000 00000000 10010001 10010101
###### 异或后：&nbsp;&nbsp;&nbsp; 10010001 10010101 00100001 01100100<br/><br/>

###### 数组大小:  &nbsp;&nbsp;00000000 00000001 00000000 00000000
###### n - 1：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;00000000 00000000 11111111 11111111
###### 原值1与后：00000000 00000000 10110000 11110001
###### 异或后与： 00000000 00000000 00100001 01100100  &nbsp;（刚刚求得异或后和n-1与）<br/><br/>

###### 原值2 ：&nbsp;&nbsp;&nbsp;&nbsp;00010001 10010101 10110000 11110001
###### 右移16位：00000000 00000000 00010001 10010101
###### 异或后：&nbsp;&nbsp;&nbsp; 00010001 10010101 10100001 01100100<br/><br/>

###### 数组大小:  &nbsp;&nbsp;00000000 00000001 00000000 00000000
###### n - 1：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;00000000 00000000 11111111 11111111
###### 原值2与后：00000000 00000000 10110000 11110001
###### 异或后与： 00000000 00000000 10100001 01100100<br/>
##### 原值1和原值2 直接 和 n-1与 是相同的
##### 而原值1和原值2 经过和右移16位异或后 和 n-1与 是不同的
##### 可以发现，经过异或后，我们提高了hash值的散列度，已达到避免hash冲突的情况发生<br/><br/><br/><br/>

#### 冲突的解决方法
##### 对比链表的值并且插入或替换（或不替换\[由onlyIfAbsent这个参数决定\]）
##### 扩容或者树化
```java
    final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; Node<K,V> e;
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();
        else if ((e = tab[index = (n - 1) & hash]) != null) {
            TreeNode<K,V> hd = null, tl = null;
            do {
                TreeNode<K,V> p = replacementTreeNode(e, null);
                if (tl == null)
                    hd = p;
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null);
            if ((tab[index] = hd) != null)
                hd.treeify(tab);
        }
    }
```
```java
    // 大于阈值也要扩容 插入的代码
    if (++size > threshold)
                resize();
```
##### 对扩容代码的解析
```java
    /**
     * Initializes or doubles table size.  If null, allocates in
     * accord with initial capacity target held in field threshold.
     * Otherwise, because we are using power-of-two expansion, the
     * elements from each bin must either stay at same index, or move
     * with a power of two offset in the new table.
     *
     * @return the table
     */
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            // 是不是已经大于最大容量
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                // 扩容一倍
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {   
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        // 只有数据里面一个数据 没有链表 （只要处理数组即可）
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        // 对红黑树节点进行遍历拆分
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order 此处扩容会保持 原有的先后顺序
                        // 还在原来的数组位置
                        Node<K,V> loHead = null, loTail = null;
                        // 到了 原数组位置 + 扩容大小 的位置
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            // 为 0 即还在原位置
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            // 为 1 为在新位置
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        // 放到扩容后的数组中
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        // 返回扩容后的数组
        return newTab;
    }
```
<br/><br/><br/><br/>
#### HashMap序列化
```java
    private void writeObject(java.io.ObjectOutputStream s)
        throws IOException {
        // 初始数组的大小
        int buckets = capacity();
        // Write out the threshold, loadfactor, and any hidden stuff
        s.defaultWriteObject();
        s.writeInt(buckets);
        // size 节点的数量
        s.writeInt(size);
        internalWriteEntries(s);
    }
```
```java
    // Called only from writeObject, to ensure compatible ordering.
    void internalWriteEntries(java.io.ObjectOutputStream s) throws IOException {
        Node<K,V>[] tab;
        // 即遍历
        if (size > 0 && (tab = table) != null) {
            for (int i = 0; i < tab.length; ++i) {
                for (Node<K,V> e = tab[i]; e != null; e = e.next) {
                    // 不为空 序列化写入
                    s.writeObject(e.key);
                    s.writeObject(e.value);
                }
            }
        }
    }
```
#### HashMap反序列化
```java
    /**
     * Reconstitute the {@code HashMap} instance from a stream (i.e.,
     * deserialize it).
     */
    private void readObject(java.io.ObjectInputStream s)
        throws IOException, ClassNotFoundException {
        // Read in the threshold (ignored), loadfactor, and any hidden stuff
        s.defaultReadObject();
        reinitialize();
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new InvalidObjectException("Illegal load factor: " +
                                             loadFactor);
        s.readInt();                // Read and ignore number of buckets
        int mappings = s.readInt(); // Read number of mappings (size)
        if (mappings < 0)
            throw new InvalidObjectException("Illegal mappings count: " +
                                             mappings);
        else if (mappings > 0) { // (if zero, use defaults)
            // Size the table using given load factor only if within
            // range of 0.25...4.0
            float lf = Math.min(Math.max(0.25f, loadFactor), 4.0f);
            float fc = (float)mappings / lf + 1.0f;
            int cap = ((fc < DEFAULT_INITIAL_CAPACITY) ?
                       DEFAULT_INITIAL_CAPACITY :
                       (fc >= MAXIMUM_CAPACITY) ?
                       MAXIMUM_CAPACITY :
                       tableSizeFor((int)fc));
            float ft = (float)cap * lf;
            threshold = ((cap < MAXIMUM_CAPACITY && ft < MAXIMUM_CAPACITY) ?
                         (int)ft : Integer.MAX_VALUE);

            // Check Map.Entry[].class since it's the nearest public type to
            // what we're actually creating.
            SharedSecrets.getJavaOISAccess().checkArray(s, Map.Entry[].class, cap);
            @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] tab = (Node<K,V>[])new Node[cap];
            table = tab;

            // Read the keys and values, and put the mappings in the HashMap
            for (int i = 0; i < mappings; i++) {
                @SuppressWarnings("unchecked")
                    K key = (K) s.readObject();
                @SuppressWarnings("unchecked")
                    V value = (V) s.readObject();
                putVal(hash(key), key, value, false, false);
            }
        }
    }
```
#### 为什么要序列化和反序列化
##### 大家都知道HashMap存储是根据Key的hash值来计算出，键值对应该放在数组的哪个位置，
##### 但是在不同的JVM中，得到的hash值不一定相同，
##### 意思就是在windows下的虚拟机将key=‘1’计算出来的hash值可能是存在table的第0个位置的，
##### 但是在linux环境下的虚拟机计算出来的key=‘1’的hash值可能是放在table的第1个位置，
##### 当我们去读table中的值的时候未必能拿到key='1’的值。
