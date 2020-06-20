package com.adrian.leetcode.myalgo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xl48886
 * @version Id: LRUCache, v 0.1 2020/6/19 2:22 下午 xl48886 Exp $
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int maxSize;

    public LRUCache(int maxSize) {
        super(maxSize * 4 / 3, 0.75F, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return (this.size() > maxSize);
    }


    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<>(5);
        lruCache.put("1", 1);
        lruCache.put("2", 2);
        lruCache.put("3", 3);
        lruCache.put("4", 4);
        lruCache.put("5", 5);
        lruCache.put("6", 6);

        Integer value1 = lruCache.get("1");
        Integer value2 = lruCache.get("2");
        System.out.println(value1);
        System.out.println(value2);
        lruCache.put("7", 7);
        System.out.println(value2);
        Integer value3 = lruCache.get("3");
        System.out.println(value3);
    }
}
