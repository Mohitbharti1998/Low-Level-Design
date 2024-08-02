package com.uditagarwal.cache.policies;


import com.uditagarwal.algoritms.DoublyLinkedList;
import com.uditagarwal.algoritms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Eviction policy based on LRU algorithm.
 *
 * @param <Key> Key type.
 */
public class LFUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private Map<Integer, DoublyLinkedList<Key>> mapOfDll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;
    private int minFreq = 0;

    public LFUEvictionPolicy() {
        this.mapOfDll = new HashMap<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if (mapper.containsKey(key)) {
            DoublyLinkedListNode<Key> curr = mapper.get(key);
            int freq = curr.getFreq();

            DoublyLinkedList<Key> dll = mapOfDll.get(freq);
            dll.detachNode(mapper.get(key));

            DoublyLinkedList<Key> nextDll = mapOfDll.getOrDefault(freq+1, new DoublyLinkedList<Key>());
            curr.setFreq(freq+1);
            nextDll.addNodeAtLast(curr);

        } else {
            DoublyLinkedList<Key> dll = mapOfDll.getOrDefault(1, new DoublyLinkedList<Key>());
            DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
            mapper.put(key, newNode);
            minFreq = 1;
        }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedList<Key> dll = mapOfDll.get(minFreq);
        DoublyLinkedListNode<Key> first = dll.getFirstNode();
        if(first == null) {
            return null;
        }
        dll.detachNode(first);
        if (!dll.isItemPresent()){
            minFreq++;
        }
        return first.getElement();
    }
}
