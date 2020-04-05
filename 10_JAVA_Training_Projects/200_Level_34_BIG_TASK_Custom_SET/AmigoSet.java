package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet <E> extends AbstractSet implements Serializable, Cloneable, Set {

    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;
    HashSet d;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<E, Object>(Integer.max(16, (int) Math.ceil(collection.size() / .75f)));
        addAll(collection);
    }

    @Override
    public boolean add(Object e) {
        int initialSize = map.size();
        map.put((E) e, PRESENT);
        if (map.size() > initialSize) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator <E> iterator() {
        Set<E> keys = map.keySet();
        return keys.iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        AmigoSet clone;
        try {
            clone = (AmigoSet) super.clone();
            clone.map = (HashMap) map.clone();
        } catch (Exception e) {
            throw new InternalError();
        }
        return clone;
    }

    private void writeObject(ObjectOutputStream oS) {
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        try {
            oS.defaultWriteObject();
            oS.writeInt(capacity);
            oS.writeFloat(loadFactor);
            oS.writeInt(map.size());
            for(E element : map.keySet()) {
                oS.writeObject(element);
            }
        } catch (IOException e) {}
    }

    private void readObject (ObjectInputStream iS) {
        try {
            iS.defaultReadObject();
            int capacity = iS.readInt();
            float loadFactor = iS.readFloat();
            int mapSize = iS.readInt();
            map = new HashMap<>(capacity, loadFactor);
            for (int i = 0; i < mapSize; i++) {
                E element = (E) iS.readObject();
                map.put(element, PRESENT);
            }

        } catch (Exception e) {}
    }


}
