package com.flcd.dsa;

import java.util.stream.Stream;

public class Utils {
    private int hashTableSize;

    public Utils(final int hashTableSize) {
        this.hashTableSize = hashTableSize;
    }

    public int getHashCodeFromString(final String string){
        return string.chars().map( character -> (int)character).reduce(0, Integer::sum) % hashTableSize;
    }
}
