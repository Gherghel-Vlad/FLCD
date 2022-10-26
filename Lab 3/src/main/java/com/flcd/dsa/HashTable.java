package com.flcd.dsa;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class HashTable<K extends String, V> {
    private ArrayList<HashNode<K, V>> hashNodes;
    private Utils utils;
    private int maxSize;

    public HashTable(final int maxSize) {
        this.hashNodes = new ArrayList<>();
        this.maxSize = maxSize;

        this.utils = new Utils(this.maxSize);

        for(int i=0;i<maxSize;i++){
            hashNodes.add(null);
        }
    }

    private HashNode<K, V> findHeadChainIndex(final K key){
        int hashCode = this.utils.getHashCodeFromString(key);
        HashNode<K, V> hashNode = this.hashNodes.get(hashCode);
        while(hashNode!= null && hashNode.getNextNode()!=null){
            hashNode = hashNode.getNextNode();
        }

        return hashNode;
    }

    public void addNode(final K key, final V value) {
        HashNode<K, V> lastNode = findHeadChainIndex(key);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value, utils.getHashCodeFromString(key));
        if (findValueByKey(key) == null) {
            if (lastNode == null) {
                this.hashNodes.add( utils.getHashCodeFromString(key), newNode);
            } else {
                lastNode.setNextNode(newNode);
                newNode.setNextNode(null);
            }
        }
        else{

        }
    }

    public V findValueByKey(final K key){
        HashNode<K, V> node = hashNodes.get(utils.getHashCodeFromString(key));

        while(node != null && !node.getKey().equals(key)){
            node = node.getNextNode();
        }

        return node == null ? null : node.getValue();
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "hashNodes=" + hashNodes +
                ", utils=" + utils +
                ", maxSize=" + maxSize +
                '}';
    }
}
