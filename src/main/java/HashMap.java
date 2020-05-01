public class HashMap<K, V> {

    private List<Pair<K, V>>[] values;
    private int numberOfValues;

    public HashMap() {
        this.values = new List[32];
        this.numberOfValues = 0;
    }

    public V getValue(K key) {
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
}
