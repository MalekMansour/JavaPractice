package implementations;

import java.util.ArrayList;
import utilities.DictionaryADT;
import exceptions.DuplicateKeyException;

public class Dictionary<K,V> implements DictionaryADT<K,V>
{
    private static final int DEFAULT_SIZE = 10;
    private ArrayList<K> keys;
    private ArrayList<V> values;

    public Dictionary() {
        create(DEFAULT_SIZE);
    }

    public Dictionary(int size) {
        create(size);
    }

    @Override
    public void create(int size) {
        int initialCapacity = size > 0 ? size : DEFAULT_SIZE;
        keys = new ArrayList<>(initialCapacity);
        values = new ArrayList<>(initialCapacity);
    }

    @Override
    public boolean insert(K key, V value) throws DuplicateKeyException {
        if (key == null || value == null) {
            return false;
        }
        if (keys.contains(key)) {
            throw new DuplicateKeyException("Key already exists.");
        }
        keys.add(key);
        values.add(value);
        return true;
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            return null;
        }
        int index = keys.indexOf(key);
        if (index != -1) {
            keys.remove(index);
            return values.remove(index);
        }
        return null;
    }

    @Override
    public boolean update(K key, V value) {
        if (key == null || value == null) {
            return false;
        }
        int index = keys.indexOf(key);
        if (index != -1) {
            values.set(index, value);
            return true;
        }
        return false;
    }

    @Override
    public V lookup(K key) {
        if (key == null) {
            return null;
        }
        int index = keys.indexOf(key);
        return index != -1 ? values.get(index) : null;
    }
}
