package utilities;

/**
 * DictionaryADT.java
 *
 * @author Malek Mansour
 * @version 1.0
 *
 * Class Definition: This interface represents the public contract for the
 * implementation of Dictionary for the DictionaryADT Lab.
 *
 * @param <K> the type of keys maintained by this dictionary
 * @param <V> the type of mapped values
 */
public interface DictionaryADT<K, V> {

    /**
     * Inserts a key-value pair into the dictionary.
     *
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @throws IllegalArgumentException if the key is null or already exists in the dictionary
     */
    void insert(K key, V value);

    /**
     * Removes the key-value pair associated with the specified key from the dictionary.
     *
     * @param key the key whose mapping is to be removed from the dictionary
     * @return the previous value associated with key, or null if there was no mapping for key
     * @throws IllegalArgumentException if the key is null
     */
    V remove(K key);

    /**
     * Updates the value associated with a specified key in the dictionary.
     *
     * @param key the key whose associated value is to be updated
     * @param newValue the new value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no mapping for key
     * @throws IllegalArgumentException if the key is null or does not exist in the dictionary
     */
    V update(K key, V newValue);

    /**
     * Returns the value to which the specified key is mapped, or null if this dictionary contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this dictionary contains no mapping for the key
     * @throws IllegalArgumentException if the key is null
     */
    V lookup(K key);
}
