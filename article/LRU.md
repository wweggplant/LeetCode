# LRU

LRU是一种缓存淘汰策略，它是按照最近使用过的放在队列的前面，如果缓存的容量满了，就删除最后的元素，也就是删除了一个使用次数最少的元素。这样就可以给新元素腾地方。

    这样做的原因是计算机的储存是有限的，那么就需要把『有用的元素』放在缓存里面，相对没有用的删除。LRU是按照最近使用时间排序整体元素，进而淘汰相对用的最少的元素的一种策略。还有其他缓存淘汰策略。

# 分析

既然是缓存，那么查询和插入操作的时间复杂度都要达到O(1)级别。从LRU的定义来看，『最近』等词语说明要求元素之间要有顺序。散列表的查询和插入都是O(1)，但是元素之前是没有顺序的；数组和链表是顺序的，数组的话限定的索引是整数，所以不予考虑了，链表插入和删除是O(1)，查询是O(n)。两者结合一下，就可以解决以上的问题。

还有一个问题，链表是使用什么样的链表呢？在这里，由于有删除操作，所以最好是使用双向链表。单向链表的话，需要快慢指针配合来进行删除操作。

先来构建基本的数据结构

```java
class Node {
    public int key, val;
    public Node next, prev;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
// 链表中存放的值是<key, value>节点
class DoubleList{
    // 在链表头部添加节点 x，时间 O(1)
    public void addFirst(Node x);

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node x);

    // 删除链表中最后一个节点，并返回该节点，时间 O(1)
    public Node removeLast();

    // 返回链表长度，时间 O(1)
    public int size();
}
class LRU {
    private int cap;
    private HashMap<Integer, Node> map;
    private DoubleList<Node> cache;
    public LRU(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList<>();
    }
    public Node get(key) {
        if (!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        put(key,val);
    }
    public void put(int key, int val) {
        Node n = new Node(val);
        if(map.containsKey(key)) {
            cache.remove(map.get(key).val);
        } else {
            // 容量满了, 删除链表最后一个数据, 清空对应map的值
            if (cap == cache.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
        }
        // 更新链表和map
        cache.addFirst(n);
        map.put(key, n);
    }
}

```

在上面的代码中，我们在双向链表节点里里存放的是`Node<Integer, Node>`节点。这是因为我们需要同时对map和链表进行更新，如果只知道值（int）的话，就没有办法对map直接进行查询和删除操作。