
public class List<T> {

    private T[] list;
    private int numberOfValues;

    public List() {
        this(10);
    }

    public List(int size) {
        this.list = (T[]) new Object[size];
        this.numberOfValues = 0;
    }

    /**
     * @param value
     * @return saves the given value into the array
     */
    public void add(T value) {
        if (this.list.length == this.numberOfValues) {
            listEnlarge();
        }

        this.list[numberOfValues] = value;
        this.numberOfValues++;
    }

    /**
     * @param value
     * @return returns true if the list contains the value
     */
    public boolean contains(T value) {
        return itemIndex(value) >= 0;
    }

    /**
     * @param value
     * @return removes the given value from the list
     */
    public void remove(T value) {
        int removableIndex = itemIndex(value);
        if (removableIndex < 0) {
            return;
        }

        moveToLeft(removableIndex);
        this.numberOfValues--;
    }

    /**
     * @param index
     * @return returns the value from the given index
     */
    public T get(int index) {
        if (index < 0 || index >= this.numberOfValues) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.numberOfValues + "] scope.");
        }

        return this.list[index];
    }

    /**
     * @param value
     * @return returns the index of the given value
     */
    public int itemIndex(T value) {
        for (int i = 0; i < this.numberOfValues; i++) {
            if (this.list[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * @return returns the current size of the list.
     */
    public int size() {
        return this.numberOfValues;
    }

    /**
     * @param startingFromIndex
     */
    private void moveToLeft(int startingFromIndex) {
        for (int i = startingFromIndex; i < this.numberOfValues - 1; i++) {
            this.list[i] = this.list[i + 1];
        }
    }

    /**
     *
     */
    private void listEnlarge() {
        T[] newList = (T[]) new Object[this.list.length + this.list.length / 2];
        for (int i = 0; i < this.list.length; i++) {
            newList[i] = this.list[i];

            this.list = newList;
        }
    }
}
