package com.flcd.dsa;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HashNode<K, V> {
    private K key;
    private V value;
    private final int hashCode;

    private HashNode<K, V> nextNode;

    @Override
    public String toString() {
        return "HashNode{" +
                "key=" + key +
                ", value=" + value +
                ", hashCode=" + hashCode +
                ", nextNode=" + nextNode +
                (nextNode==null? "}\n": "}");
    }

    public HashNode(final K key, final V value, final int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}
