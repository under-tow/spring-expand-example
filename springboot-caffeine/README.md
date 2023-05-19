
- caffeine支持W-TinyLRU缓存淘汰策略
- 官网文档 https://github.com/ben-manes/caffeine/wiki/Population-zh-CN
- 项目地址 https://github.com/ben-manes/caffeine

缓存和ConcurrentMap有点相似，但还是有所区别。最根本的区别是ConcurrentMap将会持有所有加入到缓存当中的元素，直到它们被从缓存当中手动移除。但是，Caffeine的缓存Cache 通常会被配置成自动驱逐缓存中元素，以限制其内存占用。在某些场景下，LoadingCache和AsyncLoadingCache 因为其自动加载缓存的能力将会变得非常实用。