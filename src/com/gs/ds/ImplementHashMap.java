package com.gs.ds;

import com.gs.util.EntryNode;

import java.util.LinkedList;
import java.util.List;


public class ImplementHashMap<K, V> {
    private int cacheSize = 16;
    List<EntryNode>[] cache = new LinkedList[cacheSize];
    private int size = 0;
    private int threshold = cacheSize * 10;
    public ImplementHashMap() {
    }

    private void initializeCacheSize (int cacheSize) {
        List<EntryNode>[] oldCache = cache;
        cache = new LinkedList[cacheSize];
        for (int i=0;i<oldCache.length;i++) {
            cache[i]=oldCache[i];
        }
        this.cacheSize = cacheSize;
        threshold = this.cacheSize * 10;
    }
    public void put(K k, V v) {
        int hash;
        if (k==null) {
            hash = 0;
        } else {
            hash = k.hashCode();
        }
        int index = hash%cacheSize;

        if (cache[index]==null) {
            cache[index] = new LinkedList<>();
        }
        EntryNode<K, V> node = new EntryNode(k, v);
        boolean isAdded = addNode(cache[index], node);

        if (isAdded) {
            size++;
        }

        if (size>threshold) {
            initializeCacheSize((int) (cacheSize  * 2));
        }
    }

    private boolean addNode(List<EntryNode> list, EntryNode node) {
        if (list.contains(node)) {
            list.remove(node);
            list.add(node);
            return false;
        }

        list.add(node);
        return true;
    }

    public V get(K k) {
        int hash;
        if (k==null) {
            hash = 0;
        } else {
            hash = k.hashCode();
        }

        int index = hash%cacheSize;

        for (EntryNode<K, V> en : cache[index]) {
            if (en.getKey().equals(k) && en.getHash()==hash) {
                return en.getValue();
            }
        }

        return null;
    }

    public void remove(K k) {
        int hash;
        if (k==null) {
            hash = 0;
        } else {
            hash = k.hashCode();
        }

        int index = hash%cacheSize;
        EntryNode<K, V> element=null;
        for (EntryNode<K, V> en : cache[index]) {
            if (en.getKey().equals(k) && en.getHash()==hash) {
                element = en;
                break;
            }
        }

        cache[index].remove(element);
    }
}
