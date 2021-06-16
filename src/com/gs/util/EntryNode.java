package com.gs.util;

public class EntryNode<K, V> {
    private K key;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    private V value;

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public int hash;

    public EntryNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        EntryNode<K, V> en = (EntryNode<K, V>) o;
        return this.key.equals(en.key) && this.value.equals(en.value) && this.hash == en.hash;
    }
}
