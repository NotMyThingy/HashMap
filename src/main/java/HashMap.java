public class HashMap<K, V> {

    private List<Pair<K, V>>[] values;
    private int numberOfValues;

    public HashMap() {
        this.values = new List[32];
        this.numberOfValues = 0;
    }

    /**
     *
     * @param key
     * @param value
     * @return adds a new key-value pair into the HashMap. If the key already exists, its old value get replaced by a new.
     */
    public void add(K key, V value) {
        List<Pair<K, V>> valuePairList = getHashList(key);
        int index = findIndexByKey(valuePairList, key);

        if (index < 0) {
            valuePairList.add(new Pair<>(key, value));
            this.numberOfValues++;
        } else {
            valuePairList.get(index).setValue(value);
        }
    }


    /**
     * @param key
     * @return returns a value of a key-value pair. Returns 'null', if the value doesn't exist.
     */
    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            return null;
        }

        List<Pair<K, V>> valuePairsList = this.values[hashValue];

        for (int i = 0; i < valuePairsList.size(); i++) {
            if (valuePairsList.get(i).getKey().equals(key)) {
                return valuePairsList.get(i).getValue();
            }
        }

        return null;
    }

    private List<Pair<K, V>> getHashList(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            this.values[hashValue] = new List<>();
        }

        return this.values[hashValue];
    }

    private int findIndexByKey(List<Pair<K, V>> list, K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }
}
