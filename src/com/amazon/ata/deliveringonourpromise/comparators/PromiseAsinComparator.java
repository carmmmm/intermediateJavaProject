package com.amazon.ata.deliveringonourpromise.comparators;

import com.amazon.ata.deliveringonourpromise.types.Promise;

import java.io.Serializable;
import java.util.Comparator;

public class PromiseAsinComparator implements Serializable, Comparator<Promise> {
    
    private static final long serialVersionUID = 1L;

    @Override
    public int compare(Promise o1, Promise o2) {
        String asinO1 = o1.getAsin();
        String asinO2 = o2.getAsin();
        return asinO1.compareTo(asinO2);
    }

}
