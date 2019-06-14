## HyperLogLog

运用的场景：用于**记录访问量非常大（因为他需要占据12KB的存储空间）**的页面的访问次数

set（sadd和scard也可以，但是当数据量非常大的时候set太过消耗空间了）



```
127.0.0.1:6379> pfadd codehole user1
(integer) 1
127.0.0.1:6379> pfadd codehole user1
(integer) 0
127.0.0.1:6379> pfcount codehole
(integer) 1
127.0.0.1:6379> pfadd codehole user2
(integer) 1
127.0.0.1:6379> pfcount codehole
(integer) 2
```

**但是他并不是精确的去重计数的。标准误差是0.81%**



- **PFMERGE 合并两个计数**

```
127.0.0.1:6379> PFMERGE testpf2 testpf
OK
127.0.0.1:6379> PFCOUNT testpf2
(integer) 99
```



- **Redis 对 HyperLogLog 进行了一次优化**

  在计数比较小的时候，它的存储空间先才用稀疏矩阵（空间占用较小）

  在计数慢慢变大的时候，稀疏矩阵占用空间慢慢超过阈值的时候，才会一次性转变成稠密矩阵（才会占用12KB的空间）